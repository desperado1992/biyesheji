package com.zyp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
@Entity
@Table(name="payModel",schema="")
@DynamicInsert(true)
@DynamicUpdate(true)
 
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE) 
public class PayModel implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9105769528597328331L;

	@Id
	@GeneratedValue
	private Long id;
	@Column(length=20)
	private String name;
	@Column(length=40)
	private String icon;
	
	private String description;
	@Column(length=4)
	private int sort;//排序
	
	@Transient
	private String Link;

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getIcon()
	{
		return icon;
	}

	public void setIcon(String icon)
	{
		this.icon = icon;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public int getSort()
	{
		return sort;
	}

	public void setSort(int sort)
	{
		this.sort = sort;
	}

	public String getLink()
	{
		return Link;
	}

	public void setLink(String link)
	{
		Link = link;
	}

	public PayModel()
	{
		
	}
	
	
}
