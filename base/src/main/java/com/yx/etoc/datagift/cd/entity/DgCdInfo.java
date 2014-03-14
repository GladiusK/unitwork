package com.yx.etoc.datagift.cd.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the dg_cd_info database table.
 * 
 */
@Entity
@Table(name="dg_cd_info")
public class DgCdInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CREDIT_ID")
	private String creditId;

	@Column(name="CREDIT_STATUS")
	private String creditStatus;

	@Column(name="REMAIN_CREDIT")
	private String remainCredit;

	@Column(name="TOTAL_CREDIT")
	private String totalCredit;

    public DgCdInfo() {
    }

	public String getCreditId() {
		return this.creditId;
	}

	public void setCreditId(String creditId) {
		this.creditId = creditId;
	}

	public String getCreditStatus() {
		return this.creditStatus;
	}

	public void setCreditStatus(String creditStatus) {
		this.creditStatus = creditStatus;
	}

	public String getRemainCredit() {
		return this.remainCredit;
	}

	public void setRemainCredit(String remainCredit) {
		this.remainCredit = remainCredit;
	}

	public String getTotalCredit() {
		return this.totalCredit;
	}

	public void setTotalCredit(String totalCredit) {
		this.totalCredit = totalCredit;
	}

}