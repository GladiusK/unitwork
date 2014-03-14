package com.yx.etoc.datagift.ct.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the DG_CT_USER_CHANGE_LOG database table.
 * 
 */
@Embeddable
public class DgCtUserChangeLogPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private String userid;

	@Column(name="UPDATE_TIME")
	private String updateTime;

    public DgCtUserChangeLogPK() {
    }
	public String getUserid() {
		return this.userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUpdateTime() {
		return this.updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof DgCtUserChangeLogPK)) {
			return false;
		}
		DgCtUserChangeLogPK castOther = (DgCtUserChangeLogPK)other;
		return 
			this.userid.equals(castOther.userid)
			&& this.updateTime.equals(castOther.updateTime);

    }
    
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.userid.hashCode();
		hash = hash * prime + this.updateTime.hashCode();
		
		return hash;
    }
}