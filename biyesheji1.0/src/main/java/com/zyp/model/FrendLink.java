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
@Table(name="frendlink",schema="")
@DynamicInsert(true)
@DynamicUpdate(true)
 
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)  
public class FrendLink implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6711784803686015833L;

	@Id
	@GeneratedValue
	private Long id;
	@Column(length=20)
	private String name;
	@Column(length=50)
	private String url;
	
	private String description;

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

	public String getUrl()
	{
		return url;
	}

	public void setUrl(String url)
	{
		this.url = url;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public FrendLink()
	{
		
	}
	
	
	
	
}
