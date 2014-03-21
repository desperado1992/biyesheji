package com.zyp.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
@Entity
@Table(name="forum",schema="")
@DynamicUpdate(true)
@DynamicInsert(true)
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class Forum implements java.io.Serializable{
   /**
	 * 论坛版块实体
	 */
	private static final long serialVersionUID = 1L;
   @Id
   @GeneratedValue
   private Long id;
	
	
   private String name;
   private String description;
   private int position;
   @OneToMany(fetch=FetchType.EAGER,mappedBy="forum")
	private Set<Topic> topics = new HashSet<Topic>();
	private int topicCount; // 主题数
	private int articleCount; // 文章数（主题+回复）
	@OneToOne(cascade = CascadeType.ALL)
	private Topic lastTopic; // 最后发表的主题
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public int getPosition() {
	return position;
}
public void setPosition(int position) {
	this.position = position;
}
public Set<Topic> getTopics() {
	return topics;
}
public void setTopics(Set<Topic> topics) {
	this.topics = topics;
}
public int getTopicCount() {
	return topicCount;
}
public void setTopicCount(int topicCount) {
	this.topicCount = topicCount;
}
public int getArticleCount() {
	return articleCount;
}
public void setArticleCount(int articleCount) {
	this.articleCount = articleCount;
}
public Topic getLastTopic() {
	return lastTopic;
}
public void setLastTopic(Topic lastTopic) {
	this.lastTopic = lastTopic;
}
   
	
	
	
}
