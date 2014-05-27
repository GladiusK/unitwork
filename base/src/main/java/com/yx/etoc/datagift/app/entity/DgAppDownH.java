package com.yx.etoc.datagift.app.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.*;


/**
 * The persistent class for the dg_app_down_h database table.
 * 
 */
@Entity
@Table(name="dg_app_down_h")
public class DgAppDownH implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DgAppDownHPK id;

	@Column(name="LAST_UPDATE_TIME")
	private Timestamp lastUpdateTime;

    public DgAppDownH() {
    }

	public DgAppDownHPK getId() {
		return this.id;
	}

	public void setId(DgAppDownHPK id) {
		this.id = id;
	}

	public Timestamp getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(Timestamp lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
	
}