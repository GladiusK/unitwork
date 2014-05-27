/**   
* @Title: TaskController.java 
* @Package com.yx.etoc.datagift.task.web 
* @Description: TODO(用一句话描述该文件做什么) 
* @author yuxuan
* @date 2014-3-16 上午5:06:49 
* @version V1.0
* <pre>
* 修改记录
*    修改后版本:     修改人：  修改日期:     修改内容:
* </pre>
*/

package com.yx.etoc.datagift.task.web;

import java.sql.Timestamp;
import java.util.Map;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.Maps;
import com.yx.baseframe.util.BaseController;
import com.yx.baseframe.util.DateTools;
import com.yx.etoc.datagift.common.GlobalConstants;
import com.yx.etoc.datagift.ct.entity.DgCtUser;
import com.yx.etoc.datagift.ct.service.UserBS;
import com.yx.etoc.datagift.task.entity.DgTaskInfo;
import com.yx.etoc.datagift.task.entity.DgTaskUserRel;
import com.yx.etoc.datagift.task.service.TaskInfoBS;
import com.yx.etoc.datagift.task.service.TaskUserRelBS;

/** 
 * @ClassName: TaskController 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author yuxuan
 * @date 2014-3-16 上午5:06:49 
 *  
 */
@Controller
@RequestMapping("/dg/task")
public class TaskController extends BaseController {
	@Autowired
	private UserBS userBS;
	@Autowired
	private TaskUserRelBS taskUserRelBS;
	@Autowired
	private TaskInfoBS taskInfoBS;
	/** 
	* @Title: daySign 
	* @Description: TODO(每日签到接口) 
	* @param @param rquestParam
	* @param @return    设定文件 
	* @return Map<String,Object>    返回类型 
	* @throws 
	*/
	@RequestMapping(value="/daySign",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> daySign(@RequestBody String rquestParam){
		Map<String, Object> rsMap = Maps.newHashMap();
		JSONObject obj = JSONObject.fromObject(rquestParam);
		if (obj.isEmpty()) {
			rsMap.put("status", GlobalConstants.CT_PARAM_NULL);
			return rsMap;
		}
		String userid = obj.getString("userid");
		DgCtUser user = this.userBS.getEntityById(DgCtUser.class, userid);
		if(user != null){
			rsMap.put("status", GlobalConstants.CT_OK);
			DgTaskUserRel rel = taskUserRelBS.getTaskByUser(user.getUserId(), GlobalConstants.CT_TASK_DAY_SIGN, GlobalConstants.CT_USE);
			if(GlobalConstants.CT_NOUSE.equals(rel.getTaskStatus())){
				DgTaskInfo task = taskInfoBS.getEntityById(rel.getId().getTaskId());
				user = userBS.dayTask(user, task, rel,GlobalConstants.CT_TASK_DAY_SIGN);
				rsMap.put("status", GlobalConstants.CT_OK);
				rsMap.put("point", user.getRemainCredit());
				rsMap.put("exp", user.getExpe());
				rsMap.put("level", user.getGrade());
			}else{
				//已经签到
				rsMap.put("status", GlobalConstants.CT_USR_DAYSIGN_AGAIN);
			}
			return rsMap;
		}else{
			rsMap.put("status", GlobalConstants.CT_NO_USR);
			return rsMap;
		}
	}
}
