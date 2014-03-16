package com.yx.etoc.datagift.task.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yx.baseframe.service.BaseBS;
import com.yx.etoc.datagift.task.entity.DgTaskInfo;

/** 
* @ClassName: TaskInfoBS 
* @Description: TODO(任务列表) 
* @author yuxuan
* @date 2014-3-16 上午3:36:18 
*  
*/
@Service
@Transactional(readOnly=true)
public class TaskInfoBS extends BaseBS<DgTaskInfo>{

}
