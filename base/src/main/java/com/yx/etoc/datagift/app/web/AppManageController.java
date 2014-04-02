/**   
* @Title: AppManageController.java 
* @Package com.yx.etoc.datagift.app.web 
* @Description: TODO(用一句话描述该文件做什么) 
* @author yuxuan
* @date 2014-3-30 上午2:54:58 
* @version V1.0
* <pre>
* 修改记录
*    修改后版本:     修改人：  修改日期:     修改内容:
* </pre>
*/

package com.yx.etoc.datagift.app.web;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.yx.baseframe.dao.SearchResult;
import com.yx.baseframe.util.BaseController;
import com.yx.baseframe.util.Pager;
import com.yx.etoc.datagift.app.entity.DgAppCategory;
import com.yx.etoc.datagift.app.entity.DgAppInfo;
import com.yx.etoc.datagift.app.service.AppManageBS;
import com.yx.etoc.datagift.app.web.dto.DataAppStructure.AppProduct;
import com.yx.etoc.datagift.common.GlobalConstants;
import com.yx.etoc.datagift.ct.entity.DgCtUser;
import com.yx.etoc.datagift.ct.service.UserBS;

/** 
 * @ClassName: AppManageController 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author yuxuan
 * @date 2014-3-30 上午2:54:58 
 *  
 */
@Controller
@RequestMapping("/dg/app/")
public class AppManageController extends BaseController {
	@Autowired
	private AppManageBS appManageBS;
	@Autowired
	private UserBS userBS;
	@RequestMapping(value="/list",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> list(@RequestBody String rquestParam){
		Map<String, Object> rsMap = Maps.newHashMap();
		JSONObject obj = JSONObject.fromObject(rquestParam);
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
			List<AppProduct> searchResult = this.appManageBS.list(pager);
			rsMap.put("status", GlobalConstants.CT_NO_USR);
			rsMap.put("appinfo", searchResult);
			return rsMap;
		}
	}
}
