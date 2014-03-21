package com.zyp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Column;
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
@Table(name="orders",schema="")
@DynamicInsert(true)
@DynamicUpdate(true)
 
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)  
public class Orders implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4388341295985586157L;
	@Id
	@GenericGenerator(name="idGenerator",strategy="uuid")
	@GeneratedValue(generator="idGenerator")
	private String id;
	private Date buyDate;
	private Date payDate;
	private Date confirmDate;
	/**
	 * 四种状态:1表示已下订单、2表示已付款、3、表示已发货、4、表示确认收货
	 */
	
	@Column(length=2)
	private int status;
	@ManyToOne
	@JoinColumn(name="userId")
	private User user;
	private Address address;
	@OneToMany(cascade=CascadeType.ALL,mappedBy="orders")
	private List<CartProduct> products=new ArrayList<CartProduct>();
	/**
	 * 所花费的价格，这个价格是可以修改的
	 */
	private double price;
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
	public String getId()
	{
		return id;
	}
	public void setId(String id)
	{
		this.id = id;
	}
	public Date getBuyDate() {
		return buyDate;
	}
	public void setBuyDate(Date buyDate) {
		this.buyDate = buyDate;
	}
	public Date getPayDate() {
		return payDate;
	}
	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}
	public Date getConfirmDate() {
		return confirmDate;
	}
	public void setConfirmDate(Date confirmDate) {
		this.confirmDate = confirmDate;
	}
	/**
	 * 
	 * @return 四种状态:1表示已下订单、2表示已付款、3、表示已发货、4、表示确认收货
	 */
	public int getStatus() {
		return status;
	}
	/**
	 * 
	 * @param status 四种状态:1表示已下订单、2表示已付款、3、表示已发货、4、表示确认收货
	 */
	public void setStatus(int status) {
		this.status = status;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public List<CartProduct> getProducts() {
		return products;
	}
	public void setProducts(List<CartProduct> products) {
		this.products = products;
	}
}
