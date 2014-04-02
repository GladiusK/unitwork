/**   
* @Title: AppManageBS.java 
* @Package com.yx.etoc.datagift.app.service 
* @Description: TODO(用一句话描述该文件做什么) 
* @author yuxuan
* @date 2014-3-30 上午3:14:25 
* @version V1.0
* <pre>
* 修改记录
*    修改后版本:     修改人：  修改日期:     修改内容:
* </pre>
*/

package com.yx.etoc.datagift.app.service;


import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.yx.baseframe.dao.SearchResult;
import com.yx.baseframe.service.BaseBS;
import com.yx.baseframe.util.Pager;
import com.yx.etoc.datagift.app.entity.DgAppImg;
import com.yx.etoc.datagift.app.entity.DgAppInfo;
import com.yx.etoc.datagift.app.web.dto.DataAppStructure.APKFile;
import com.yx.etoc.datagift.app.web.dto.DataAppStructure.AppProduct;

/** 
 * @ClassName: AppManageBS 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author yuxuan
 * @date 2014-3-30 上午3:14:25 
 *  
 */
@Service
@Transactional(readOnly=true)
public class AppManageBS extends BaseBS<DgAppInfo>{
	public List<AppProduct> list(Pager pager){
		String jql="select obj from DgAppInfo obj";
		SearchResult<DgAppInfo> rs = this.baseDAO.findPageIndexParam(pager.getPageFirstIndex(), pager.getPagesize(), jql, null);
		AppProduct appDTO  = null; 
		APKFile  apkFileDTO = null;
		List<AppProduct> rsList = Lists.newArrayList();
		for(DgAppInfo app : rs.getResult()){
			appDTO = new AppProduct();
			apkFileDTO = new APKFile();
			apkFileDTO.setFilename(app.getAppName());
			apkFileDTO.setFilesize(app.getAppSize());
			apkFileDTO.setRemotepath(app.getAppFile());
			appDTO.setApk(apkFileDTO);
			appDTO.setAppid(app.getAppId());
			appDTO.setName(app.getAppName());
			appDTO.setPkgname(app.getPackageName());
			appDTO.setIcon(app.getAppIcon());
			appDTO.setPreviewUrl(getImgUrl(app.getImgs()));
			appDTO.setSteps(StringUtils.split(app.getStep()));
			appDTO.setIntro(app.getAppRemark());
			appDTO.setDownnum(Math.random()*10000+"");
			appDTO.setType("1");
			appDTO.setPoint(app.getCreditCount()+"");
			appDTO.setExp(app.getExpeCount()+"");
			appDTO.setData(app.getFluxCount()+"");
			rsList.add(appDTO);
		}
		return rsList;
	}
	
	private String[] getImgUrl(List<DgAppImg> imgs){
		String[] tmp = null;
		if(CollectionUtils.isEmpty(imgs)) return null;
		tmp = new String[imgs.size()];
		for(int i = 0,s = imgs.size(); i < s; i++){
			tmp[i] = imgs.get(i).getImg();
		}
		return tmp;
	}
}
