package com.zyp.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
@Entity
@Table(name="advise",schema="")
@DynamicUpdate(true)
@DynamicInsert(true)

@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class Advise implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6435204815695906757L;

	/**
	 * 
	 */
	
	

	@Id
	@GeneratedValue
	private Long id;
	@Column(length=20)
	private String name;//广告名称
	
	private String content;//脚本可以是
	
	private AdviseType adviseType;//类型
	
	private Date startTime;//起始日期
	
	private Date stopTime;//终止日期

	@ManyToOne
	@JoinColumn(name="adPositionId")
	private AdvisePosition advisePosition;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	
	
	
	public AdviseType getAdviseType() {
		return adviseType;
	}

	public void setAdviseType(AdviseType adviseType) {
		this.adviseType = adviseType;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getStopTime() {
		return stopTime;
	}

	public void setStopTime(Date stopTime) {
		this.stopTime = stopTime;
	}

	
	
	
	public AdvisePosition getAdvisePosition() {
		return advisePosition;
	}

	public void setAdvisePosition(AdvisePosition advisePosition) {
		this.advisePosition = advisePosition;
	}

	public Advise() {
	
	}

	

	

	
	
	
	
	
	
	
}
