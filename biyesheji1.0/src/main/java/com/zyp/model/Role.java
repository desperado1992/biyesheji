package com.zyp.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


import javax.persistence.Entity;


import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;


@Entity
@Table(name="role",schema="")
@DynamicUpdate(true)
@DynamicInsert(true)

@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)  
public class Role implements Serializable
{
	
   /**
	 * 
	 */
	private static final long serialVersionUID = -9198261741518473657L;
	
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

private String name;
   private String description;
   
  
   private Set<User> users=new HashSet<User>();
   
  
   private Set<Privilege> privileges=new HashSet<Privilege>();
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
@ManyToMany(mappedBy="roles",fetch=FetchType.EAGER)
public Set<User> getUsers()
{
	return users;
}
public void setUsers(Set<User> users)
{
	this.users = users;
}

@ManyToMany(fetch=FetchType.EAGER)
@JoinTable(name="role_privilege")
public Set<Privilege> getPrivileges()
{
	return privileges;
}
public void setPrivileges(Set<Privilege> privileges)
{
	this.privileges = privileges;
}
	
   
	
	
	
	
	
}
