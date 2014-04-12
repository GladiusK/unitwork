/**   
* @Title: AppDownHBS.java 
* @Package com.yx.etoc.datagift.app.service 
* @Description: TODO(用一句话描述该文件做什么) 
* @author yuxuan
* @date 2014-4-7 上午8:00:09 
* @version V1.0
* <pre>
* 修改记录
*    修改后版本:     修改人：  修改日期:     修改内容:
* </pre>
*/

package com.yx.etoc.datagift.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yx.baseframe.service.BaseBS;
import com.yx.etoc.datagift.app.entity.DgAppDownH;
import com.yx.etoc.datagift.app.entity.DgAppInfo;
import com.yx.etoc.datagift.common.GlobalConstants;
import com.yx.etoc.datagift.ct.entity.DgCtUser;
import com.yx.etoc.datagift.ct.service.UserBS;

/** 
 * @ClassName: AppDownHBS 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author yuxuan
 * @date 2014-4-7 上午8:00:09 
 *  
 */
@Service
@Transactional(readOnly = true)
public class AppDownHBS extends BaseBS<DgAppDownH> {
	@Autowired
	private UserBS userBS;
	@Transactional(readOnly = false)
	public void afterDown(DgAppDownH downH,DgCtUser user, DgAppInfo appInfo){
		StringBuffer remark = new StringBuffer("下载").append("\"").append(appInfo.getAppName()).append("\"").append(" , ").append("收获").append(appInfo.getCreditCount()).append("积分 , ").append(appInfo.getExpeCount()).append("经验");
		user = userBS.calculateAndRecord(user, appInfo.getExpeCount(), appInfo.getCreditCount(), appInfo.getAppId(), appInfo.getActType()=="0"?GlobalConstants.CT_CD_NOFLOW_DOWNLOAD:GlobalConstants.CT_CD_FLOW_DOWNLOAD,GlobalConstants.CT_CD_CREDIT_REL_ADD,remark.toString());
		userBS.updateEntity(user);
		saveEntity(downH);
	}

}
