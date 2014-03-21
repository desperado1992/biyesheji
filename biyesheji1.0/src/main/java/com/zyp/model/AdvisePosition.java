package com.zyp.model;

import java.io.Serializable;

import javax.persistence.Embedded;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
@Entity
@Table(name="advisePosition",schema="")
@DynamicUpdate(true)
@DynamicInsert(true)

@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class AdvisePosition implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6479188464744571118L;

	@Id
	@GeneratedValue
	private  Long id;
	@Column(length=20)
	private String name;
	
	@Embedded
	private Attributes wh;//宽度高度
	
	private String description;//描述

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

	public Attributes getWh() {
		return wh;
	}

	public void setWh(Attributes wh) {
		this.wh = wh;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public AdvisePosition() {
	
	}
	

	
	
	
	
}
