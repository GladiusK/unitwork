package com.yx.etoc.datagift.ct.web;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.yx.baseframe.util.BaseController;
import com.yx.baseframe.util.EhcacheUtils;
import com.yx.baseframe.util.RandomUtils;
import com.yx.etoc.datagift.cd.entity.DgCdInfoH;
import com.yx.etoc.datagift.common.GlobalConstants;
import com.yx.etoc.datagift.ct.entity.DgCtUser;
import com.yx.etoc.datagift.ct.service.UserBS;
import com.yx.etoc.datagift.task.service.TaskUserRelBS;

@Controller
@RequestMapping("/dg/user")
public class UserController extends BaseController {
	@Autowired
	private UserBS userBS;
	
	@Autowired
	private TaskUserRelBS taskUserRelBS;
	
	@ResponseBody
	@RequestMapping(value = "/test")
	public void test(@RequestBody String rquestParam) throws IOException{
//		RestTemplate restTemplate = new RestTemplate();
//		Map<String ,Object> urlVariables = Maps.newHashMap();
//		 urlVariables.put("sendNum", "18502717626"); 
//		 urlVariables.put("content", "短信测试"); 
//		 String url = "http://113.57.230.8:8080/APOP-DSH/SendSms";
//		 String msg = restTemplate.postForObject(url, null, String.class, urlVariables);
//		 System.out.println(msg);
//		JSONObject obj = JSONObject.fromObject(rquestParam);
//		obj.getString("test");
		DgCtUser user = new DgCtUser();
		String userid = RandomUtils.uuid2();
		user.setUserId(userid);
		user.setTelNum("18333333333");
		user.setPass("123");
		user.setNickname("王瑞");
		user.setImei("jljjlljlkjkl");
		user.setSex("1");
		user.setMac("ljljl");
		user = userBS.createNewUser(user);
	}
	/**
	 * @Title: register
	 * @Description: TODO(客户端用户注册)
	 * @param @param user
	 * @param @return 设定文件
	 * @return Map<String,String> 返回类型
	 * @throws
	 */
	@ResponseBody
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public Map<String, Object> register(@RequestBody String rquestParam)  {
		Map<String, Object> rsMap = Maps.newHashMap();
		JSONObject obj = JSONObject.fromObject(rquestParam);
		if (obj.isEmpty()) {
			rsMap.put("status", GlobalConstants.CT_PARAM_NULL);
			return rsMap;
		}
		String tel = obj.getString("tel");
		String cacheName = obj.getString("cacheName");
		if(!GlobalConstants.TEL_REG_CACHE.equals(cacheName)){
			rsMap.put("status", GlobalConstants.TEL_REG_NOMACHE);
			return rsMap;
		}
		// 客户端验证码
		String ctCode = obj.getString("code");
		// 服务端验证码
		String code = (String) EhcacheUtils.get(cacheName,
				tel);
		DgCtUser tmp = this.userBS.getEntityByProperty(DgCtUser.class, "telNum", tel);
		if (StringUtils.isBlank(code) || !StringUtils.equals(code, ctCode)) {
			rsMap.put("status", GlobalConstants.TEL_REG_NOMACHE);
			return rsMap;
		} else if(tmp != null){
			rsMap.put("status", GlobalConstants.CT_USR_EXIST);
			return rsMap;
		}else {
			DgCtUser user = new DgCtUser();
			// 保存用户到数据库
			String userid = RandomUtils.uuid2();
			user.setUserId(userid);
			user.setTelNum(tel);
			user.setPass(obj.getString("password"));
			user.setNickname(obj.getString("nickname"));
			user.setImei(obj.getString("imei"));
			user.setSex(obj.getString("sex"));
			user.setMac(obj.getString("mac"));
			user = userBS.createNewUser(user);
			rsMap.put("userid", userid);
			rsMap.put("status", GlobalConstants.CT_OK);
			rsMap.put("userid", user.getUserId());
			rsMap.put("nickname", user.getNickname());
			rsMap.put("headimageurl", user.getImgPath());
			rsMap.put("sex", user.getSex());
			rsMap.put("level ", user.getGrade());
			rsMap.put("exp", user.getExpe());
			rsMap.put("tel", user.getTelNum());
			rsMap.put("point", user.getRemainCredit());
			return rsMap;
		}
	}

	/**
	 * @Title: createCode
	 * @Description: TODO(用户请求发送手机验证码)
	 * @param @param tel
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	@ResponseBody
	@RequestMapping(value = "/gcode", method = RequestMethod.POST)
	public Map<String, Object> createCode(@RequestBody String rquestParam) {
		Map<String, Object> rsMap = Maps.newHashMap();
		JSONObject obj = JSONObject.fromObject(rquestParam);
		if (obj.isEmpty()) {
			rsMap.put("status", GlobalConstants.CT_PARAM_NULL);
			return rsMap;
		}
		String cacheName = obj.getString("cacheName");
		if(!GlobalConstants.TEL_REG_CACHE.equals(cacheName)){
			rsMap.put("status", GlobalConstants.TEL_REG_NOMACHE);
			return rsMap;
		}
		String tel = obj.getString("tel");
		String code = (String) EhcacheUtils.get(cacheName,
				tel);
		if (code == null || "".equals(code)) {
			code = RandomUtils.createRandom(true, 6);
			EhcacheUtils.put(cacheName, tel, code);
		}
		// 发送短信。。
		rsMap.put("status", GlobalConstants.CT_OK);
		System.out.println(code);
		return rsMap;
	}

	@ResponseBody
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public Map<String,Object> login(@RequestBody String rquestParam){
		Map<String, Object> rsMap = Maps.newHashMap();
		JSONObject obj = JSONObject.fromObject(rquestParam);
		if (obj.isEmpty()) {
			rsMap.put("status", GlobalConstants.CT_PARAM_NULL);
			return rsMap;
		}
		String tel = obj.getString("tel");
		String pass = obj.getString("password");
		DgCtUser user = this.userBS.getEntityByProperty(DgCtUser.class, "telNum", tel);
		//判断是否OK 如果OK 返回
		if(user !=null  && pass.equals(user.getPass())){
			rsMap.put("status", GlobalConstants.CT_OK);
			rsMap.put("userid", user.getUserId());
			rsMap.put("nickname", user.getNickname());
			rsMap.put("headimageurl", user.getImgPath());
			rsMap.put("sex", user.getSex());
			rsMap.put("level", user.getGrade());
			rsMap.put("exp", user.getExpe());
			rsMap.put("tel", user.getTelNum());
			rsMap.put("point", user.getRemainCredit());
			if(taskUserRelBS.checkDayTask(user.getUserId(), GlobalConstants.CT_TASK_DAY_SIGN)){
				rsMap.put("daysign", "1");
			}else{
				rsMap.put("daysign", "0");
			}
			return rsMap;
		}else{
			rsMap.put("status", GlobalConstants.CT_PASS_NOMACHE);
			return rsMap;
		}
		
	}
	@ResponseBody
	@RequestMapping(value="/autologin",method=RequestMethod.POST)
	public Map<String,Object> autoLogin(@RequestBody String rquestParam){
		Map<String, Object> rsMap = Maps.newHashMap();
		JSONObject obj = JSONObject.fromObject(rquestParam);
		if (obj.isEmpty()) {
			rsMap.put("status", GlobalConstants.CT_PARAM_NULL);
			return rsMap;
		}
		String userid = obj.getString("userid");
		DgCtUser user = this.userBS.getEntityById(DgCtUser.class, userid);
		//判断是否OK 如果OK 返回
		if(user != null){
			rsMap.put("status", GlobalConstants.CT_OK);
			rsMap.put("userid", user.getUserId());
			rsMap.put("nickname", user.getNickname());
			rsMap.put("headimageurl", user.getImgPath());
			rsMap.put("sex", user.getSex());
			rsMap.put("level", user.getGrade());
			rsMap.put("exp", user.getExpe());
			if(taskUserRelBS.checkDayTask(user.getUserId(), GlobalConstants.CT_TASK_DAY_SIGN)){
				rsMap.put("daysign", "1");
			}else{
				rsMap.put("daysign", "0");
			}
			rsMap.put("point", user.getRemainCredit());
			return rsMap;
		}else{
			rsMap.put("status", GlobalConstants.CT_NO_USR);
			return rsMap;
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/creditDetail",method=RequestMethod.POST)
	public Map<String,Object> listDetail(@RequestBody String rquestParam){
		Map<String, Object> rsMap = Maps.newHashMap();
		JSONObject obj = JSONObject.fromObject(rquestParam);
		if (obj.isEmpty()) {
			rsMap.put("status", GlobalConstants.CT_PARAM_NULL);
			return rsMap;
		}
		String userid = obj.getString("userid");
		DgCtUser user = this.userBS.getEntityById(DgCtUser.class, userid);
		Set<String> tmp = Sets.newTreeSet();
		//判断是否OK 如果OK 返回
		if(user != null){
			Set<DgCdInfoH> details = user.getCreditDetail();
			for(DgCdInfoH detail : details){
				System.out.println(detail.getRemark());
				System.out.println(detail.getUpdateTime());
				tmp.add(detail.getRemark());
			}
			rsMap.put("point", tmp);
			return rsMap;
		}else{
			rsMap.put("status", GlobalConstants.CT_NO_USR);
			return rsMap;
		}
	}
	
	@ExceptionHandler({MyException.class})
	@ResponseBody
	 public String exception(MyException e) {  
        System.out.println(e.getMessage());  
        e.printStackTrace();  
        return "exception";  
    }  
}
