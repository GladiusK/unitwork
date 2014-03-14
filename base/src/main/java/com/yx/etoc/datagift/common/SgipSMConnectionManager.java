package com.yx.etoc.datagift.common;

import java.util.Vector;

import org.apache.log4j.Logger;


public class SgipSMConnectionManager{
	
    // 输出句柄
    private Logger logger = Logger.getLogger(SgipSMConnectionManager.class);
    
    private static SgipSMConnectionManager smConnectionMan = null;
    
    private Vector<SgipSMConnection> connList = null;
    
    //当前连接池状态是否在检查连接
    private boolean isCheckConnection = false;
    
    // 是否关闭连接池
    private boolean isClosed = false;
    
	/**
	 * 私有的构造函数
	 */
	private SgipSMConnectionManager()
	{
	}
	
	public static SgipSMConnectionManager getInstance(){
		if ( null == smConnectionMan)
			smConnectionMan = new SgipSMConnectionManager();
		
		return smConnectionMan;
	}
	

	/**
	 * 根据短信发送端口，从SMConnection容器中得到可用的连接
	 * 
	 * @param messagePort
	 * @return
	 */
	public synchronized SgipSMConnection getConnection() throws Exception
	{

		SgipSMConnection conn = null;

		int maxSend = SgipConfiguration.getMaxDepth();
		int curSend = maxSend;
		int pos = 0;

		// 得到当前正在发送的线程数最少的连接
		for (int i = 0; i < connList.size(); i++)
		{
			conn = connList.get(i);
			// 正在发送的线程数少于最大线程数&&连接可用
			if (conn.getSendCount() < SgipConfiguration.getMaxDepth()
					&& conn.getConnState() == null)
			{
				if (conn.getSendCount() < curSend)
				{
					pos = i;
					curSend = conn.getSendCount();
				}
			}
			else if(conn.getConnState() != null)
			{
				conn.close();
				SgipSMConnectionManager.getInstance().removeList(conn);
			}
		}

		if (curSend != maxSend)
		{
			conn = connList.get(pos);
			// 正在发送的线程加
			conn.addSendCount();
			return conn;
		}
		
		return null;
	}

	/**
	 * 初始连接
	 * @return
	 */
	public boolean initialize()
	{
		if (connList == null)
			connList = new Vector<SgipSMConnection>();
		
		int countSize = connList.size();
				
		//初始化连接，根据配置量来确定连接量
		for (int i = 0; i < SgipConfiguration.getConnCount() - countSize; i++)
		{
			try
			{
				try
				{
					//初始化连接对象
					SgipSMConnection conn = SgipSMConnection.createConnection();
					//建立连接
					conn.connect(SgipConfiguration.getLoginName(), SgipConfiguration.getLoginPass());
					//使用内部集合保存连接对象
					connList.add(conn);
				}
				catch (Exception e)
				{
		            logger.error(SgipConfiguration.getDisplayPort()
		                    + " SgipSMConnectionManager init connection error:"
		                    + e.toString(), e);
				}
			}
			catch (Exception e)
			{
                logger.error(SgipConfiguration.getDisplayPort()
                        + " SgipSMConnectionManager init connection error:"
                        + e.toString(), e);
			}
		}
		
        if (logger.isInfoEnabled())
        {
            logger.info(SgipConfiguration.getDisplayPort()
                    + " SgipSMConnectionManager init connection success number:"
                    + connList.size());
        }

		return (connList.size() > 0);
	}
	
	
	public boolean removeList(Object obj)
	{
		return this.connList.remove(obj);
	}
}
