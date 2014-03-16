package com.yx.etoc.datagift.task.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.yx.etoc.datagift.ct.entity.DgExpGrdRel;


/**
 * The persistent class for the dg_task_info database table.
 * 
 */
@Entity
@Table(name="dg_task_info")
public class DgTaskInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="TASK_ID")
	private String taskId;

	@Column(name="CREDIT_COUNT")
	private int creditCount;

	@Column(name="END_TIME")
	private String endTime;

	@Column(name="EXPE_COUNT")
	private int expeCount;

	@Column(name="START_TIME")
	private String startTime;

	@Column(name="TARGET_COUNT")
	private int targetCount;

	@Column(name="TASK_NAME")
	private String taskName;

	@Column(name="TASK_REMARK")
	private String taskRemark;

	@Column(name="TASK_STATUS")
	private String taskStatus;

	@Column(name="TASK_TYPE")
	private String taskType;

    public DgTaskInfo() {
    }

	public String getTaskId() {
		return this.taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public int getCreditCount() {
		return this.creditCount;
	}

	public void setCreditCount(int creditCount) {
		this.creditCount = creditCount;
	}

	public String getEndTime() {
		return this.endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public int getExpeCount() {
		return this.expeCount;
	}

	public void setExpeCount(int expeCount) {
		this.expeCount = expeCount;
	}

	public String getStartTime() {
		return this.startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public int getTargetCount() {
		return this.targetCount;
	}

	public void setTargetCount(int targetCount) {
		this.targetCount = targetCount;
	}

	public String getTaskName() {
		return this.taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getTaskRemark() {
		return this.taskRemark;
	}

	public void setTaskRemark(String taskRemark) {
		this.taskRemark = taskRemark;
	}

	public String getTaskStatus() {
		return this.taskStatus;
	}

	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}

	public String getTaskType() {
		return this.taskType;
	}

	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}

}