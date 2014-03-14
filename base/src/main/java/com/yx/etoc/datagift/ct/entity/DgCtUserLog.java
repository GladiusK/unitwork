package com.yx.etoc.datagift.ct.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the DG_CT_USER_LOG database table.
 * 
 */
@Entity
@Table(name="DG_CT_USER_LOG")
public class DgCtUserLog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String userid;

	@Column(name="LOGIN_TIME")
	private String loginTime;

    public DgCtUserLog() {
    }

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getLoginTime() {
		return this.loginTime;
	}

	public void setLoginTime(String loginTime) {
		this.loginTime = loginTime;
	}

}