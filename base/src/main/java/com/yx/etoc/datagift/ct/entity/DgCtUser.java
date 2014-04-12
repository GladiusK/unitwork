package com.yx.etoc.datagift.ct.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.google.common.collect.Sets;
import com.yx.etoc.datagift.app.entity.DgAppInfo;
import com.yx.etoc.datagift.cd.entity.DgCdInfoH;


/**
 * The persistent class for the dg_ct_user database table.
 * 
 */
@Entity
@Table(name="dg_ct_user")
public class DgCtUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="USER_ID")
	private String userId;

	private String channel;

	@Column(name="CT_VS")
	private String ctVs;

	@Column(name="DEVICE_TYPE")
	private String deviceType;

	private int expe;

	private int grade;

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
	private int remainCredit;

	private String resolution;

	private String sex;

	private String status;

	@Column(name="TEL_NUM")
	private String telNum;

	@Column(name="TOTAL_CREDIT")
	private int totalCredit;
	
	@ManyToMany
	@JoinTable(name ="dg_app_down_h", joinColumns=@JoinColumn(name ="USER_ID"),inverseJoinColumns=@JoinColumn(name ="APP_ID"))
	private Set<DgAppInfo> apps = Sets.newHashSet();
	
	@OneToMany(mappedBy="ctuser",cascade=CascadeType.REFRESH,fetch=FetchType.LAZY)
	private Set<DgCdInfoH> creditDetail = Sets.newTreeSet();
	

    public DgCtUser() {
    }

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	public int getExpe() {
		return this.expe;
	}

	public void setExpe(int expe) {
		this.expe = expe;
	}

	public int getGrade() {
		return this.grade;
	}

	public void setGrade(int grade) {
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

	public int getRemainCredit() {
		return this.remainCredit;
	}

	public void setRemainCredit(int remainCredit) {
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

	public int getTotalCredit() {
		return this.totalCredit;
	}

	public void setTotalCredit(int totalCredit) {
		this.totalCredit = totalCredit;
	}

	public Set<DgAppInfo> getApps() {
		return apps;
	}

	public void setApps(Set<DgAppInfo> apps) {
		this.apps = apps;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DgCtUser other = (DgCtUser) obj;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	public Set<DgCdInfoH> getCreditDetail() {
		return creditDetail;
	}

	public void setCreditDetail(Set<DgCdInfoH> creditDetail) {
		this.creditDetail = creditDetail;
	}
	
}