package com.zyp.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zyp.base.BaseDaoImpl;
import com.zyp.cfg.Configuration;
import com.zyp.model.Forum;
import com.zyp.model.Topic;
import com.zyp.pageModel.PageBean;
import com.zyp.service.TopicService;


@Service
@SuppressWarnings("unchecked")
public class TopicServiceImpl extends BaseDaoImpl<Topic,String> implements TopicService{

	@Override
	public void save(Topic topic) {
		
		topic.setLastUpdateTime(topic.getPostTime());
		getSession().save(topic);
		
		//设置维护其他相关信息 这是为了逆范式 的需要而进行维护的数据
		Forum forum =topic.getForum();
		forum.setTopicCount(forum.getTopicCount() + 1);
		forum.setArticleCount(forum.getArticleCount() + 1);
		forum.setLastTopic(topic);
		
		getSession().update(forum);
		
	}

	/**
	 * 通过板块查找主题 并且根据时间 与 帖子类型2个字段排序
	 */
	public List<Topic> findByForum(Forum forum) {
	
		return getSession().createQuery("FROM Topic t WHERE t.forum=? ORDER BY (CASE t.type WHEN 2 THEN 2 ELSE 0 END) DESC , t.lastUpdateTime DESC").setParameter(0, forum).list();
	}

	public PageBean getPageBean(int pageNum, Forum forum) {
		
     int pageSize=Configuration.getPageSize();
		
		List<Topic> topicList=getSession().createQuery("FROM Topic t WHERE t.forum=? ORDER BY (CASE t.type WHEN 2 THEN 2 ELSE 0 END) DESC , t.lastUpdateTime DESC").setParameter(0, forum).setFirstResult((pageNum-1)*pageSize).setMaxResults(pageSize).list();
	
		Long count=(Long) getSession().createQuery("SELECT COUNT(*) FROM Topic t WHERE t.forum=? ").setParameter(0, forum).uniqueResult();
	    return new PageBean(topicList, pageNum, pageSize, count.intValue());
	}

	

}
