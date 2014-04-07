package com.yx.etoc.datagift.ct.web;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.jpush.api.JPushClient;
import cn.jpush.api.common.DeviceEnum;
import cn.jpush.api.push.CustomMessageParams;
import cn.jpush.api.push.MessageResult;
import cn.jpush.api.push.NotificationParams;
import cn.jpush.api.push.ReceiverTypeEnum;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.yx.baseframe.util.BaseController;
import com.yx.etoc.datagift.common.GlobalConstants;
import com.yx.etoc.datagift.ct.entity.DgCtUser;
import com.yx.etoc.datagift.ct.service.UserBS;
import com.yx.etoc.datagift.ct.web.vo.DgCtInfoVO;
import com.yx.etoc.datagift.task.service.TaskUserRelBS;

@Controller
@RequestMapping("/dg/ua")
public class UAController extends BaseController {
	@Autowired
	private UserBS userBS;
	@Autowired
	private TaskUserRelBS taskUserRelBS;
	/**
	 * 客户端UA验证  已注册用户 -比对登陆环境信息，如果不相同写信息变更表
	 * 			        未注册用户-直接返回客户端版本信息
	 * @param usr
	 * @return dgctinfo
	 */
	@ResponseBody
	@RequestMapping(value="/init",method=RequestMethod.POST)
	public Map<String,String> init(@RequestBody DgCtUser usr){
		Map<String,String> rsMap = Maps.newHashMap();
		DgCtInfoVO ct = new DgCtInfoVO();
		ct.setOutVs("1.2");
		ct.setUpgrageType("2");
		ct.setFileSize("10MB");
		ct.setIp(this.getRequest().getRemoteAddr());
		ct.setServertime(System.currentTimeMillis()+"");
		ct.setFilePath("http://channel.looklook.cn:8091/download/api/download.do?productcode=3&systemcode=101");
		ct.setVsRemark("优化了程序的速度");
		rsMap.put("outVs", ct.getOutVs());
		rsMap.put("ip", ct.getIp());
		rsMap.put("upgrageType", ct.getUpgrageType());
		rsMap.put("fileSize", ct.getFileSize());
		rsMap.put("filePath", ct.getFilePath());
		rsMap.put("vsRemark", ct.getVsRemark());
		rsMap.put("servertime", ct.getServertime());
		if(usr == null){
			rsMap.put("status",GlobalConstants.CT_PARAM_NULL);
			return rsMap;
		}
		if("".equals(usr.getUserId())){
			//未注册用户
			rsMap.put("status",GlobalConstants.CT_OK);
			return rsMap;
		}else{
			//已经注册
			rsMap.put("status",GlobalConstants.CT_OK);
			return rsMap;
		}
	}
	@ResponseBody
	@RequestMapping("/home")
	public Map<String,Object> homeInfo(@RequestBody String rquestParam){
		Map<String, Object> rsMap = Maps.newHashMap();
		JSONObject obj = JSONObject.fromObject(rquestParam);
		if (obj.isEmpty()) {
			rsMap.put("status", GlobalConstants.CT_PARAM_NULL);
			return rsMap;
		}
		String userid = obj.getString("userid");
		DgCtUser user = this.userBS.getEntityById(DgCtUser.class, userid);
		if(user !=null){
			List<String> urlLists = Lists.newArrayList(); 
			urlLists.add("http://www.songliuliang.com/woapp/jsp/images/banner1.jpg");
			urlLists.add("http://www.songliuliang.com/woapp/jsp/images/banner2.jpg");
			
			List<String> speakLists = Lists.newArrayList(); 
			speakLists.add("恭喜用户DG001 获得100积分奖励");
			speakLists.add("买100送50活动即将开启");
			speakLists.add("新的版本即将上线，敬请期待");
			
			rsMap.put("status", GlobalConstants.CT_OK);
			rsMap.put("point", user.getRemainCredit());
			rsMap.put("refreshtime", System.currentTimeMillis());
			rsMap.put("extradata", "10");
			rsMap.put("data", "20");
			rsMap.put("pkgname", "198元\n B套餐");
			rsMap.put("banners", urlLists);
			rsMap.put("speakers", speakLists);
			if(taskUserRelBS.checkDayTask(user.getUserId(), GlobalConstants.CT_TASK_DAY_SIGN)){
				rsMap.put("daysign", "1");
			}else{
				rsMap.put("daysign", "0");
			}
			return rsMap;
		}else{
			rsMap.put("status", GlobalConstants.CT_NO_USR);
			return rsMap;
		}
	}
	@ResponseBody
	@RequestMapping(value="/test")
	public String test(){
		JPushClient jpushClient = new JPushClient("01e7f470a80eb208b045b886","81a6e151f4e1660144f61317",120,DeviceEnum.Android,false);
		CustomMessageParams params = new CustomMessageParams();
		params.setReceiverType(ReceiverTypeEnum.TAG);
		params.setReceiverValue("datagift");
	//	MessageResult msgResult = jpushClient.sendCustomMessage("号外号外","冲100返100W", params, null);
		NotificationParams nparams = new NotificationParams();
		//nparams.setAndroidNotificationTitle("这个是莫比");
		nparams.setReceiverType(ReceiverTypeEnum.TAG);
		nparams.setReceiverValue("datagift");
		Map<String, Object> extras = Maps.newHashMap();
		extras.put("n_content", "");
		extras.put("n_extras", "xxxxxxx");
		MessageResult msgResult=jpushClient.sendNotification("", nparams, extras);
		if (msgResult.isResultOK()) {
		   System.out.println("msgResult - " + msgResult);
		   System.out.println("messageId - " + msgResult.getMessageId());
		} else {
		    if (msgResult.getErrorCode() > 0) {
		        // 业务异常
		       System.out.println("Service error - ErrorCode: "
		                + msgResult.getErrorCode() + ", ErrorMessage: "
		                + msgResult.getErrorMessage());
		    } else {
		        // 未到达 JPush 
		       System.out.println("Other excepitons - "
		                + msgResult.responseResult.exceptionString);
		    }
		}
		return "";
	}
}
