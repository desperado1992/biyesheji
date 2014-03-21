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
@Table(name="discount",schema="")
@DynamicInsert(true)
@DynamicUpdate(true)
 
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)  
public class Discount implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1208767655576770934L;
	 @Id
	 @GeneratedValue
    private Long id;
	 @Column(length=2)
    private int type;//折后类型 0为 百分比 1为 价格直接减少
	 @Column(length=40)
    private String name;//折后的名称 如节日 季节  降价

    private float point;//如果折扣类型为0 这位小于1的数 如果类型为1 这位大于1的值

    
   
	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public int getType()
	{
		return type;
	}

	public void setType(int type)
	{
		this.type = type;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public float getPoint()
	{
		return point;
	}

	public void setPoint(float point)
	{
		this.point = point;
	}

	public Discount()
	{
		
	}

    
    
}
