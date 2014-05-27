package com.yx.etoc.datagift.prize.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;


/**
 * The persistent class for the dg_prize_detail database table.
 * 
 */
@Entity
@Table(name="dg_prize_detail")
public class DgPrizeDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="PRIZE_ID")
	private String prizeId;

	@Column(name="MAX_ANGLE")
	private String maxAngle;

	@Column(name="MIN_ANGLE")
	private String minAngle;

	@Column(name="PRIZE_COUNT")
	private Integer prizeCount;

	@Column(name="PRIZE_NAME")
	private String prizeName;

	@Column(name="PRIZE_PROBA")
	private Integer prizeProba;

	@Column(name="PRIZE_REMARK")
	private String prizeRemark;

	@Version
	@Column(name="version")
	private Integer version;
	
	@Column(columnDefinition="TIMESTAMP", insertable = false, updatable = false) 
	//加上面那段的目的是让mysql自动更新数据库，如果不加的话，JPA默认插入相同的数据，而mysql为了效率着想，如果timestamp是相同数据就不会进行自动更新
	@Temporal(TemporalType.TIMESTAMP)
	private Date test;  

	public Date getTest() {
		return test;
	}

	public void setTest(Date test) {
		this.test = test;
	}

	private BigDecimal weight;

    public DgPrizeDetail() {
    }

	public String getPrizeId() {
		return this.prizeId;
	}

	public void setPrizeId(String prizeId) {
		this.prizeId = prizeId;
	}

	public String getMaxAngle() {
		return this.maxAngle;
	}

	public void setMaxAngle(String maxAngle) {
		this.maxAngle = maxAngle;
	}

	public String getMinAngle() {
		return this.minAngle;
	}

	public void setMinAngle(String minAngle) {
		this.minAngle = minAngle;
	}

	public Integer getPrizeCount() {
		return this.prizeCount;
	}

	public void setPrizeCount(Integer prizeCount) {
		this.prizeCount = prizeCount;
	}

	public String getPrizeName() {
		return this.prizeName;
	}

	public void setPrizeName(String prizeName) {
		this.prizeName = prizeName;
	}

	public Integer getPrizeProba() {
		return this.prizeProba;
	}

	public void setPrizeProba(Integer prizeProba) {
		this.prizeProba = prizeProba;
	}

	public String getPrizeRemark() {
		return this.prizeRemark;
	}

	public void setPrizeRemark(String prizeRemark) {
		this.prizeRemark = prizeRemark;
	}

	public BigDecimal getWeight() {
		return this.weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		if(version == null){
			this.version = 0;
		}else{
			this.version = version;
		}
		
	}

}