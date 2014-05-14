/**   
* @Title: CreditDeatilController.java 
* @Package com.yx.etoc.datagift.cd.web 
* @Description: TODO(用一句话描述该文件做什么) 
* @author yuxuan
* @date 2014-4-13 上午6:45:36 
* @version V1.0
* <pre>
* 修改记录
*    修改后版本:     修改人：  修改日期:     修改内容:
* </pre>
*/

package com.yx.etoc.datagift.cd.web;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.Maps;
import com.yx.baseframe.util.BaseController;
import com.yx.baseframe.util.Pager;
import com.yx.etoc.datagift.cd.entity.DgCdInfoH;
import com.yx.etoc.datagift.cd.web.dto.CreditDetailStructure;
import com.yx.etoc.datagift.common.GlobalConstants;
import com.yx.etoc.datagift.ct.entity.DgCtUser;
import com.yx.etoc.datagift.ct.service.CreditDetailBS;
import com.yx.etoc.datagift.ct.service.UserBS;

/** 
 * @ClassName: CreditDeatilController 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author yuxuan
 * @date 2014-4-13 上午6:45:36 
 *  
 */
@Controller
@RequestMapping("/dg/msg")
public class CreditDeatilController extends BaseController {
	@Autowired
	private UserBS userBS;
	@Autowired
	private CreditDetailBS creditDetailBS;
	
	@ResponseBody
	@RequestMapping(value="/latestmsg",method=RequestMethod.POST)
	public Map<String,Object> getLatestMsg(@RequestBody String requestParam){
		Map<String, Object> rsMap = Maps.newHashMap();
		JSONObject obj = JSONObject.fromObject(requestParam);
		if (obj.isEmpty()) {
			rsMap.put("status", GlobalConstants.CT_PARAM_NULL);
			return rsMap;
		}
		String userid = obj.getString("userid");
		DgCtUser user = this.userBS.getEntityById(DgCtUser.class, userid);
		if(user == null){
			rsMap.put("status", GlobalConstants.CT_NO_USR);
			return rsMap;
		}else{
			List<DgCdInfoH> rsList =  user.getCreditDetail();
			DgCdInfoH creditdetail = CollectionUtils.isNotEmpty(rsList)?rsList.get(0):null;
			CreditDetailStructure msg = new CreditDetailStructure();
			msg.setDate(creditdetail.getUpdateTime());
			msg.setDesc(creditdetail.getRemark());
			rsMap.put("creditdetail", msg);
			rsMap.put("sysmsg", null);
			rsMap.put("custmsg", null);
			rsMap.put("status", GlobalConstants.CT_OK);
			return rsMap;
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/msgDetail",method=RequestMethod.POST)
	public Map<String, Object> getMsgDetail(@RequestBody String requestParam){
		Map<String, Object> rsMap = Maps.newHashMap();
		JSONObject obj = JSONObject.fromObject(requestParam);
		if (obj.isEmpty()) {
			rsMap.put("status", GlobalConstants.CT_PARAM_NULL);
			return rsMap;
		}
		String userid = obj.getString("userid");
		DgCtUser user = this.userBS.getEntityById(DgCtUser.class, userid);
		if(user == null){
			rsMap.put("status", GlobalConstants.CT_NO_USR);
			return rsMap;
		}else{
			int pagenum = obj.getInt("pagenum");
			Pager pager = new Pager();
			pager.setPage(pagenum);
			rsMap.put("creditdetail", creditDetailBS.list(pager, user.getUserId()));
			rsMap.put("sysmsg", null);
			rsMap.put("custmsg", null);
			rsMap.put("status", GlobalConstants.CT_OK);
			return rsMap;
		}
	}
}
