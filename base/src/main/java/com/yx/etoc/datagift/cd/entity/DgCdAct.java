package com.yx.etoc.datagift.cd.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the dg_cd_act database table.
 * 
 */
@Entity
@Table(name="dg_cd_act")
public class DgCdAct implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CREDIT_ID")
	private String creditId;

	@Column(name="ACT_STATUS")
	private String actStatus;

	@Column(name="CREDIT_COUNT")
	private String creditCount;

	@Column(name="CREDIT_REL")
	private String creditRel;

	@Column(name="END_DATE")
	private String endDate;

	private String remark;

	@Column(name="START_DATE")
	private String startDate;

    public DgCdAct() {
    }

	public String getCreditId() {
		return this.creditId;
	}

	public void setCreditId(String creditId) {
		this.creditId = creditId;
	}

	public String getActStatus() {
		return this.actStatus;
	}

	public void setActStatus(String actStatus) {
		this.actStatus = actStatus;
	}

	public String getCreditCount() {
		return this.creditCount;
	}

	public void setCreditCount(String creditCount) {
		this.creditCount = creditCount;
	}

	public String getCreditRel() {
		return this.creditRel;
	}

	public void setCreditRel(String creditRel) {
		this.creditRel = creditRel;
	}

	public String getEndDate() {
		return this.endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getStartDate() {
		return this.startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

}