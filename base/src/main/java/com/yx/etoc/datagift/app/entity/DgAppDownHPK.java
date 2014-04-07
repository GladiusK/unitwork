package com.yx.etoc.datagift.app.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the dg_app_down_h database table.
 * 
 */
@Embeddable
public class DgAppDownHPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;
	
	
	@Column(name="APP_ID")
	private String appId;

	@Column(name="USER_ID")
	private String userId;

    public DgAppDownHPK() {
    }
	public String getAppId() {
		return this.appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof DgAppDownHPK)) {
			return false;
		}
		DgAppDownHPK castOther = (DgAppDownHPK)other;
		return 
			this.appId.equals(castOther.appId)
			&& this.userId.equals(castOther.userId);

    }
    
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.appId.hashCode();
		hash = hash * prime + this.userId.hashCode();
		
		return hash;
    }
}