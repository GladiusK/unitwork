/**   
* @Title: UserBS.java 
* @Package com.yx.etoc.datagift.ct.service 
* @Description: TODO(客户端用户信息管理) 
* @author yuxuan
* @date 2014-3-7 上午2:37:08 
* @version V1.0
* <pre>
* 修改记录
*    修改后版本:     修改人：  修改日期:     修改内容:
* </pre>
*/

package com.yx.etoc.datagift.ct.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yx.baseframe.service.BaseBS;
import com.yx.baseframe.util.DateTools;
import com.yx.etoc.datagift.cd.entity.DgCdInfoH;
import com.yx.etoc.datagift.cd.entity.DgCdInfoHPK;
import com.yx.etoc.datagift.ct.entity.DgCtUser;
import com.yx.etoc.datagift.ct.entity.DgExpGrdRel;
import com.yx.etoc.datagift.task.entity.DgTaskUserRel;
import com.yx.etoc.datagift.task.service.TaskUserRelBS;

/** 
 * @ClassName: UserBS 
 * @Description: TODO(客户端用户信息管理) 
 * @author yuxuan
 * @date 2014-3-7 上午2:37:08 
 *  
 */
@Service
@Transactional(readOnly=true)
public class UserBS extends BaseBS<DgCtUser>{
	@Autowired
	private TaskUserRelBS taskUserRelBS;
	
	@Autowired
	private CreditDetailBS creditDetailBS;
	
	@Transactional(readOnly=false)
	public DgCtUser createNewUser(DgCtUser user){
		user.setImgPath("xx");
		user.setGrade(0);
		user.setExpe(0);
		this.saveEntity(user);
		//为用户增加3条共用任务
		taskUserRelBS.initTask(user.getUserId());
		return user;
	}
	/** 
	* @Title: calculate 
	* @Description: TODO(经验增加的时候，等级可能发生变化) 
	* @param @param user
	* @param @param createExp
	* @param @param taskRel
	* @param @param detailType
	* @param @return    设定文件 
	* @return DgCtUser    返回类型 
	* @throws  目前该算法，只能进行等级升级的一次奖励，如果经验的增加，使得级别增加幅度大于1级，那么积分的奖励也只奖励当前级别的积分，不叠加
	*/
	@Transactional(readOnly = false)
	public DgCtUser calculate(DgCtUser user,int createExp,DgTaskUserRel taskRel,String detailType){
		int tmpExp = createExp+user.getExpe();
		String sql = "select obj from DgExpGrdRel obj where obj.expeFloor <= ?0 and ?0<obj.expeTop";
		DgExpGrdRel expRel = (DgExpGrdRel) this.baseDAO.createQueryWithIndexParam(sql, tmpExp).getSingleResult();
			user.setExpe(tmpExp);
			user.setGrade(expRel.getGradeCount());
			user.setTotalCredit(user.getRemainCredit()+expRel.getCreditExtra());
			user.setRemainCredit(user.getRemainCredit()+expRel.getCreditExtra());
			this.updateEntity(user);
			taskUserRelBS.updateEntity(taskRel);
			DgCdInfoH cdInfo = new DgCdInfoH();
			DgCdInfoHPK id = new DgCdInfoHPK();
			id.setUserId(user.getUserId());
			id.setUpdateTime(DateTools.getCurrentStringDateTime());
			cdInfo.setId(id);
			cdInfo.setCreditType(detailType);
			cdInfo.setModuleId(taskRel.getId().getTaskId());
			cdInfo.setCreditCount(createExp);
			creditDetailBS.saveEntity(cdInfo);
			return user;
		
	}
	
}
