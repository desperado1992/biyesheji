package com.zyp.model;



import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;


import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.opensymphony.xwork2.ActionContext;




@Entity
@Table(name="user",schema="")
@DynamicUpdate(true)
@DynamicInsert(true)
  
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)  
public class User implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 4350500183225664573L;
	
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
	
	private  String name;//用户真实名字
	
	
	private String logName;//用户登录名

	private String  password;//用户登录密码
	
	private Date regDate;//用户注册时间
	
	private Date lastLogDate;//用户最后一次登录的时间
	
	
	private String email;//用户邮箱
	
	private int status;//0为 正常 1为 禁用账号

	private String face;//用户头像
	
	
	private List<Address> addresses=new ArrayList<Address>();//用户送货地址
	
	private  BigDecimal money=new BigDecimal(0);//用户现金帐户余额
	
	
	private Set<Role> roles=new HashSet<Role>();//用户与角色多对多的关系

	
	
	private String ipaddress;

	
	private Set<Article> articles=new HashSet<Article>();
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="author")
	public Set<Article> getArticles()
	{
		return articles;
	}

	public void setArticles(Set<Article> articles)
	{
		this.articles = articles;
	}
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="user_role")
	public Set<Role> getRoles()
	{
		return roles;
	}

	public void setRoles(Set<Role> roles)
	{
		this.roles = roles;
	}




	
  
	public String getFace()
	{
		return face;
	}

	public void setFace(String face)
	{
		this.face = face;
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
	@Column(length=40,unique=true)
	public String getLogName()
	{
		return logName;
	}

	public void setLogName(String logName)
	{
		this.logName = logName;
	}
	@Column(length=40)
	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public Date getRegDate()
	{
		return regDate;
	}

	public void setRegDate(Date regDate)
	{
		this.regDate = regDate;
	}

	public Date getLastLogDate()
	{
		return lastLogDate;
	}

	public void setLastLogDate(Date lastLogDate)
	{
		this.lastLogDate = lastLogDate;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	
	
	@OneToMany
	public List<Address> getAddresses()
	{
		return addresses;
	}

	public void setAddresses(List<Address> addresses)
	{
		this.addresses = addresses;
	}

	public BigDecimal getMoney()
	{
		return money;
	}

	public void setMoney(BigDecimal money)
	{
		this.money = money;
	}

	


	@Column(length=40)
	public String getIpaddress()
	{
		return ipaddress;
	}

	public void setIpaddress(String ipaddress)
	{
		this.ipaddress = ipaddress;
	}
	
	
	
	public int getStatus()
	{
		return status;
	}

	public void setStatus(int status)
	{
		this.status = status;
	}

	public User()
	{
	
	}
	 /**
		 * 是否是超级管理员
		 * 
		 * @return
		 */  
	private boolean tisAdmin() {
		// TODO Auto-generated method stub
		
		return "admin".equals(logName);
	}
	/**
	    * 判断本用户是否有指定的权限
	    * @return
	    */
	 public boolean hasPrivilegeByName(String privilegeName){
		 /***
		  * 对于管理员来说
		  */
		 if(tisAdmin()){
			 
			 return true;
		 }
		 
		 
		 
		 /**
		  * 对于一般用户
		  */
		 for(Role role:roles){
			
			for(Privilege privilege : role.getPrivileges()){
				
				if(privilege.getName().equals(privilegeName)){
					return true;
				}
			}
			 
		 }
		 
		 
		 return false;
	 }
	 
	 /**
	  * 判断本用户是否有指定的权限
	  * @return
	  */
	@SuppressWarnings("unchecked")
	public boolean hasPrivilegeByUrl(String privilegeUrl){
		 /***
		  * 对于管理员来说
		  */
		 if(tisAdmin()){
			 
			 return true;
		 }
		
		List<String> allPrivilegeUrls=(List<String>) ActionContext.getContext().getApplication().get("allPrivilegeUrls");
		 if(privilegeUrl.endsWith("UI")){
			 privilegeUrl=privilegeUrl.substring(0, privilegeUrl.length()-2);
		 }
		 /**
		  * 对于一般用户
		  */
		 if(!allPrivilegeUrls.contains(privilegeUrl)){
			 return true;//如果不是需要控制的功能那么所有用户都能使用！
		 }else{
		 for(Role role:roles){
			for(Privilege privilege : role.getPrivileges()){
				if(privilegeUrl.equals(privilege.getUrl())){
					return true;
				}
			}
			 
		 }
		 
		 
		 return false;
		 }
	}
	
	
}
