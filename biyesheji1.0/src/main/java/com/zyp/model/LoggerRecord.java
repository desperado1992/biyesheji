package com.zyp.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
@Entity
@Table(name="logger",schema="")
@DynamicInsert(true)
@DynamicUpdate(true)
public class LoggerRecord implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7270461672843320189L;

	@Id
	@GeneratedValue
	private Long id;
	
    private String name;//用户名
    
    private String operater;
    
    private Date currentTime;

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

	public String getOperater() {
		return operater;
	}

	public void setOperater(String operater) {
		this.operater = operater;
	}

	public Date getCurrentTime() {
		return currentTime;
	}

	public void setCurrentTime(Date currentTime) {
		this.currentTime = currentTime;
	}

	public LoggerRecord() {
	
	}

	public LoggerRecord(String operater, Date currentTime) {
	
		this.operater = operater;
		this.currentTime = currentTime;
	}
    
    
    
	
	
}
