package com.zyp.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zyp.base.BaseDaoImpl;
import com.zyp.cfg.Configuration;
import com.zyp.model.Forum;
import com.zyp.model.Reply;
import com.zyp.model.Topic;
import com.zyp.pageModel.PageBean;
import com.zyp.service.ReplyService;


@Service
@SuppressWarnings("unchecked")
public class ReplyServiceImpl extends BaseDaoImpl<Reply,String> implements ReplyService{


	public List<Reply> findByTopic(Topic topic) {
	
		return  getSession().createQuery("FROM Reply r WHERE r.topic=? ORDER BY  r.postTime ASC").setParameter(0, topic).list();
	}

	@Override
	public void save(Reply reply) {
		getSession().save(reply);
		Topic topic=reply.getTopic();
		Forum forum=topic.getForum();
		forum.setArticleCount(forum.getArticleCount() + 1);
		topic.setReplyCount(topic.getReplyCount() + 1);
		topic.setLastReply(reply);
		topic.setLastUpdateTime(reply.getPostTime());
		getSession().update(topic);
		getSession().update(forum);
		
	}

	public PageBean getPageBean(int pageNum, Topic topic) {
		
		int pageSize=Configuration.getPageSize();
		
		List<Reply> replyList=getSession().createQuery("FROM Reply r WHERE r.topic=? ORDER BY  r.postTime ASC").setParameter(0, topic).setFirstResult((pageNum-1)*pageSize).setMaxResults(pageSize).list();
	
		Long count=(Long) getSession().createQuery("SELECT COUNT(*) FROM Reply r WHERE r.topic=?").setParameter(0, topic).uniqueResult();
	    return new PageBean(replyList, pageNum, pageSize, count.intValue());
	}

	
	
	
	
	
}
