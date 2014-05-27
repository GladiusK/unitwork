package com.yx.etoc.datagift.ct.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.FetchMode;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.yx.baseframe.util.DateTools;
import com.yx.etoc.datagift.app.entity.DgAppInfo;
import com.yx.etoc.datagift.cd.entity.DgCdInfoH;
import com.yx.etoc.datagift.task.entity.DgTaskInfo;


/**
 * The persistent class for the dg_ct_user database table.
 * 
 */
@Entity
@Table(name="dg_ct_user")
public class DgCtUser implements Serializable,Comparable{
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="USER_ID")
	private String userId;

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
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name ="dg_app_down_h", joinColumns=@JoinColumn(name ="USER_ID"),inverseJoinColumns=@JoinColumn(name ="APP_ID"))
	private Set<DgAppInfo> apps = Sets.newTreeSet();
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "dg_task_user_rel", joinColumns=@JoinColumn(name = "USER_ID"),inverseJoinColumns=@JoinColumn(name ="TASK_ID"))
	private Set<DgTaskInfo> tasks = Sets.newTreeSet();
	
	@OneToMany(mappedBy="ctuser",cascade=CascadeType.REFRESH,fetch=FetchType.LAZY)
	@OrderBy("updateTime DESC")
	private List<DgCdInfoH> creditDetail = Lists.newArrayList();
	
    public Set<DgTaskInfo> getTasks() {
		return tasks;
	}

	public void setTasks(Set<DgTaskInfo> tasks) {
		this.tasks = tasks;
	}

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

	@Override
	public int hashCode() {
		final Integer prime = 31;
		Integer result = 1;
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


	public Set<DgAppInfo> getApps() {
		return apps;
	}

	public void setApps(Set<DgAppInfo> apps) {
		this.apps = apps;
	}

	public List<DgCdInfoH> getCreditDetail() {
		return creditDetail;
	}

	public void setCreditDetail(List<DgCdInfoH> creditDetail) {
		this.creditDetail = creditDetail;
	}

	public int compareTo(Object o) {
		DgCtUser obj = (DgCtUser)o;
		if(this.getRemainCredit() > obj.getRemainCredit()){
			return 1;
		}else if (this.getRemainCredit() == obj.getRemainCredit()){
			return 0;
		}else{
			return -1;
		}
	}
}