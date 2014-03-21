package com.zyp.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

/**
 * 回复类
 * @author zhuyuping
 *
 */
@Entity
@Table(name="reply",schema="")
@DynamicUpdate(true)
@DynamicInsert(true)
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class Reply extends Article implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1266744241155374515L;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="topicId")
   private Topic topic;

public Topic getTopic() {
	return topic;
}

public void setTopic(Topic topic) {
	this.topic = topic;
}
   
	
	
	
	
	
}
