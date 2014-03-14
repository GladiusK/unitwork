package com.yx.etoc.datagift.cd.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the dg_cd_info_h database table.
 * 
 */
@Embeddable
public class DgCdInfoHPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="UPDATE_TIME")
	private String updateTime;

	@Column(name="CREDIT_ID")
	private String creditId;

    public DgCdInfoHPK() {
    }
	public String getUpdateTime() {
		return this.updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public String getCreditId() {
		return this.creditId;
	}
	public void setCreditId(String creditId) {
		this.creditId = creditId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof DgCdInfoHPK)) {
			return false;
		}
		DgCdInfoHPK castOther = (DgCdInfoHPK)other;
		return 
			this.updateTime.equals(castOther.updateTime)
			&& this.creditId.equals(castOther.creditId);

    }
    
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.updateTime.hashCode();
		hash = hash * prime + this.creditId.hashCode();
		
		return hash;
    }
}