package com.yx.etoc.datagift.app.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the dg_app_category database table.
 * 
 */
@Entity
@Table(name="dg_app_category")
public class DgAppCategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CATEGORY_ID")
	private String categoryId;

	@Column(name="CATEGORY_NAME")
	private String categoryName;

	@Column(name="LAST_UPDATE_TIME")
	private String lastUpdateTime;

	@Column(name="LAST_UPDATE_USER")
	private String lastUpdateUser;

	@Column(name="PARENT_ID")
	private String parentId;

	@Column(name="TYPE_REMARK")
	private String typeRemark;

	private BigDecimal weight;

    public DgAppCategory() {
    }

	public String getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return this.categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
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

	public String getParentId() {
		return this.parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getTypeRemark() {
		return this.typeRemark;
	}

	public void setTypeRemark(String typeRemark) {
		this.typeRemark = typeRemark;
	}

	public BigDecimal getWeight() {
		return this.weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}

}