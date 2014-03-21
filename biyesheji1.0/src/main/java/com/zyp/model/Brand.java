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
@Table(name="brand",schema="")
@DynamicInsert(true)
@DynamicUpdate(true)

@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)  
public class Brand implements Serializable
{

  /**
	 * 
	 */
	private static final long serialVersionUID = 2613567421156698534L;

private Long id;
  
  private String name;//品牌
  
  private String description;
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
@Column(length=20)
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

public Brand()
{
	
}
  
  
	
	
}
