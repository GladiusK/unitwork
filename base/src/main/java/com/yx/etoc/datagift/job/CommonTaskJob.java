/**   
* @Title: TestJob.java 
* @Package com.yx.etoc.datagift.job 
* @Description: TODO(用一句话描述该文件做什么) 
* @author yuxuan
* @date 2014-5-20 上午2:51:58 
* @version V1.0
* <pre>
* 修改记录
*    修改后版本:     修改人：  修改日期:     修改内容:
* </pre>
*/

package com.yx.etoc.datagift.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.yx.etoc.datagift.common.GlobalConstants;
import com.yx.etoc.datagift.task.service.TaskUserRelBS;

/** 
 * @ClassName: CommonTaskJob 
 * @Description: TODO(公共job管理) 
 * @author yuxuan
 * @date 2014-5-20 上午2:51:58 
 *  
 */
@Component("CommonTaskJob")
public class CommonTaskJob {
	@Autowired
	private TaskUserRelBS taskUserRelBS;
	private static Logger logger = LoggerFactory.getLogger(CommonTaskJob.class);
	/** 
	* @Title: dayTaskJob 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param     设定文件 
	* @return void    返回类型 
	* @throws 
	*/
	@Scheduled(cron="0 10 1 * * ?")  
	public void dayTaskJob(){
		logger.info("正在重置每日任务完成标识");
		taskUserRelBS.redoDayTask(GlobalConstants.CT_TASK_DAY_SIGN, GlobalConstants.CT_NOUSE);
		logger.info("重置完成!");
	}
}
