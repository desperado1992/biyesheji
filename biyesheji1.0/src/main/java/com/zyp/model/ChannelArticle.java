package com.zyp.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
@Entity
@Table(name="cArticle",schema="")
@DynamicInsert(true)
@DynamicUpdate(true)
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class ChannelArticle extends Article implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ChannelArticle() {
		
	}

	 @ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	 @JoinColumn(name="chanArticleCateId")
	private ChannelArticleCategory cArticleCategory;

	public ChannelArticleCategory getcArticleCategory() {
		return cArticleCategory;
	}

	public void setcArticleCategory(ChannelArticleCategory cArticleCategory) {
		this.cArticleCategory = cArticleCategory;
	}
	
	
	
	
}
