package com.yx.etoc.datagift.cd.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the dg_exp_grd_rel database table.
 * 
 */
@Entity
@Table(name="dg_exp_grd_rel")
public class DgExpGrdRel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="GRADE_ID")
	private String gradeId;

	@Column(name="CREDIT_EXTRA")
	private String creditExtra;

	@Column(name="EXPE_FLOOR")
	private String expeFloor;

	@Column(name="EXPE_TOP")
	private String expeTop;

	@Column(name="GRADE_ICON")
	private String gradeIcon;

	@Column(name="GRADE_REMARK")
	private String gradeRemark;

    public DgExpGrdRel() {
    }

	public String getGradeId() {
		return this.gradeId;
	}

	public void setGradeId(String gradeId) {
		this.gradeId = gradeId;
	}

	public String getCreditExtra() {
		return this.creditExtra;
	}

	public void setCreditExtra(String creditExtra) {
		this.creditExtra = creditExtra;
	}

	public String getExpeFloor() {
		return this.expeFloor;
	}

	public void setExpeFloor(String expeFloor) {
		this.expeFloor = expeFloor;
	}

	public String getExpeTop() {
		return this.expeTop;
	}

	public void setExpeTop(String expeTop) {
		this.expeTop = expeTop;
	}

	public String getGradeIcon() {
		return this.gradeIcon;
	}

	public void setGradeIcon(String gradeIcon) {
		this.gradeIcon = gradeIcon;
	}

	public String getGradeRemark() {
		return this.gradeRemark;
	}

	public void setGradeRemark(String gradeRemark) {
		this.gradeRemark = gradeRemark;
	}

}