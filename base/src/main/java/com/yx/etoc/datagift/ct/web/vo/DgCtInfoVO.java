package com.yx.etoc.datagift.ct.web.vo;

import java.math.BigDecimal;


public class DgCtInfoVO {
	private String ctid;
	private BigDecimal ctVs;
	private String filePath;
	private String fileSize;
	private String outVs;
	private String upgrageType;
	private String vsRemark;
	private String status;
	private String ip;
	private String servertime;
	public String getCtid() {
		return ctid;
	}
	public void setCtid(String ctid) {
		this.ctid = ctid;
	}
	public BigDecimal getCtVs() {
		return ctVs;
	}
	public void setCtVs(BigDecimal ctVs) {
		this.ctVs = ctVs;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getFileSize() {
		return fileSize;
	}
	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}
	public String getOutVs() {
		return outVs;
	}
	public void setOutVs(String outVs) {
		this.outVs = outVs;
	}
	public String getUpgrageType() {
		return upgrageType;
	}
	public void setUpgrageType(String upgrageType) {
		this.upgrageType = upgrageType;
	}
	public String getVsRemark() {
		return vsRemark;
	}
	public void setVsRemark(String vsRemark) {
		this.vsRemark = vsRemark;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getServertime() {
		return servertime;
	}
	public void setServertime(String servertime) {
		this.servertime = servertime;
	}
	
}
