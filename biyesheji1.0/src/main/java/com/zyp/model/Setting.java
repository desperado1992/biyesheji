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
@Table(name="setting",schema="")
@DynamicInsert(true)
@DynamicUpdate(true)

@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)  
public class Setting  implements Serializable
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1784564991755842652L;

	
	private Long id;
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

	private String name;//页面常用设置名称英文
	
	private String description;//页面常用设置中文描述
	
	private String value;//页面设置的值
	public Setting()
	{
		
	}
	
	public Setting(String name, String description,String value)
	{
		
		this.name = name;
		this.description = description;
		this.value=value;
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
	public String getDescription()
	{
		return description;
	}
	public void setDescription(String description)
	{
		this.description = description;
	}

	public String getValue()
	{
		return value;
	}

	public void setValue(String value)
	{
		this.value = value;
	}

	
	
	
	
	
	
}
