package com.zyp.model;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Comment implements Serializable
{

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4359600388977848942L;

	
	@Column(length=50)
	private String name;
	
	private String content;
	
	private Date postTime;


	

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getContent()
	{
		return content;
	}

	public void setContent(String content)
	{
		this.content = content;
	}

	public Date getPostTime()
	{
		return postTime;
	}

	public void setPostTime(Date postTime)
	{
		this.postTime = postTime;
	}



	public Comment()
	{
	}
	
	
	
}
