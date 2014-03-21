package com.zyp.model;

import java.io.Serializable;


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
@Table(name="specification",schema="")
@DynamicInsert(true)
@DynamicUpdate(true)

@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)  
public class Specification implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1217304306383803145L;

	private Long id;
	
	private String color;
	
	private String measures;//尺码
	
	private String name;//规格名
	@Id
	@GeneratedValue
	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}
	@Column(length=40)	
	public String getColor()
	{
		return color;
	}

	public void setColor(String color)
	{
		this.color = color;
	}
	@Column(length=40)
	public String getMeasures()
	{
		return measures;
	}

	public void setMeasures(String measures)
	{
		this.measures = measures;
	}
	@Column(length=40)
	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Specification()
	{
		
	}
	
	
	
	
}
