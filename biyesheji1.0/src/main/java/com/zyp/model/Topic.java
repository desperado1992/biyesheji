package com.zyp.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
@Entity
@Table(name="topic",schema="")
@DynamicUpdate(true)
@DynamicInsert(true)
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class Topic extends Article implements Serializable{
   /**
	 * 
	 */
	private static final long serialVersionUID = -7829403141196664401L;
/**普通帖**/
	public static final int TYPE_NORMAL = 0;
	/**精华帖**/
	public static final int TYPE_BEST = 1;
	/**置顶帖**/
	public static final int TYPE_TOP=3;
	@ManyToOne(cascade=CascadeType.ALL)
   @JoinColumn(name="forumId")
   private Forum forum;
  @OneToMany(fetch=FetchType.EAGER,mappedBy="topic")
   private Set<Reply> replies=new HashSet<Reply>();
   private int type;
   private int replyCount;
   @OneToOne(cascade = CascadeType.ALL)
   private Reply lastReply;
   private Date lastUpdateTime;
public Forum getForum() {
	return forum;
}
public void setForum(Forum forum) {
	this.forum = forum;
}
public Set<Reply> getReplies() {
	return replies;
}
public void setReplies(Set<Reply> replies) {
	this.replies = replies;
}
public int getType() {
	return type;
}
public void setType(int type) {
	this.type = type;
}
public int getReplyCount() {
	return replyCount;
}
public void setReplyCount(int replyCount) {
	this.replyCount = replyCount;
}
public Reply getLastReply() {
	return lastReply;
}
public void setLastReply(Reply lastReply) {
	this.lastReply = lastReply;
}
public Date getLastUpdateTime() {
	return lastUpdateTime;
}
public void setLastUpdateTime(Date lastUpdateTime) {
	this.lastUpdateTime = lastUpdateTime;
}
   
	
	
	
}
