package com.yx.etoc.datagift.ct.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the dg_ct_user_auth database table.
 * 
 */
@Entity
@Table(name="dg_ct_user_auth")
public class DgCtUserAuth implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="USER_ID")
	private String userId;

	@Column(name="LIST_TYPE")
	private String listType;

    public DgCtUserAuth() {
    }

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getListType() {
		return this.listType;
	}

	public void setListType(String listType) {
		this.listType = listType;
	}

}