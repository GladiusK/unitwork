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

import java.sql.Timestamp;
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
import com.yx.baseframe.util.BaseController;
import com.yx.baseframe.util.DateTools;
import com.yx.baseframe.util.Pager;
import com.yx.baseframe.util.RandomUtils;
import com.yx.etoc.datagift.app.entity.DgAppCategory;
import com.yx.etoc.datagift.app.entity.DgAppDownH;
import com.yx.etoc.datagift.app.entity.DgAppDownHPK;
import com.yx.etoc.datagift.app.entity.DgAppImg;
import com.yx.etoc.datagift.app.entity.DgAppInfo;
import com.yx.etoc.datagift.app.service.AppCategoryBS;
import com.yx.etoc.datagift.app.service.AppDownHBS;
import com.yx.etoc.datagift.app.service.AppManageBS;
import com.yx.etoc.datagift.app.web.dto.DataAppStructure.AppProduct;
import com.yx.etoc.datagift.common.GlobalConstants;
import com.yx.etoc.datagift.ct.entity.DgCtUser;
import com.yx.etoc.datagift.ct.service.UserBS;
import com.yx.etoc.datagift.task.entity.DgTaskInfo;
import com.yx.etoc.datagift.task.entity.DgTaskUserRel;
import com.yx.etoc.datagift.task.service.TaskInfoBS;
import com.yx.etoc.datagift.task.service.TaskUserRelBS;

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
	
	@Autowired
	private AppCategoryBS appCategoryBS;
	
	@Autowired
	private AppDownHBS appDownHBS;
	
	@RequestMapping(value="/list",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> list(@RequestBody String requestParam){
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
			List<AppProduct> searchResult = this.appManageBS.list(pager);
			rsMap.put("status", GlobalConstants.CT_OK);
			rsMap.put("appinfo", searchResult);
			return rsMap;
		}
	}
	
	@RequestMapping(value="/afterdownload",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> afterDownload(@RequestBody String requestParam){
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
			String appid = obj.getString("appid");
			DgAppInfo appInfo = appManageBS.getEntityById(appid);
			if(appInfo == null){
				rsMap.put("status", GlobalConstants.CT_APP_NOEXIST);
				return rsMap;
			}
			DgAppDownH downH = new DgAppDownH();
			DgAppDownHPK pk = new DgAppDownHPK();
			pk.setAppId(appid);
			pk.setUserId(userid);
			downH.setId(pk);
			if(user.getApps().contains(appInfo)){
				rsMap.put("status", GlobalConstants.CT_APP_USER_ALREADY_DOWN);
				return rsMap;
			}else{
				appDownHBS.afterDown(downH,user,appInfo);
				rsMap.put("status", GlobalConstants.CT_OK);
				return rsMap;
			}
		}
	}
	
	
	@RequestMapping(value="test")
	@ResponseBody
	public void test(){
		DgAppCategory dgAppCategory = appCategoryBS.getEntityById("18a8b9a57f6544e89adcdaae469f682e");
		List<DgAppImg> list = null;
		DgAppImg tmp = null;
		DgAppImg tmp2 = null;
		DgAppImg tmp3 = null;
		DgAppInfo info = null;
		String id = null;
		for(int i = 1; i < 20; i++){
			info = new DgAppInfo();
			info.setCategory(dgAppCategory);
			list = Lists.newArrayList();
			id = RandomUtils.uuid2();
			tmp = new DgAppImg();
			tmp.setImgId(RandomUtils.uuid2());
			tmp.setImg("http://a1.mzstatic.com/us/r30/Purple4/v4/2b/26/e0/2b26e051-4015-e846-1cce-98abd9b1a5f2/screen568x568.jpeg");
			tmp.setImgName("分页测试1");
			list.add(tmp);
			tmp2 = new DgAppImg();
			tmp2.setImgId(RandomUtils.uuid2());
			tmp2.setImg("http://a1.mzstatic.com/us/r30/Purple4/v4/2b/26/e0/2b26e051-4015-e846-1cce-98abd9b1a5f2/screen568x568.jpeg");
			tmp2.setImgName("分页测试2");
			list.add(tmp2);
			tmp3 = new DgAppImg();
			tmp3.setImgId(RandomUtils.uuid2());
			tmp3.setImg("http://a1.mzstatic.com/us/r30/Purple4/v4/2b/26/e0/2b26e051-4015-e846-1cce-98abd9b1a5f2/screen568x568.jpeg");
			tmp3.setImgName("分页测试3");
			list.add(tmp3);
			info.setImgs(list);
			info.setAppId(id);
			info.setAppIcon("http://t11.baidu.com/it/u=2537535298,3441913106&fm=58");
			info.setAppName("looklook.apk"+i);
			info.setAppSize("18698100");
			info.setAppIcon("http://t11.baidu.com/it/u=2537535298,3441913106&fm=58");
			info.setAppFile("http://channel.looklook.cn:8091/download/api/download.do?productcode=3&systemcode=101");
			info.setAppRemark("测试分页功能"+i);
			info.setStep("1.下载looklook\n, 2.安装looklook\n,3.激活\n,4.获取流量");
			info.setFluxCount(20);
			info.setCreditCount(10);
			info.setExpeCount(50);
			info.setPackageName("com.cmmobi.looklook");
			tmp.setAppinfo(info);
			tmp2.setAppinfo(info);
			tmp3.setAppinfo(info);
			appManageBS.saveEntity(info);
		}
	}
}
