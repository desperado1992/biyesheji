package com.zyp.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="goods",schema="")
@DynamicInsert(true)
@DynamicUpdate(true)

@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)  
public class Goods implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6121410158465325000L;

	@Id
	@GenericGenerator(name="idGenerator",strategy="uuid")
	@GeneratedValue(generator="idGenerator")
	private String id;
	@Column(length=60)
	private String name;
	
	private String description;
	
	@ManyToOne
	@JoinColumn(name="brandId")
	private Brand brand;//品牌
	
	@ManyToOne
	@JoinColumn(name="categoryId")
	private Category category;//分类
	
	@OneToMany
	private List<Specification> specifications=new ArrayList<Specification>();//规格
	
	@ManyToOne
	@JoinColumn(name="discountId")
	private Discount discount;
	
	private BigDecimal price;
	
	private int stock;//库存
	@ElementCollection  
	private List<String> img=new ArrayList<String>();//图片
	
	/**
	 * 有两个状态，1表示购买商品  0表示正在审批商品  -1表示下架的商品
	 */
	private int status;
	
	private String contents;
	
	private Date postTime;
	
	private Date updateTime;
	
	@ElementCollection
	private Map<User,Comment> comments=new HashMap<User, Comment>();

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

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

	public Brand getBrand()
	{
		return brand;
	}

	public void setBrand(Brand brand)
	{
		this.brand = brand;
	}

	public Category getCategory()
	{
		return category;
	}

	public void setCategory(Category category)
	{
		this.category = category;
	}

	

	public Discount getDiscount()
	{
		return discount;
	}

	public void setDiscount(Discount discount)
	{
		this.discount = discount;
	}

	public BigDecimal getPrice()
	{
		return price;
	}

	public void setPrice(BigDecimal price)
	{
		this.price = price;
	}

	public String getContents()
	{
		return contents;
	}

	public void setContents(String contents)
	{
		this.contents = contents;
	}

	public Date getPostTime()
	{
		return postTime;
	}

	public void setPostTime(Date postTime)
	{
		this.postTime = postTime;
	}

	public Date getUpdateTime()
	{
		return updateTime;
	}

	public void setUpdateTime(Date updateTime)
	{
		this.updateTime = updateTime;
	}

	

	public List<Specification> getSpecifications()
	{
		return specifications;
	}

	public void setSpecifications(List<Specification> specifications)
	{
		this.specifications = specifications;
	}
	
	
	
	public int getStock()
	{
		return stock;
	}

	public void setStock(int stock)
	{
		this.stock = stock;
	}

	
	
	

	public List<String> getImg()
	{
		return img;
	}

	public void setImg(List<String> img)
	{
		this.img = img;
	}

	public int getStatus()
	{
		return status;
	}

	public void setStatus(int status)
	{
		this.status = status;
	}

	
	
	public Map<User, Comment> getComments()
	{
		return comments;
	}

	public void setComments(Map<User, Comment> comments)
	{
		this.comments = comments;
	}

	public Goods()
	{
		
	}
	
	
	
	
}
