package com.yx.etoc.datagift.cd.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the dg_cd_info_h database table.
 * 
 */
@Entity
@Table(name="dg_cd_info_h")
public class DgCdInfoH implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DgCdInfoHPK id;

	@Column(name="CREDIT_COUNT")
	private String creditCount;

	@Column(name="CREDIT_REL")
	private String creditRel;

	@Column(name="CREDIT_TYPE")
	private String creditType;

	private String remark;

	@Column(name="TYPE_ID")
	private String typeId;

    public DgCdInfoH() {
    }

	public DgCdInfoHPK getId() {
		return this.id;
	}

	public void setId(DgCdInfoHPK id) {
		this.id = id;
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

	public String getCreditType() {
		return this.creditType;
	}

	public void setCreditType(String creditType) {
		this.creditType = creditType;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getTypeId() {
		return this.typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

}