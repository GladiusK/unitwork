package com.yx.etoc.datagift.ct.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the dg_ct_user_change_log database table.
 * 
 */
@Entity
@Table(name="dg_ct_user_change_log")
public class DgCtUserChangeLog implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DgCtUserChangeLogPK id;

	private String channel;

	@Column(name="CT_VS")
	private String ctVs;

	@Column(name="DEVICE_TYPE")
	private String deviceType;

	private Integer expe;

	private Integer grade;

	private String imei;

	@Column(name="IMG_PATH")
	private String imgPath;

	private String imsi;

	private String ip;

	private String mac;

	@Column(name="NET_TYPE")
	private String netType;

	private String nickname;

	@Column(name="OUT_VS")
	private String outVs;

	private String pass;

	@Column(name="REMAIN_CREDIT")
	private Integer remainCredit;

	private String resolution;

	private String sex;

	private String status;

	@Column(name="TEL_NUM")
	private String telNum;

	@Column(name="TOTAL_CREDIT")
	private Integer totalCredit;

    public DgCtUserChangeLog() {
    }

	public DgCtUserChangeLogPK getId() {
		return this.id;
	}

	public void setId(DgCtUserChangeLogPK id) {
		this.id = id;
	}
	
	public String getChannel() {
		return this.channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getCtVs() {
		return this.ctVs;
	}

	public void setCtVs(String ctVs) {
		this.ctVs = ctVs;
	}

	public String getDeviceType() {
		return this.deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	public Integer getExpe() {
		return this.expe;
	}

	public void setExpe(Integer expe) {
		this.expe = expe;
	}

	public Integer getGrade() {
		return this.grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public String getImei() {
		return this.imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public String getImgPath() {
		return this.imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public String getImsi() {
		return this.imsi;
	}

	public void setImsi(String imsi) {
		this.imsi = imsi;
	}

	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getMac() {
		return this.mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	public String getNetType() {
		return this.netType;
	}

	public void setNetType(String netType) {
		this.netType = netType;
	}

	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getOutVs() {
		return this.outVs;
	}

	public void setOutVs(String outVs) {
		this.outVs = outVs;
	}

	public String getPass() {
		return this.pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public Integer getRemainCredit() {
		return this.remainCredit;
	}

	public void setRemainCredit(Integer remainCredit) {
		this.remainCredit = remainCredit;
	}

	public String getResolution() {
		return this.resolution;
	}

	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTelNum() {
		return this.telNum;
	}

	public void setTelNum(String telNum) {
		this.telNum = telNum;
	}

	public Integer getTotalCredit() {
		return this.totalCredit;
	}

	public void setTotalCredit(Integer totalCredit) {
		this.totalCredit = totalCredit;
	}

}