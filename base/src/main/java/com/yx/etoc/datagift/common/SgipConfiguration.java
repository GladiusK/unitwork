package com.yx.etoc.datagift.common;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class SgipConfiguration
{
	// -----------------------------------------
	//public static SgipSMConnectionManager sgipConnectionManager;
	
    private static final Logger logger4conf = Logger.getLogger(SgipConfiguration.class);

	// true表示属于调试状态，所有的消息被打印输出到屏幕，false表示不属于调试状态，所有的消息不被输出
	public final static String DEFAULT_SGIP_DEBUG = "false";

	// 双方协商的版本号(大于0，小于256)
	public final static String DEFAULT_SGIP_VERSION = "12";

	// 操作超时时间(单位：秒)
	public final static String DEFAULT_SGIP_TRANSACTION_TIMEOUT = "10";

	// 短信端口
	public final static String DEFAULT_SGIP_DISPLAYPORT = "10010";

	// 短信网关开放端口
	public final static String DEFAULT_SGIP_PORT = "8801";
	
	// fee_Type 资费类别
	public final static int DEFAULT_SGIP_FEETYPE = 0;
	
	// 网关分配的用户名
	public final static String DEFAULT_SGIP_LOGINNAME = "";
	
	//网关分配的密码
	public final static String DEFAULT_SGIP_LOGINPASS = "";
	
	// 订购联通体验WLAN短信指令
	public final static String DEFAULT_SGIP_SM_CONTENT = "TYWLAN";

	// 短信通道数目
	public final static int DEFAULT_SGIP_MAXDEPTH = 8;

	// 短信通道连接数
	public final static int DEFAULT_SGIP_CONNCOUNT = 5;

	// 短信发送重试次数
	public final static int DEFAULT_SGIP_SENDTRYTIMES = 3;
	
	//物理连接读操作超时时间(单位：秒) 0表示永不超时
	public final static int DEFAULT_SGIP_READTIMEOUT = 30;

	//&&&&&&&&&&&&&&&&&& 联通号码段 update by lijia 2011-6-14
	public final static String DEFAULT_REG_UNICOM = "";
	//&&&&&&&&&&&&&&&&&&
	//MML重发次数
	public final static int DEFAULT_MML_RESEND_TIMES = 3;
	// -----------------------------------------

	// true表示属于调试状态，所有的消息被打印输出到屏幕，false表示不属于调试状态，所有的消息不被输出
	public final static String KEY_SGIP_DEBUG = "sgip.debug";

	// 双方协商的版本号(大于0，小于256)
	public final static String KEY_SGIP_VERSION = "sgip.version";

	// 心跳信息发送间隔时间(单位：秒)
	public final static String KEY_SGIP_HEARTBEAT_INTERVAL = "sgip.heartbeat.interval";

	// 连接中断时重连间隔时间(单位：秒)
	public final static String KEY_SGIP_RECONNECT_INTERVAL = "sgip.reconnect.interval";

	// 需要重连时，连续发出心跳而没有接收到响应的个数（单位：个)
	public final static String KEY_SGIP_HEARTBEAT_NORESPONSEOUT = "sgip.heartbeat.noresponseout";

	// ISMG主机地址的IP地址
	public final static String KEY_SGIP_ADDRESS = "sgip.address";

	// ISMG主机开发的端口号
	public final static String KEY_SGIP_PORT = "sgip.port";

	// SP向ISMG申请的ID(最大为十位字符)
	public final static String KEY_SGIP_SOURCEADDR = "sgip.sourceaddr";

	// 由中国联通与ICP事先商定，SP向ISMG申请的ID所对应的密码
	public final static String KEY_SGIP_TRANSACTION_SHAREDSECRET = "sgip.sharedsecret";

	// 操作超时时间(单位：秒)
	public final static String KEY_SGIP_TRANSACTION_TIMEOUT = "sgip.transaction.timeout";

	// 短信端口
	public final static String KEY_SGIP_DISPLAYPORT = "sgip.displayport";

	// SP_Id
	public final static String KEY_SGIP_SPID = "sgip.spid";

	// Service_Id
	public final static String KEY_SGIP_SERVICEID = "sgip.serviceid";

	// fee_Type 资费类别
	// 01：对“计费用户号码”免费
	// 02：对“计费用户号码”按条计信息费
	// 03：对“计费用户号码”按包月收取信息费
	// 04：对“计费用户号码”的信息费封顶
	// 05：对“计费用户号码”的收费是由SP实现
	public final static String KEY_SGIP_FEETYPE = "sgip.feetype";

	// 连接数
	public final static String KEY_SGIP_CONNCOUNT = "sgip.conncount";

	// 短信通道数目
	public final static String KEY_SGIP_MAXDEPTH = "sgip.maxdepth";

	// 短信发送重试次数
	public final static String KEY_SGIP_SENDTRYTIMES = "sgip.sendtrytimes";
	
	//物理连接读操作超时时间(单位：秒) 0表示永不超时
	public final static String KEY_SGIP_READ_TIMEOUT = "sgip.read.timeout";

	//登陆用户名(最大为六位字符)
	public final static String KEY_SGIP_LOGIN_NAME = "sgip.login.name";
	
	//登陆密码
	public final static String KEY_SGIP_LOGIN_PASS = "sgip.login.pass";
	
	// 订购体验WLAN指令
	public final static String KEY_SGIP_SM_CONTENT = "sgip.smContent";
	
	//&&&&&&&&&&&&&&&&&& 联通号码段 update by lijia 2011-6-14
	public final static String KEY_REG_UNICOM = "check.reg.unicom";
	//&&&&&&&&&&&&&&&&&
	
	// MML命令重发次数
	private  final static String KEY_MML_RESEND_TIMES="mml.resend.times";
	
	private static String debug = DEFAULT_SGIP_DEBUG;

	private static String version = DEFAULT_SGIP_VERSION;

	private static String transactionTimeout = DEFAULT_SGIP_TRANSACTION_TIMEOUT;

	private static String displayPort = DEFAULT_SGIP_DISPLAYPORT;

	private static int feeType = DEFAULT_SGIP_FEETYPE;

	private static String port = DEFAULT_SGIP_PORT;

	private static String address;

	private static String sourceaddr;

	private static String spId;

	private static String serviceId;
	
	private static String loginName = DEFAULT_SGIP_LOGINNAME;
	
	private static String loginPass = DEFAULT_SGIP_LOGINPASS;
	
	private static String smContent = DEFAULT_SGIP_SM_CONTENT;

	private static int connCount = DEFAULT_SGIP_CONNCOUNT;

	private static int maxDepth = DEFAULT_SGIP_MAXDEPTH;

//	private static int checkOvertime = DEFAULT_SGIP_CHECK_OVERTIME;

	private static int sendTryTimes = DEFAULT_SGIP_SENDTRYTIMES;
	
	private static int readTimeOut = DEFAULT_SGIP_READTIMEOUT;
	
	//&&&&&&&&&&&&&&&&&& 联通号码段 update by lijia 2011-6-14
	public  static String regUnicom = DEFAULT_REG_UNICOM;
	//&&&&&&&&&&&&&&&&&&
	
	private static int mmlResendTimes = DEFAULT_MML_RESEND_TIMES;
	
    public static void loadOnStartup()
    {
        Properties properties = new Properties();
        InputStream in = null;
        
        try
        {
            in = SgipConfiguration.class.getResourceAsStream("/config.properties");
            properties.load(in);
        }
        catch (IOException ioe)
        {
            logger4conf.error("Load Configuration from 'config.properties'", ioe);
            return;
        }
        finally
        {
        	if (in != null)
             {
                 try
                 {
                     in.close();
                 }
                 catch (IOException e1)
                 {
                	 logger4conf.error(e1);
                 }
             }
        }
        
        loadOnStartup(properties);
        if (logger4conf.isInfoEnabled())
        {
            StringBuffer smpp_sb = new StringBuffer("Load Configuration from 'config.properties' ... OK"
                    + System.getProperty("line.separator"));
            SgipConfiguration.dump(smpp_sb);
            logger4conf.info(smpp_sb);
        }
		
        //初始化 SGIP通信服务器
        SgipSMConnectionManager.getInstance().initialize();
    }
	
	public static void loadOnStartup(Properties properties)
	{
		
		debug = properties.getProperty(KEY_SGIP_DEBUG, DEFAULT_SGIP_DEBUG);
		version = properties.getProperty(KEY_SGIP_VERSION, DEFAULT_SGIP_VERSION);
		
		port = properties.getProperty(KEY_SGIP_PORT, DEFAULT_SGIP_PORT);
		
		sourceaddr = properties.getProperty(KEY_SGIP_SOURCEADDR);
		transactionTimeout = properties.getProperty(
				KEY_SGIP_TRANSACTION_TIMEOUT, DEFAULT_SGIP_TRANSACTION_TIMEOUT);

		displayPort = properties.getProperty(KEY_SGIP_DISPLAYPORT,
				DEFAULT_SGIP_DISPLAYPORT);
		
		spId = properties.getProperty(KEY_SGIP_SPID);
		serviceId = properties.getProperty(KEY_SGIP_SERVICEID);

		loginName = properties.getProperty(KEY_SGIP_LOGIN_NAME, DEFAULT_SGIP_LOGINNAME);
		loginPass = properties.getProperty(KEY_SGIP_LOGIN_PASS, DEFAULT_SGIP_LOGINPASS);
		
		smContent = properties.getProperty(KEY_SGIP_SM_CONTENT, DEFAULT_SGIP_SM_CONTENT);
		
		//&&&&&&&&&&&&&&&&&& 联通号码段 update by lijia 2011-6-14
		regUnicom = properties.getProperty(KEY_REG_UNICOM, DEFAULT_REG_UNICOM);
		//&&&&&&&&&&&&&&&&&&
		
		
		
		try {
			InetAddress tmpAddress = InetAddress.getByName(properties.getProperty(KEY_SGIP_ADDRESS));
			address = tmpAddress.getHostAddress();
		}
		catch (Exception ex)
		{
            try
            {
                address = InetAddress.getLocalHost().getHostAddress();
            }
            catch (UnknownHostException e1)
            {
                logger4conf.error("get localaddress error: ", e1);
            }
		}       
			
		try{
			feeType = DEFAULT_SGIP_FEETYPE;
		
			String value = properties.getProperty(KEY_SGIP_FEETYPE);
			if (null != value)
			{
				feeType = Integer.parseInt(value.trim());
			}
		}
		catch (Exception ex)
		{
			feeType = DEFAULT_SGIP_FEETYPE;
		}
		
		
		
		try
		{
			connCount = DEFAULT_SGIP_CONNCOUNT;

			String value = properties.getProperty(KEY_SGIP_CONNCOUNT);
			if (value != null)
			{
				connCount = Integer.parseInt(value.trim());
			}
		}
		catch (Exception ex)
		{
			connCount = DEFAULT_SGIP_CONNCOUNT;
		}

		try
		{
			maxDepth = DEFAULT_SGIP_MAXDEPTH;

			String value = properties.getProperty(KEY_SGIP_MAXDEPTH);
			if (value != null)
			{
				maxDepth = Integer.parseInt(value.trim());
			}
		}
		catch (Exception ex)
		{
			maxDepth = DEFAULT_SGIP_MAXDEPTH;
		}

		try
		{
			sendTryTimes = DEFAULT_SGIP_SENDTRYTIMES;

			String value = properties.getProperty(KEY_SGIP_SENDTRYTIMES);
			if (value != null)
			{
				sendTryTimes = Integer.parseInt(value.trim());
			}
		}
		catch (Exception ex)
		{
			sendTryTimes = DEFAULT_SGIP_SENDTRYTIMES;
		}
		
		try
		{
			readTimeOut = DEFAULT_SGIP_READTIMEOUT; 
			String value = properties.getProperty(KEY_SGIP_READ_TIMEOUT);
			if (value != null )
			{
				readTimeOut = Integer.parseInt(value.trim());
			}
		}
		catch (Exception ex)
		{
			readTimeOut = DEFAULT_SGIP_READTIMEOUT;
		}
		
		try
		{
			mmlResendTimes = DEFAULT_MML_RESEND_TIMES;
			String value = properties.getProperty(KEY_MML_RESEND_TIMES);
			if (value != null)
			{
				mmlResendTimes = Integer.parseInt(value.trim());
			}
		}
		catch (Exception ex)
		{
			mmlResendTimes = DEFAULT_MML_RESEND_TIMES;
		}
		
	}

	public static void reload(Properties properties)
	{
		loadOnStartup(properties);
	}

	public static void dump(StringBuffer sb)
	{
		String lineSeparator = System.getProperty("line.separator");

		sb.append(KEY_SGIP_DEBUG + " = " + debug + lineSeparator);
		sb.append(KEY_SGIP_VERSION + " = " + version + lineSeparator);

		sb.append(KEY_SGIP_TRANSACTION_TIMEOUT + " = " + transactionTimeout
				+ lineSeparator);

		sb.append(KEY_SGIP_DISPLAYPORT + " = " + displayPort + lineSeparator);

		sb.append(KEY_SGIP_CONNCOUNT + " = " + connCount + lineSeparator);
		sb.append(KEY_SGIP_MAXDEPTH + " = " + maxDepth + lineSeparator);

		sb.append(KEY_SGIP_FEETYPE + " = " + feeType + lineSeparator);

		sb.append(KEY_SGIP_PORT + " = " + port + lineSeparator);
		sb.append(KEY_SGIP_ADDRESS + " = " + address + lineSeparator);

		sb.append(KEY_SGIP_SPID + " = " + spId + lineSeparator);
		sb.append(KEY_SGIP_SERVICEID + " = " + serviceId + lineSeparator);
		
		
		
		sb.append(KEY_SGIP_SOURCEADDR + " = " + sourceaddr + lineSeparator);
		sb.append(KEY_SGIP_TRANSACTION_SHAREDSECRET + " = " + transactionTimeout + lineSeparator);	
		sb.append(KEY_SGIP_SENDTRYTIMES + " = " + sendTryTimes + lineSeparator);
		sb.append(KEY_SGIP_READ_TIMEOUT + " = " + readTimeOut + lineSeparator);
		sb.append(KEY_SGIP_LOGIN_NAME + " = " + loginName + lineSeparator);
		sb.append(KEY_SGIP_LOGIN_PASS + " = " + loginPass + lineSeparator);
		sb.append(KEY_SGIP_SM_CONTENT + " = " + smContent + lineSeparator);
		//&&&&&&&&&&&&&&&&&& 联通号码段 update by lijia 2011-6-14
		sb.append(KEY_REG_UNICOM + " = " + regUnicom + lineSeparator);
		//&&&&&&&&&&&&&&&&&&
		sb.append(KEY_MML_RESEND_TIMES + " = " + mmlResendTimes + lineSeparator);
	}

	public static String getDebug() {
		return debug;
	}

	public static void setDebug(String debug) {
		SgipConfiguration.debug = debug;
	}

	public static String getVersion() {
		return version;
	}

	public static void setVersion(String version) {
		SgipConfiguration.version = version;
	}

	public static String getTransactionTimeout() {
		return transactionTimeout;
	}

	public static void setTransactionTimeout(String transactionTimeout) {
		SgipConfiguration.transactionTimeout = transactionTimeout;
	}

	public static String getDisplayPort() {
		return displayPort;
	}

	public static void setDisplayPort(String displayPort) {
		SgipConfiguration.displayPort = displayPort;
	}

	public static int getConnCount() {
		return connCount;
	}

	public static void setConnCount(int connCount) {
		SgipConfiguration.connCount = connCount;
	}

	public static int getMaxDepth() {
		return maxDepth;
	}

	public static void setMaxDepth(int maxDepth) {
		SgipConfiguration.maxDepth = maxDepth;
	}

	public static int getFeeType() {
		return feeType;
	}

	public static void setFeeType(int feeType) {
		SgipConfiguration.feeType = feeType;
	}

	public static String getPort() {
		return port;
	}

	public static void setPort(String port) {
		SgipConfiguration.port = port;
	}

	public static String getAddress() {
		return address;
	}

	public static void setAddress(String address) {
		SgipConfiguration.address = address;
	}

	public static String getSourceaddr() {
		return sourceaddr;
	}

	public static void setSourceaddr(String sourceaddr) {
		SgipConfiguration.sourceaddr = sourceaddr;
	}

	public static String getSpId() {
		return spId;
	}

	public static void setSpId(String spId) {
		SgipConfiguration.spId = spId;
	}

	public static String getServiceId() {
		return serviceId;
	}

	public static void setServiceId(String serviceId) {
		SgipConfiguration.serviceId = serviceId;
	}

	public static int getSendTryTimes() {
		return sendTryTimes;
	}

	public static void setSendTryTimes(int sendTryTimes) {
		SgipConfiguration.sendTryTimes = sendTryTimes;
	}

	public static String getLoginName() {
		return loginName;
	}

	public static void setLoginName(String loginName) {
		SgipConfiguration.loginName = loginName;
	}

	public static String getLoginPass() {
		return loginPass;
	}

	public static String getSmContent() {
		return smContent;
	}

	public static void setSmContent(String smContent) {
		SgipConfiguration.smContent = smContent;
	}

	public static void setLoginPass(String loginPass) {
		SgipConfiguration.loginPass = loginPass;
	}

	public static int getReadTimeOut() {
		return readTimeOut;
	}

	public static void setReadTimeOut(int readTimeOut) {
		SgipConfiguration.readTimeOut = readTimeOut;
	}
	//&&&&&&&&&&&&&&&&&& 联通号码段 update by lijia 2011-6-14
	public static String getRegUnicom() {
		return regUnicom;
	}

	public static void setRegUnicom(String regUnicom) {
		SgipConfiguration.regUnicom = regUnicom;
	}
	//&&&&&&&&&&&&&&&&&&

	public static int getMmlResendTimes() {
		return mmlResendTimes;
	}

	public static void setMmlResendTimes(int mmlResendTimes) {
		SgipConfiguration.mmlResendTimes = mmlResendTimes;
	}
	
	
}
