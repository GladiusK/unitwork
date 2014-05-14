package com.yx.etoc.datagift.ct.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.*;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.yx.etoc.datagift.cd.entity.DgCdInfoH;


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
	private Integer creditExtra;

	@Column(name="EXPE_FLOOR")
	private Integer expeFloor;

	@Column(name="EXPE_TOP")
	private Integer expeTop;

	@Column(name="GRADE_COUNT")
	private Integer gradeCount;

	@Column(name="GRADE_ICON")
	private String gradeIcon;

	@Column(name="GRADE_REMARK")
	private String gradeRemark;
	
	@OneToMany(mappedBy="expGrdRel",cascade=CascadeType.REFRESH,fetch=FetchType.LAZY)
	@OrderBy("updateTime DESC")
	private List<DgCdInfoH> cdDetails = Lists.newArrayList();

    public DgExpGrdRel() {
    }

	public String getGradeId() {
		return this.gradeId;
	}

	public void setGradeId(String gradeId) {
		this.gradeId = gradeId;
	}

	public Integer getCreditExtra() {
		return this.creditExtra;
	}

	public void setCreditExtra(Integer creditExtra) {
		this.creditExtra = creditExtra;
	}

	public Integer getExpeFloor() {
		return this.expeFloor;
	}

	public void setExpeFloor(Integer expeFloor) {
		this.expeFloor = expeFloor;
	}

	public Integer getExpeTop() {
		return this.expeTop;
	}

	public void setExpeTop(Integer expeTop) {
		this.expeTop = expeTop;
	}

	public Integer getGradeCount() {
		return this.gradeCount;
	}

	public void setGradeCount(Integer gradeCount) {
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

	public List<DgCdInfoH> getCdDetails() {
		return cdDetails;
	}

	public void setCdDetails(List<DgCdInfoH> cdDetails) {
		this.cdDetails = cdDetails;
	}

}