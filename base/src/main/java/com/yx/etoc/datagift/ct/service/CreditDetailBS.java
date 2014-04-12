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
import com.yx.baseframe.util.RandomUtils;
import com.yx.etoc.datagift.cd.entity.DgCdInfoH;
import com.yx.etoc.datagift.ct.entity.DgCtUser;

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
	public void saveCustEntity(DgCtUser user,String creditType,String moduleId,int creditCont,String creditRel,int expeCount,String remark){
		DgCdInfoH cdInfo = new DgCdInfoH();
		cdInfo.setCtuser(user);
		cdInfo.setUpdateTime(DateTools.getCurrentStringDateTime());
		cdInfo.setCreditId(RandomUtils.uuid2());
		cdInfo.setCreditRel(creditRel);
		cdInfo.setCreditType(creditType);
		cdInfo.setModuleId(moduleId);
		cdInfo.setCreditCount(creditCont);
		cdInfo.setExpeCount(expeCount);
		cdInfo.setRemark(remark);
		this.saveEntity(cdInfo);
	}
}
