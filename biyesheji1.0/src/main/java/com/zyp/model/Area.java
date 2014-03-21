package com.zyp.model;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
@Entity
@Table(name="area",schema="")
@DynamicUpdate(true)
@DynamicInsert(true)
 
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)  
public class Area implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -445193262528709285L;

	
	@EmbeddedId  
	private AreaItem areaItem;
	
	@Column(length=20)
	private String name;
	
	private String description;

	public AreaItem getAreaItem()
	{
		return areaItem;
	}

	public void setAreaItem(AreaItem areaItem)
	{
		this.areaItem = areaItem;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public Area()
	{
	
	}
	
	
	
	
}
