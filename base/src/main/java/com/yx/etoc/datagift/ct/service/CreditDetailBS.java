/**   
* @Title: CreditDetailBS.java 
* @Package com.yx.etoc.datagift.ct.service 
* @Description: TODO(用一句话描述该文件做什么) 
* @author yuxuan
* @date 2014-3-16 上午11:39:06 
* @version V1.0
* <pre>
* 修改记录
*    修改后版本:     修改人：  修改日期:     修改内容:
* </pre>
*/

package com.yx.etoc.datagift.ct.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yx.baseframe.service.BaseBS;
import com.yx.baseframe.util.DateTools;
import com.yx.etoc.datagift.cd.entity.DgCdInfoH;
import com.yx.etoc.datagift.cd.entity.DgCdInfoHPK;

/** 
 * @ClassName: CreditDetailBS 
 * @Description: TODO(积分详情) 
 * @author yuxuan
 * @date 2014-3-16 上午11:39:06 
 *  
 */
@Service
@Transactional(readOnly=true)
public class CreditDetailBS extends BaseBS<DgCdInfoH> {
	@Transactional(readOnly=false)
	public void saveCustEntity(String userid,String creditType,String moduleId,int creditCont,String creditRel){
		DgCdInfoH cdInfo = new DgCdInfoH();
		DgCdInfoHPK id = new DgCdInfoHPK();
		id.setUserId(userid);
		id.setUpdateTime(DateTools.getCurrentStringDateTime());
		cdInfo.setId(id);
		cdInfo.setCreditRel(creditRel);
		cdInfo.setCreditType(creditType);
		cdInfo.setModuleId(moduleId);
		cdInfo.setCreditCount(creditCont);
		this.saveEntity(cdInfo);
	}
}
