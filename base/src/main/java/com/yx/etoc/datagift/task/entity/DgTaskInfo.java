package com.yx.etoc.datagift.task.entity;



import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.yx.etoc.datagift.app.entity.DgAppInfo;
import com.yx.etoc.datagift.cd.entity.DgCdInfoH;
import com.yx.etoc.datagift.ct.entity.DgCtUser;


/**
 * The persistent class for the dg_task_info database table.
 * 
 */
@Entity
@Table(name="dg_task_info")
public class DgTaskInfo implements Serializable,Comparable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="TASK_ID")
	private String taskId;

	@Column(name="CREDIT_COUNT")
	private Integer creditCount;

	@Temporal( TemporalType.TIMESTAMP)
	@Column(name="END_TIME")
	private Date endTime;

	@Column(name="EXPE_COUNT")
	private Integer expeCount;

	@Temporal( TemporalType.TIMESTAMP)
	@Column(name="START_TIME")
	private Date startTime;

	@Column(name="TARGET_COUNT")
	private Integer targetCount;

	@Column(name="TASK_NAME")
	private String taskName;

	@Column(name="TASK_REMARK")
	private String taskRemark;

	@Column(name="TASK_STATUS")
	private String taskStatus;

	@Column(name="TASK_TYPE")
	private String taskType;
	
	@OneToMany(mappedBy="dgTaskInfo",cascade={CascadeType.REFRESH},fetch=FetchType.LAZY)
	@OrderBy("updateTime DESC")
	private List<DgCdInfoH> dgCdDetail = Lists.newArrayList();
	
	@ManyToMany(mappedBy="tasks",fetch = FetchType.LAZY)
	private Set<DgCtUser> users = Sets.newTreeSet();

    public DgTaskInfo() {
    }

	public String getTaskId() {
		return this.taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public Integer getCreditCount() {
		return this.creditCount;
	}

	public void setCreditCount(Integer creditCount) {
		this.creditCount = creditCount;
	}

	public Integer getExpeCount() {
		return this.expeCount;
	}

	public void setExpeCount(Integer expeCount) {
		this.expeCount = expeCount;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Integer getTargetCount() {
		return this.targetCount;
	}

	public void setTargetCount(Integer targetCount) {
		this.targetCount = targetCount;
	}

	public String getTaskName() {
		return this.taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getTaskRemark() {
		return this.taskRemark;
	}

	public void setTaskRemark(String taskRemark) {
		this.taskRemark = taskRemark;
	}

	public String getTaskStatus() {
		return this.taskStatus;
	}

	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}

	public String getTaskType() {
		return this.taskType;
	}

	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}

	public List<DgCdInfoH> getDgCdDetail() {
		return dgCdDetail;
	}

	public void setDgCdDetail(List<DgCdInfoH> dgCdDetail) {
		this.dgCdDetail = dgCdDetail;
	}
	public int compareTo(Object o) {
		DgTaskInfo obj = (DgTaskInfo)o;
		return this.taskType.compareTo(obj.getTaskType());
	}

	public Set<DgCtUser> getUsers() {
		return users;
	}

	public void setUsers(Set<DgCtUser> users) {
		this.users = users;
	}
	
}