package com.zyp.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Entity;

import javax.persistence.CascadeType;


import javax.persistence.ElementCollection;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;



import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


import org.hibernate.annotations.GenericGenerator;


/**
 * 文章类
 * @author zhuyuping
 *@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
 */
@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public  class Article implements Serializable{

 /**
	 * 
	 */
	protected  static final long serialVersionUID = -1835810854282892427L;
	@Column(length=40)
 private  String title;//文章的图标
 private  String content;//文章的内容
 private String faceIcon;
 
 @ManyToOne(cascade=CascadeType.ALL)
 @JoinColumn(name="userId")
 private  User author;//文章的作者
 private  Date postTime;//文章的发表时间
 private  Date updateTime;//文章的更新时间
 @Column(length=20)
 private  String ipAddr;//文章发布的IP地址
 @Column(length=2)
 private int state;//状态 审核为1 未审核为0
 @Column(length=2)
 private int is_top;//状态1为置顶 状态0 为置顶
 
 private ArticlelType articleType;//文章类型 类型 0为导航类型 1为图片类型 2为视频类型 3为内容类型
 
 @ElementCollection
 private Map<User,Comment> comments=new HashMap<User, Comment>();//用户留言



@Id
@GenericGenerator(name="idGenerator",strategy="uuid")
@GeneratedValue(generator="idGenerator")
private String id;






public String getId() {
	return id;
}


public void setId(String id) {
	this.id = id;
}


public String getTitle()
{
	return title;
}


public void setTitle(String title)
{
	this.title = title;
}


public String getContent()
{
	return content;
}


public void setContent(String content)
{
	this.content = content;
}


public User getAuthor()
{
	return author;
}


public void setAuthor(User author)
{
	this.author = author;
}


public String getFaceIcon()
{
	return faceIcon;
}


public void setFaceIcon(String faceIcon)
{
	this.faceIcon = faceIcon;
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


public String getIpAddr()
{
	return ipAddr;
}


public void setIpAddr(String ipAddr)
{
	this.ipAddr = ipAddr;
}


public int getState()
{
	return state;
}


public void setState(int state)
{
	this.state = state;
}





public int getIs_top() {
	return is_top;
}


public void setIs_top(int is_top) {
	this.is_top = is_top;
}


public ArticlelType getArticleType() {
	return articleType;
}


public void setArticleType(ArticlelType articleType) {
	this.articleType = articleType;
}


public Map<User, Comment> getComments() {
	return comments;
}


public void setComments(Map<User, Comment> comments) {
	this.comments = comments;
}


public Article()
{
	
}
 
	
	
	
	
	
	
}
