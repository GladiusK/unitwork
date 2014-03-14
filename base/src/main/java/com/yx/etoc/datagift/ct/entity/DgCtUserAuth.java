package com.yx.etoc.datagift.ct.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the DG_CT_USER_AUTH database table.
 * 
 */
@Entity
@Table(name="DG_CT_USER_AUTH")
public class DgCtUserAuth implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String userid;

	@Column(name="LIST_TYPE")
	private String listType;

    public DgCtUserAuth() {
    }

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getListType() {
		return this.listType;
	}

	public void setListType(String listType) {
		this.listType = listType;
	}

}