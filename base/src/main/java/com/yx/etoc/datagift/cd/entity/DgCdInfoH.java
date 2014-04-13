package com.yx.etoc.datagift.cd.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.yx.baseframe.util.DateTools;
import com.yx.etoc.datagift.app.entity.DgAppInfo;
import com.yx.etoc.datagift.ct.entity.DgCtUser;
import com.yx.etoc.datagift.ct.entity.DgExpGrdRel;
import com.yx.etoc.datagift.task.entity.DgTaskInfo;


/**
 * The persistent class for the dg_cd_info_h database table.
 * 
 */
@Entity
@Table(name="dg_cd_info_h")
public class DgCdInfoH implements Serializable, Comparable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="CREDIT_ID")
	private String creditId;

	@Column(name="CREDIT_COUNT")
	private int creditCount;

	@Column(name="CREDIT_REL")
	private String creditRel;

	@Column(name="CREDIT_TYPE")
	private String creditType;

	@Column(name="MODULE_ID")
	private String moduleId;

	private String remark;

	@Column(name="UPDATE_TIME")
	private String updateTime;

	@Column(name="EXPE_COUNT")
	private int expeCount;
	
	@JoinColumn(name="MODULE_ID", nullable = false, insertable = false, updatable = false)
	@ManyToOne(cascade={CascadeType.REFRESH}, optional=false, fetch=FetchType.LAZY)
	private DgAppInfo appinfo;

	@JoinColumn(name="MODULE_ID", nullable = false, insertable = false, updatable = false)
	@ManyToOne(cascade={CascadeType.REFRESH},optional=false, fetch=FetchType.LAZY)
	private DgExpGrdRel expGrdRel;
	
	@JoinColumn(name="MODULE_ID", nullable = false, insertable = false, updatable = false)
	@ManyToOne(cascade={CascadeType.REFRESH},optional=false, fetch=FetchType.LAZY)
	private DgTaskInfo dgTaskInfo;
	
	@JoinColumn(name="USER_ID")
	@ManyToOne(cascade={CascadeType.REFRESH},optional=false, fetch=FetchType.LAZY)
	private DgCtUser ctuser;
	
    public DgCdInfoH() {
    }

	public String getCreditId() {
		return this.creditId;
	}

	public void setCreditId(String creditId) {
		this.creditId = creditId;
	}

	public int getCreditCount() {
		return this.creditCount;
	}

	public void setCreditCount(int creditCount) {
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

	public String getModuleId() {
		return this.moduleId;
	}

	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	
	public DgAppInfo getAppinfo() {
		return appinfo;
	}

	public void setAppinfo(DgAppInfo appinfo) {
		this.appinfo = appinfo;
	}

	public DgExpGrdRel getExpGrdRel() {
		return expGrdRel;
	}

	public void setExpGrdRel(DgExpGrdRel expGrdRel) {
		this.expGrdRel = expGrdRel;
	}

	public int compareTo(Object o) {
		DgCdInfoH obj = (DgCdInfoH)o;
	//	int rs = DateTools.compareStringDate(this.updateTime, obj.updateTime); 升序
	    int rs = DateTools.compareStringDate(obj.updateTime, this.updateTime);
		return rs;
	}

	public int getExpeCount() {
		return expeCount;
	}

	public void setExpeCount(int expeCount) {
		this.expeCount = expeCount;
	}

	public DgCtUser getCtuser() {
		return ctuser;
	}

	public void setCtuser(DgCtUser ctuser) {
		this.ctuser = ctuser;
	}

	public DgTaskInfo getDgTaskInfo() {
		return dgTaskInfo;
	}

	public void setDgTaskInfo(DgTaskInfo dgTaskInfo) {
		this.dgTaskInfo = dgTaskInfo;
	}
	
}