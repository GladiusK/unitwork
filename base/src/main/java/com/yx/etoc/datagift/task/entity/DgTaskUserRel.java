package com.yx.etoc.datagift.task.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * The persistent class for the dg_task_user_rel database table.
 * 
 */
@Entity
@Table(name="dg_task_user_rel")
public class DgTaskUserRel implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DgTaskUserRelPK id;

	@Column(name="COMPLETE_COUNT")
	private Integer completeCount;

	@Column(name="TARGET_COUNT")
	private Integer targetCount;

	@Column(name="TASK_STATUS")
	private String taskStatus;

	@Column(columnDefinition="TIMESTAMP", insertable = false, updatable = false)
	private Timestamp updateTime;

    public DgTaskUserRel() {
    }

	public DgTaskUserRelPK getId() {
		return this.id;
	}

	public void setId(DgTaskUserRelPK id) {
		this.id = id;
	}
	
	public Integer getCompleteCount() {
		return this.completeCount;
	}

	public void setCompleteCount(Integer completeCount) {
		this.completeCount = completeCount;
	}

	public Integer getTargetCount() {
		return this.targetCount;
	}

	public void setTargetCount(Integer targetCount) {
		this.targetCount = targetCount;
	}

	public String getTaskStatus() {
		return this.taskStatus;
	}

	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

}