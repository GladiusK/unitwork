package com.yx.etoc.datagift.ct.entity;

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
	private int creditExtra;

	@Column(name="EXPE_FLOOR")
	private int expeFloor;

	@Column(name="EXPE_TOP")
	private int expeTop;

	@Column(name="GRADE_COUNT")
	private int gradeCount;

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

	public int getCreditExtra() {
		return this.creditExtra;
	}

	public void setCreditExtra(int creditExtra) {
		this.creditExtra = creditExtra;
	}

	public int getExpeFloor() {
		return this.expeFloor;
	}

	public void setExpeFloor(int expeFloor) {
		this.expeFloor = expeFloor;
	}

	public int getExpeTop() {
		return this.expeTop;
	}

	public void setExpeTop(int expeTop) {
		this.expeTop = expeTop;
	}

	public int getGradeCount() {
		return this.gradeCount;
	}

	public void setGradeCount(int gradeCount) {
		this.gradeCount = gradeCount;
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