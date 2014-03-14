package com.yx.etoc.datagift.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.huawei.smproxy.SGIPSMProxy;
import com.huawei.smproxy.comm.sgip.message.SGIPMessage;
import com.huawei.smproxy.util.Args;

public class SgipSMConnection extends SGIPSMProxy
{
	
    private static Logger logger = Logger.getLogger(SgipSMConnection.class);
    
	private int sendCount = 0;

	private long lastSendTime = 0;// 最后一次发送短信的时间

	public SgipSMConnection(Map<String, String> args)
	{
		super(args);
	}

	public SgipSMConnection(Args args)
	{
		super(args);
	}

	public boolean initialize() throws java.lang.Exception
	{
		return true;
	}

	public SGIPMessage send(SGIPMessage message) throws IOException
	{
		
        if (logger.isDebugEnabled())
        {
            logger.debug("sending thread :" + sendCount);
        }

		this.lastSendTime = System.currentTimeMillis();

		return super.send(message);
	}

	public int getSendCount()
	{
		return sendCount;
	}

	public void addSendCount()
	{
		sendCount++;
	}

	public void incSendCount()
	{
		sendCount--;
	}

	public long getLastSendTime()
	{
		return lastSendTime;
	}

	/**
	 * 
	 * 此处获取连接仅提供给SMConnectionManager获取
	 * 业务如需连接请在从方法SMConnectionManger中获取
	 * 
	 * @return
	 * @throws Exception
	 */
	public static SgipSMConnection createConnection() throws Exception
	{
		return createConnection(SgipConfiguration.getSourceaddr(),
				SgipConfiguration.getAddress(),
				SgipConfiguration.getPort(), 
				SgipConfiguration.getLoginName(),
				SgipConfiguration.getLoginPass(),
				SgipConfiguration.getTransactionTimeout());
	}

	public static SgipSMConnection createConnection(String sourceAddr,
			String host, String port, String loginName, String loginPass,  
			String transactionTimeout) throws Exception
	{
		HashMap map = new HashMap();
		
		// 网关IP
		map.put("host", host);
		// 网关端口
		map.put("port", port);
		// 操作超时时间(单位：秒)
		map.put("transaction-timeout", transactionTimeout);
		// 物理连接读操作超时时间(单位：秒) 0表示永不超时
		map.put("read-timeout", SgipConfiguration.getReadTimeOut());
		// NodeID(十位整数)
		map.put("source-addr", sourceAddr);
		// 双方协商的版本号(大于0，小于256)
		map.put("version", SgipConfiguration.getVersion());
		// 是否属于调试状态,true表示属于调试状态，所有的消息被打印输出到屏幕，false表示不属于调试状态，所有的消息不被输出
		map.put("debug", SgipConfiguration.getDebug());
		// 网关登陆名
		map.put("login-name", loginName);
		// 网关密码
		map.put("login-pass", loginPass);
	
        if (logger.isInfoEnabled())
        {
            logger.info("[createConnection] - " + host + ":" + port);
        }
        
		SgipSMConnection smConnection = new SgipSMConnection(map);
		return smConnection;
	}
	
}
