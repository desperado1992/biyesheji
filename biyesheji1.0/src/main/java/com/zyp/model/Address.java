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
@Table(name="address",schema="")
@DynamicUpdate(true)
@DynamicInsert(true)

@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)  
public class Address implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2407161404152846526L;
	@Id
	@GeneratedValue
	private Long id;
	@Column(length=20)
	private String name;

	@Column(length=18)
	private String phone;
	@Column(length=10)
	private String postcode;
	
	private User user;
	
	
	public Long getId()
	{
		return id;
	}
	public void setId(Long id)
	{
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Address [id=" + id + ", name=" + name + ", phone=" + phone
				+ ", postcode=" + postcode + "]";
	}
}
