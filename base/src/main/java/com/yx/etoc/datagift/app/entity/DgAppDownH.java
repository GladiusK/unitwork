package com.yx.etoc.datagift.app.entity;

import java.io.Serializable;
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
	private String lastUpdateTime;

    public DgAppDownH() {
    }

	public DgAppDownHPK getId() {
		return this.id;
	}

	public void setId(DgAppDownHPK id) {
		this.id = id;
	}
	
	public String getLastUpdateTime() {
		return this.lastUpdateTime;
	}

	public void setLastUpdateTime(String lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

}