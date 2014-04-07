package com.yx.etoc.datagift.common;

public class GlobalConstants {
	//手机注册验证码
	public static final String TEL_REG_CACHE = "telGegCache";
	// 应用的上下文路径
	public static String APP_CONTEXT_PATH = "base-web";
	// 应用部署的物理路径
	public static String APP_REAL_PATH;
	public static final String CT_OK = "0";
	//客户端参数数量不匹配
	public static final String CT_PARAM_NUM_NOMACHE = "138000";
	//客户端参数类型问题
	public static final String CT_PARAM_TYPE_NOMACHE = "138100";
	//客户端参数有空值
	public static final String CT_PARAM_NULL = "138101";
	//数据不存在
	public static final String CT_DATA_NOMACHE = "138102";
	//密码不合法
	public static final String CT_PASS_NOMACHE = "138103";
	//手机号不合法
	public static final String CT_PHONE_NOMACHE = "138104";
	//客户黑名单
	public static final String CT_USR_NOVALID = "138105";
	//ip、mac或imei被屏蔽
	public static final String CT_NOVALID = "138110";
	//没有权限
	public static final String CT_USR_NOAUTH = "138111";
	//已参加过活动
	public static final String CT_USR_NOAGAIN_IN = "138112";
	//验证码无效
	public static final String TEL_REG_NOMACHE = "138113";
	//客户端参数名称不匹配
	public static final String CT_PARAM_NOMACHE = "138114";
	//用户不存在
	public static final String CT_NO_USR = "138115";
	//用户已经注册
	public static final String CT_USR_EXIST = "138116";
	//用户已经签到
	public static final String CT_USR_DAYSIGN_AGAIN = "138117";
	//应用不存在
	public static final String CT_APP_NOEXIST = "138118";
	//改用户已经进行过下载
	public static final String CT_APP_USER_ALREADY_DOWN = "138119";
	
	
	//任务类型
	//每日签到
	public static final String CT_TASK_DAY_SIGN = "1";
	//每日下载流量应用
	public static final String CT_TASK_DAY_FLOW_DOWNLOAD = "21";
	//每日下载非流量应用
	public static final String CT_TASK_DAY_NOFLOW_DOWNLOAD = "22";
	
	//积分类型
	//每日签到
	public static final String CT_CD_DAY_SIGN = "1";
	//下载流量应用
	public static final String CT_CD_FLOW_DOWNLOAD = "21";
	//下载非流量应用
	public static final String CT_CD_NOFLOW_DOWNLOAD = "22";
	//升级奖励积分
	public static final String CT_CD_GRADE_UP ="3";
	
	//积分关系
	//增加
	public static final String CT_CD_CREDIT_REL_ADD = "1";
	//减少
	public static final String CT_CD_CREDIT_REL_REDUCE = "2";
}
