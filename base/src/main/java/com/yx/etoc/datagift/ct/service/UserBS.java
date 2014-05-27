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

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yx.baseframe.service.BaseBS;
import com.yx.etoc.datagift.common.GlobalConstants;
import com.yx.etoc.datagift.ct.entity.DgCtUser;
import com.yx.etoc.datagift.ct.entity.DgExpGrdRel;
import com.yx.etoc.datagift.task.entity.DgTaskInfo;
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
	* @Description: TODO(每日任务) 
	* @param @param user
	* @param @param createExp
	* @param @param taskRel
	* @param @param detailType
	* @param @return    设定文件 
	* @return DgCtUser    返回类型 
	* @throws  
	*/
	@Transactional(readOnly = false)
	public DgCtUser dayTask(DgCtUser user,DgTaskInfo task,DgTaskUserRel taskRel,String detailType){
		int compCont = taskRel.getCompleteCount();
		taskRel.setCompleteCount(++compCont);
		if(taskRel.getTargetCount() <= taskRel.getCompleteCount()){
			taskRel.setTaskStatus(GlobalConstants.CT_USE);
			StringBuffer tmp = new StringBuffer("完成");
			tmp.append(task.getTaskName()).append(" , 收获").append(task.getCreditCount()).append("积分 , ").append(task.getExpeCount()).append("经验");
			user = this.calculateAndRecord(user, task.getExpeCount(), task.getCreditCount(), taskRel.getId().getTaskId(), detailType,GlobalConstants.CT_CD_CREDIT_REL_ADD,tmp.toString());
		}
		taskUserRelBS.updateEntity(taskRel);
		return user;
		
	}
	
	/** 
	* @Title: calculateAndRecord 
	* @Description: TODO(将记录经验和积分的增加带来的级别提升、级别奖励、以及积分流水记录) 
	* @param @param user
	* @param @param createExp
	* @param @param createCredit
	* @param @param objId
	* @param @param detailType
	* @param @return    设定文件 
	* @return DgCtUser    返回类型 
	* @throws 目前该算法，只能进行等级升级的一次奖励，如果经验的增加，使得级别增加幅度大于1级，那么积分的奖励也只奖励当前级别的积分，不叠加
	*/
	@Transactional(readOnly = false)
	public DgCtUser calculateAndRecord(DgCtUser user,int createExp,int createCredit,String objId,String detailType,String creditRel,String remark ){
		user = this.calculateGrade(user, createExp, createCredit);
		user.setRemainCredit(user.getRemainCredit()+createCredit);
		user.setTotalCredit(user.getTotalCredit()+createCredit);
		creditDetailBS.saveCustEntity(user, detailType, objId, createCredit, creditRel,createExp,remark);
		this.updateEntity(user);
		return user;
	}
	
	/** 
	* @Title: calculateGrade 
	* @Description: TODO(经验增加后用户的积分变换情况) 
	* @param @param user
	* @param @param createExp
	* @param @param createCredit
	* @param @return    设定文件 
	* @return DgCtUser    返回类型 
	* @throws 
	*/
	public DgCtUser calculateGrade(DgCtUser user, int createExp, int createCredit){
		int tmpExp = createExp+user.getExpe();
		String sql = "select obj from DgExpGrdRel obj where obj.expeFloor <= ?0 and ?0<obj.expeTop";
		DgExpGrdRel expRel = (DgExpGrdRel) this.baseDAO.createQueryWithIndexParam(sql, tmpExp).getSingleResult();
		if(user.getGrade() != expRel.getGradeCount()){
			StringBuffer tmp = new StringBuffer("等级由");
			tmp.append(user.getGrade()).append(" 提升为 ").append(expRel.getGradeCount()).append(" , 收获积分").append(expRel.getCreditExtra());
			user.setExpe(tmpExp);
			user.setGrade(expRel.getGradeCount());
			int extra = expRel.getCreditExtra()+createCredit;
			user.setTotalCredit(user.getRemainCredit()+ extra);
			user.setRemainCredit(user.getRemainCredit()+ extra);
			creditDetailBS.saveCustEntity(user,GlobalConstants.CT_CD_GRADE_UP,expRel.getGradeId(),expRel.getCreditExtra(),GlobalConstants.CT_CD_CREDIT_REL_ADD,createExp,tmp.toString());
		}else{
			user.setExpe(createExp+user.getExpe());
		}
		return user;
	}
	
	/*public DgCtUser getUseTask(String userid){
		String jql = "select u from DgCtUser u join u.tasks t where t.taskType = ?0 and t.taskStatus = ?1 and u.userId = ?2";
		List<DgCtUser> rs = this.baseDAO.createQueryWithIndexParam(jql, "1","2",userid).getResultList();
		return rs.get(0);
	}*/
}
