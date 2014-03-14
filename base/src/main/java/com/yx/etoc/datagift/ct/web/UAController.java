package com.yx.etoc.datagift.ct.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.Maps;
import com.yx.baseframe.util.BaseController;
import com.yx.etoc.datagift.common.GlobalConstants;
import com.yx.etoc.datagift.ct.entity.DgCtUser;
import com.yx.etoc.datagift.ct.service.UserBS;
import com.yx.etoc.datagift.ct.web.vo.DgCtInfoVO;

@Controller
@RequestMapping("/dg/ua")
public class UAController extends BaseController {
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
		ct.setVsRemark("更正了B瑞的抱怨");
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
	
}
