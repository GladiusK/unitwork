package com.yx.etoc.datagift.task.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the dg_task_user_rel database table.
 * 
 */
@Embeddable
public class DgTaskUserRelPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="USER_ID")
	private String userId;

	@Column(name="TASK_ID")
	private String taskId;

    public DgTaskUserRelPK() {
    }
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getTaskId() {
		return this.taskId;
	}
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof DgTaskUserRelPK)) {
			return false;
		}
		DgTaskUserRelPK castOther = (DgTaskUserRelPK)other;
		return 
			this.userId.equals(castOther.userId)
			&& this.taskId.equals(castOther.taskId);

    }
    
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.userId.hashCode();
		hash = hash * prime + this.taskId.hashCode();
		
		return hash;
    }
}