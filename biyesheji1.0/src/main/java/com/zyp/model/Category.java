package com.zyp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.FetchType;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class Category implements Serializable
{

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4260988148859650746L;

	private String id;
	
	private String name;//分类名称
	
	private String description;//分类描述
	
	private Category parent;
	
	
	
	private List<Category> childrens=new ArrayList<Category>();

	
	@Id
	@GenericGenerator(name="idGenerator",strategy="uuid")
	@GeneratedValue(generator="idGenerator")
	public String getId()
	{
		return id;
	}

	public void setId(String id)
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

	public Category()
	{
		
	}
	@ManyToOne
	@JoinColumn(name="pid")
	public Category getParent()
	{
		return parent;
	}

	public void setParent(Category parent)
	{
		this.parent = parent;
	}
	@OneToMany(targetEntity=Category.class,cascade=CascadeType.ALL,fetch=FetchType.EAGER,mappedBy="parent")
	public List<Category> getChildrens()
	{
		return childrens;
	}

	public void setChildrens(List<Category> childrens)
	{
		this.childrens = childrens;
	}
	
	
	
	
}
