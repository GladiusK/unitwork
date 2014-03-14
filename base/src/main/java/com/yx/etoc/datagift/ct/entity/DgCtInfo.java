package com.yx.etoc.datagift.ct.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the DG_CT_INFO database table.
 * 
 */
@Entity
@Table(name="DG_CT_INFO")
public class DgCtInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String ctid;

	@Column(name="CT_VS")
	private String ctVs;

	@Column(name="FILE_PATH")
	private String filePath;

	@Column(name="FILE_SIZE")
	private String fileSize;

	@Column(name="OUT_VS")
	private String outVs;

	@Column(name="UPGRAGE_TYPE")
	private String upgrageType;

	@Column(name="VS_REMARK")
	private String vsRemark;

    public DgCtInfo() {
    }

	public String getCtid() {
		return this.ctid;
	}

	public void setCtid(String ctid) {
		this.ctid = ctid;
	}

	public String getCtVs() {
		return this.ctVs;
	}

	public void setCtVs(String ctVs) {
		this.ctVs = ctVs;
	}

	public String getFilePath() {
		return this.filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFileSize() {
		return this.fileSize;
	}

	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}

	public String getOutVs() {
		return this.outVs;
	}

	public void setOutVs(String outVs) {
		this.outVs = outVs;
	}

	public String getUpgrageType() {
		return this.upgrageType;
	}

	public void setUpgrageType(String upgrageType) {
		this.upgrageType = upgrageType;
	}

	public String getVsRemark() {
		return this.vsRemark;
	}

	public void setVsRemark(String vsRemark) {
		this.vsRemark = vsRemark;
	}

}