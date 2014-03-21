package com.zyp.model;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable    
public class Attributes implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3551061372110567126L;
	
	
	

	@Column(length=10)
	private String key1;//可变动的字段
	@Column(length=10)
	private String value1;//可变动的值
	
	
	
	
	
	public String getKey1()
	{
		return key1;
	}
	public void setKey1(String key1)
	{
		this.key1 = key1;
	}
	public String getValue1()
	{
		return value1;
	}
	public void setValue1(String value1)
	{
		this.value1 = value1;
	}
	public Attributes()
	{
	
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((key1 == null) ? 0 : key1.hashCode());
		result = prime * result + ((value1 == null) ? 0 : value1.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Attributes other = (Attributes) obj;
		if (key1 == null) {
			if (other.key1 != null)
				return false;
		} else if (!key1.equals(other.key1))
			return false;
		if (value1 == null) {
			if (other.value1 != null)
				return false;
		} else if (!value1.equals(other.value1))
			return false;
		return true;
	}

	
	
	
	
	
	
	
	
	
}
