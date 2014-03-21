package com.zyp.service;

import java.util.List;

import com.zyp.base.BaseDao;
import com.zyp.model.Forum;
import com.zyp.model.Topic;
import com.zyp.pageModel.PageBean;



public interface TopicService extends BaseDao<Topic,String>{
     
	@Deprecated
	List<Topic> findByForum(Forum forum);

	/**
	 * 分页查询数据
	 * @param pageNum
	 * @param forum
	 * @return
	 */
	@Deprecated
	PageBean getPageBean(int pageNum, Forum forum);

}
