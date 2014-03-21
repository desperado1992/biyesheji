package com.zyp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
@Entity
@Table(name="chcategory",schema="")
@DynamicInsert(true)
@DynamicUpdate(true)
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class ChannelArticleCategory extends Category implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2537537618912869001L;

	@Column(length=2)
	private int sort;
	
	
	private List<ChannelArticle> channelArticles=new ArrayList<ChannelArticle>();
	@OneToMany(cascade=CascadeType.ALL,mappedBy="cArticleCategory")
	public List<ChannelArticle> getChannelArticles() {
		return channelArticles;
	}

	public void setChannelArticles(List<ChannelArticle> channelArticles) {
		this.channelArticles = channelArticles;
	}

	public ChannelArticleCategory() {
	
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}
	
	
	
	
}
