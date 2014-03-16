package com.yx.etoc.datagift.task.entity;

import java.io.Serializable;
import javax.persistence.*;


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
	private int completeCount;

	@Column(name="TARGET_COUNT")
	private int targetCount;

	@Column(name="TASK_STATUS")
	private String taskStatus;

	@Column(name="UPDATE_DATE")
	private String updateDate;

    public DgTaskUserRel() {
    }

	public DgTaskUserRelPK getId() {
		return this.id;
	}

	public void setId(DgTaskUserRelPK id) {
		this.id = id;
	}
	
	public int getCompleteCount() {
		return this.completeCount;
	}

	public void setCompleteCount(int completeCount) {
		this.completeCount = completeCount;
	}

	public int getTargetCount() {
		return this.targetCount;
	}

	public void setTargetCount(int targetCount) {
		this.targetCount = targetCount;
	}

	public String getTaskStatus() {
		return this.taskStatus;
	}

	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}

	public String getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

}