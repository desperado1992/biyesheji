package com.zyp.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;


import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;



@Entity
@Table(name="privilege",schema="")
@DynamicInsert(true)
@DynamicUpdate(true)

@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)  
public class Privilege  implements Serializable
{
/**
 * 
 */
	private static final long serialVersionUID = -4294879657433736223L;
	
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
	
	private  String  name;//权限名称
	private  String description;//权限描述
	
	private String url;
	
	private String icon="";
	private  Set<Role> roles=new HashSet<Role>();//角色与权限的多对多的关系
	
	
	private  Privilege parent;//父权限节点自关联
	
	
	
	@Column(length=60)
	public String getUrl()
	{
		return url;
	}


	public void setUrl(String url)
	{
		this.url = url;
	}
	private  Set<Privilege> childrens=new HashSet<Privilege>();//子类权限节点
	
	
	
	@Column(length=40)
	public String getIcon()
	{
		return icon;
	}


	public void setIcon(String icon)
	{
		this.icon = icon;
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

	@ManyToMany(mappedBy="privileges",fetch=FetchType.EAGER)
	public Set<Role> getRoles()
	{
		return roles;
	}
	public void setRoles(Set<Role> roles)
	{
		this.roles = roles;
	}
	@ManyToOne
	@JoinColumn(name="pid")
	public Privilege getParent()
	{
		return parent;
	}
	public void setParent(Privilege parent)
	{
		this.parent = parent;
	}
	@OneToMany(targetEntity=Privilege.class,cascade=CascadeType.ALL,fetch=FetchType.EAGER,mappedBy="parent")
	public Set<Privilege> getChildrens()
	{
		return childrens;
	}
	public void setChildrens(Set<Privilege> childrens)
	{
		this.childrens = childrens;
	}
	public Privilege()
	{
		
	}


	public Privilege(String name, String description, String url, Privilege parent)
	{
		
		this.name = name;
		this.description = description;
		this.url = url;
		this.parent = parent;
	}


	public Privilege(String name, String url, Privilege parent)
	{
		
		this.name = name;
		this.url = url;
		this.parent = parent;
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
