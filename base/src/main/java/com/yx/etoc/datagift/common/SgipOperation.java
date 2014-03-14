package com.yx.etoc.datagift.common;

import org.apache.log4j.Logger;

import com.huawei.smproxy.comm.sgip.message.SGIPSubmitMessage;
import com.huawei.smproxy.comm.sgip.message.SGIPSubmitRepMessage;

public class SgipOperation {
	
    private static Logger logger = Logger.getLogger(SgipOperation.class);

    /**
     * 此处发送短息为模拟用户上行，发送方号码与接收方号码相反 
     * @author 陈智
     * @param src 用户手机
     * @param dest 接入号
     * @param content 短信内容
     * @return true发送成功，false发送失败
     * @throws Exception 基本上不会抛出异常
     */
	public static boolean writeSMS(String src, String dest, String content)
			throws Exception {
		int sequenceId = 0;
		int tryTimes = 0;// 尝试次数
		boolean isSuccess = false;

		long startTime = System.currentTimeMillis();

		try {
			for (tryTimes = 0; tryTimes < SgipConfiguration.getSendTryTimes(); tryTimes++) {
				// 发送
				sequenceId = writeSMS0(src, dest, content);
				if (sequenceId != 0) {
					tryTimes++;
					isSuccess = true;
					break;
				}
			}
		} catch (Exception e) {
            logger.error(src + " writeSMS[" + isSuccess + "] to " + dest
                    + ", time=" + (System.currentTimeMillis() - startTime)
                    + ", tryTimes=" + tryTimes, e);
            e.printStackTrace();
            return isSuccess;
		}
		
        if (logger.isDebugEnabled())
        {
            logger.debug(src + " writeSMS[" + isSuccess + "] to " + dest
                    + ", time=" + (System.currentTimeMillis() - startTime)
                    + ", tryTimes=" + tryTimes);
        }
		return isSuccess;
	}

	/**
	 * 
	 * @param src 发送方号码	联通实现代用户订购，短信发送方填写用户手机号
	 * @param dest 接收方号码为接入号10010
	 * @param content
	 * @return
	 * @throws Exception
	 */
	static int writeSMS0(String src, String dest, String content)
			throws Exception {
		SgipSMConnection conn = null;
		
		try {

			conn = getConnection();

			if (conn == null) {
				logger.error("writeSMS error: SgipSMConnection[" + conn + "]");
				return 0;
			}

			int sequenceId = 0;
			String[] dests = new String[1];
			dests[0] = dest;

			byte[] buf2 = content.getBytes();
			SGIPSubmitMessage submitMsg = new SGIPSubmitMessage(
			// String SPNumber SP的接入号码 ，此处填写发送方号码
					src,
			// String ChargeNumber 付费号码，手机号码前加“86”国别标志
					"000000000000000000000",
			// String[] UserNumber 接收该短消息的号10010
					dests,
			// String CorpId 企业代码
					SgipConfiguration.getSpId(),
			// String ServiceType 业务代码
					SgipConfiguration.getServiceId(),
			// int FeeType 计费类型
					SgipConfiguration.getFeeType(),
			// String FeeValue 收费值，单位为分，由SP定义
					"0",
			// String GivenValue 赠送用户的话费，单位为分，由SP定义
					"0",
			// int AgentFlag 代收费标志，0：应收；1：实收
					0,
			// int MorelatetoMTFlag 引起MT消息的原因
					0,
			// int Priority 优先级0-9从低到高，默认为0
					0,
			// Date ExpireTime 短消息寿命的终止时间yymmddhhmmsstnnp
					null,
			// Date ScheduleTime 短消息定时发送的时间
					null,
			// int ReportFlag 状态报告标记
					2,
			// int TP_pid GSM协议类型
					1,
			// int TP_udhi GSM协议类型
					0,
			// int MessageCoding 短消息的编码格式
					15,
			// int MessageType 信息类型
					0,
			// int MessageLen 短消息的长度
					buf2.length,
			// byte[] MessageContent 短消息的内容
					buf2,
			// String reserve 保留，扩展用
					""
			);
			

			SGIPSubmitRepMessage ret = (SGIPSubmitRepMessage) conn
					.send(submitMsg);

            if (ret == null)
            {
                logger.error("Send [" + buf2
                        + "] from [" + src + "]to [" + dest
                        + "] RetCode [null] SequenceId [null]");
                return 0;
            }
            
            if (logger.isDebugEnabled())
            {
                logger.debug("Send [" + buf2
                        + "] from [" + src + "]to [" + dest + "] RetCode ["
                        + ret.getResult() + "] SequenceId ["
                        + ret.getSequenceId() + "]");
            }
            
            if (ret.getResult() == 0)
            {
            	sequenceId = ret.getSequenceId();
            }
            else
            {
                logger.error("Send [" + buf2
                        + "] from [" + src + "] to [" + dest + "] RetCode ["
                        + ret.getResult() + "] SequenceId ["
                        + ret.getSequenceId() + "]");
                return 0;
            }

			return sequenceId;

		} catch (java.io.IOException iex) {
            logger.error("writeSMS error: [" + iex.toString() + "]", iex);
            return 0;
		} finally {
			if (conn != null) {
				// 正在发送的线程减1
				conn.incSendCount();
				//conn.close();
				conn = null;
			}
		}
	}
	
	
	
    static SgipSMConnection getConnection() throws Exception
    {
        SgipSMConnection conn = null;
        int tryTimes = 0;
        
        while (conn == null)
        {
            conn = SgipSMConnectionManager.getInstance().getConnection();
            if (conn == null)
            {
                try
                {
                	
                	//休眠两秒
                    Thread.sleep(2000);
                    // 初始化连接
                	SgipSMConnectionManager.getInstance().initialize();
                    //比较连接数
                    if (tryTimes++ > SgipConfiguration.getConnCount())
                    {
                        break;
                    }
                }
                catch (Exception e)
                {
                	logger.error("SgipSMConnection::getConnection", e);
                }
            }
        }
        
        return conn;
    }

}
