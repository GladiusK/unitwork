package com.yx.etoc.datagift.app.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;


/**
 * The persistent class for the dg_app_img database table.
 * 
 */
@Entity
@Table(name="dg_app_img")
public class DgAppImg implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="IMG_ID")
	private String imgId;

	@JoinColumn(name="APP_ID")
	@ManyToOne(cascade={CascadeType.ALL}, optional=false, fetch=FetchType.LAZY)
	private DgAppInfo appinfo;

	private String img;

	@Column(name="IMG_NAME")
	private String imgName;

	@Column(columnDefinition="TIMESTAMP",insertable = false, updatable = false)
	@OrderBy("lastUpdateTime DESC")
	private Timestamp lastUpdateTime;

	@Column(name="LAST_UPDATE_USER")
	private String lastUpdateUser;

	private BigDecimal weight;

    public DgAppImg() {
    }

	public String getImgId() {
		return this.imgId;
	}

	public void setImgId(String imgId) {
		this.imgId = imgId;
	}

	public DgAppInfo getAppinfo() {
		return appinfo;
	}

	public void setAppinfo(DgAppInfo appinfo) {
		this.appinfo = appinfo;
	}

	public String getImg() {
		return this.img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getImgName() {
		return this.imgName;
	}

	public void setImgName(String imgName) {
		this.imgName = imgName;
	}
	
	public Timestamp getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(Timestamp lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	public String getLastUpdateUser() {
		return lastUpdateUser;
	}

	public void setLastUpdateUser(String lastUpdateUser) {
		this.lastUpdateUser = lastUpdateUser;
	}

	public BigDecimal getWeight() {
		return this.weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}

}