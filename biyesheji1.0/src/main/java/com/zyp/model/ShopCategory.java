package com.zyp.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
@Entity
@Table(name="shcategory",schema="")
@DynamicInsert(true)
@DynamicUpdate(true)
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class ShopCategory extends Category implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6578214996261936453L;

	public ShopCategory() {
		super();
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
