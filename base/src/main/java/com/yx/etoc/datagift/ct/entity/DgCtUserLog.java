package com.yx.etoc.datagift.ct.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the dg_ct_user_log database table.
 * 
 */
@Entity
@Table(name="dg_ct_user_log")
public class DgCtUserLog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="USER_ID")
	private String userId;

	@Column(name="LOGIN_TIME")
	private String loginTime;

    public DgCtUserLog() {
    }

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getLoginTime() {
		return this.loginTime;
	}

	public void setLoginTime(String loginTime) {
		this.loginTime = loginTime;
	}

}