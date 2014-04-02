package com.yx.etoc.datagift.app.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.google.common.collect.Lists;

/**
 * The persistent class for the dg_app_info database table.
 * 
 */
@Entity
@Table(name = "dg_app_info")
public class DgAppInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "APP_ID")
	private String appId;

	@Column(name = "APP_FILE")
	private String appFile;

	@Column(name = "APP_ICON")
	private String appIcon;

	@Column(name = "APP_NAME")
	private String appName;

	@Column(name = "APP_REMARK")
	private String appRemark;

	@Column(name = "APP_SIZE")
	private String appSize;

	@OneToOne(cascade = { CascadeType.ALL }, optional = false, fetch = FetchType.EAGER, targetEntity = DgAppCategory.class)
	@JoinColumn(name = "CATEGORY_ID", nullable = false, updatable = false)
	@JsonIgnore
	private DgAppCategory category;

	@Column(name = "CREDIT_COUNT")
	private int creditCount;

	@Column(name = "EXPE_COUNT")
	private int expeCount;

	@Column(name = "FIRE_RULE")
	private String fireRule;

	@Column(name = "FLUX_COUNT")
	private int fluxCount;

	@Column(name = "LAST_UPDATE_TIME")
	private String lastUpdateTime;

	@Column(name = "LAST_UPDATE_USER")
	private String lastUpdateUser;

	@Column(name = "PACKAGE_NAME")
	private String packageName;

	private String step;

	private BigDecimal weight;
	
	@OneToMany(mappedBy="appinfo",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JsonIgnore
	private List<DgAppImg> imgs = Lists.newArrayList();

	public DgAppInfo() {
	}

	public String getAppId() {
		return this.appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getAppFile() {
		return this.appFile;
	}

	public void setAppFile(String appFile) {
		this.appFile = appFile;
	}

	public String getAppIcon() {
		return this.appIcon;
	}

	public void setAppIcon(String appIcon) {
		this.appIcon = appIcon;
	}

	public String getAppName() {
		return this.appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getAppRemark() {
		return this.appRemark;
	}

	public void setAppRemark(String appRemark) {
		this.appRemark = appRemark;
	}

	public String getAppSize() {
		return this.appSize;
	}

	public void setAppSize(String appSize) {
		this.appSize = appSize;
	}

	public int getCreditCount() {
		return this.creditCount;
	}

	public void setCreditCount(int creditCount) {
		this.creditCount = creditCount;
	}

	public int getExpeCount() {
		return this.expeCount;
	}

	public void setExpeCount(int expeCount) {
		this.expeCount = expeCount;
	}

	public String getFireRule() {
		return this.fireRule;
	}

	public void setFireRule(String fireRule) {
		this.fireRule = fireRule;
	}

	public int getFluxCount() {
		return this.fluxCount;
	}

	public void setFluxCount(int fluxCount) {
		this.fluxCount = fluxCount;
	}

	public String getLastUpdateTime() {
		return this.lastUpdateTime;
	}

	public void setLastUpdateTime(String lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	public String getLastUpdateUser() {
		return lastUpdateUser;
	}

	public void setLastUpdateUser(String lastUpdateUser) {
		this.lastUpdateUser = lastUpdateUser;
	}

	public String getPackageName() {
		return this.packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getStep() {
		return this.step;
	}

	public void setStep(String step) {
		this.step = step;
	}

	public BigDecimal getWeight() {
		return this.weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}
	
	@JsonIgnore
	public DgAppCategory getCategory() {
		return category;
	}

	public void setCategory(DgAppCategory category) {
		this.category = category;
	}

	@JsonIgnore
	public List<DgAppImg> getImgs() {
		return imgs;
	}

	public void setImgs(List<DgAppImg> imgs) {
		this.imgs = imgs;
	}

	
}