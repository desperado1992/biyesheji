package com.zyp.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name="sales",schema="")
@DynamicInsert(true)
@DynamicUpdate(true)

@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)  
public class Sales implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2381275907946240510L;
	//销售编号
	@Id
	@GenericGenerator(name="idGenerator",strategy="uuid")
	@GeneratedValue(generator="idGenerator")
	private String id;
	//商品编号
	private String goodId;
	//销售价格
	private BigDecimal price;
	//销售数量
	private Long  quantity;
	//销售日期
	private Date SaleDate;

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getGoodId()
	{
		return goodId;
	}

	public void setGoodId(String goodId)
	{
		this.goodId = goodId;
	}

	public BigDecimal getPrice()
	{
		return price;
	}

	public void setPrice(BigDecimal price)
	{
		this.price = price;
	}

	public Long getQuantity()
	{
		return quantity;
	}

	public void setQuantity(Long quantity)
	{
		this.quantity = quantity;
	}

	public Date getSaleDate()
	{
		return SaleDate;
	}

	public void setSaleDate(Date saleDate)
	{
		SaleDate = saleDate;
	}

	public Sales()
	{
		
	}
	
	
}
