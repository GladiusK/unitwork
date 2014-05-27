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

import java.sql.Timestamp;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.yx.baseframe.dao.SearchResult;
import com.yx.baseframe.service.BaseBS;
import com.yx.baseframe.util.Pager;
import com.yx.baseframe.util.RandomUtils;
import com.yx.etoc.datagift.cd.entity.DgCdInfoH;
import com.yx.etoc.datagift.cd.web.dto.CreditDetailStructure;
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
		cdInfo.setCreditId(RandomUtils.uuid2());
		cdInfo.setCreditRel(creditRel);
		cdInfo.setCreditType(creditType);
		cdInfo.setModuleId(moduleId);
		cdInfo.setCreditCount(creditCont);
		cdInfo.setExpeCount(expeCount);
		cdInfo.setRemark(remark);
		this.saveEntity(cdInfo);
	}
	
	public List<CreditDetailStructure> list(Pager pager, String userId){
		String jql = "select obj from DgCdInfoH obj where obj.ctuser.userId = ?0 order by obj.updateTime desc";
		SearchResult<DgCdInfoH> sr = this.baseDAO.findPageIndexParam(pager.getPageFirstIndex(), pager.getPagesize(), jql, userId);
		List<DgCdInfoH> result =  sr.getResult();
		CreditDetailStructure msg = null;
		List<CreditDetailStructure> tmp = Lists.newArrayList();
		for(DgCdInfoH obj : result){
			msg = new CreditDetailStructure();
			//msg.setDate(obj.getUpdateTime());
			msg.setDesc(obj.getRemark());
			tmp.add(msg);
		}
		return tmp;
	}
}
