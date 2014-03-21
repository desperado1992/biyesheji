package com.zyp.service;

import java.util.List;

import com.zyp.base.BaseDao;
import com.zyp.model.Reply;
import com.zyp.model.Topic;
import com.zyp.pageModel.PageBean;



public interface ReplyService extends BaseDao<Reply,String>{

	/**
	 * 通过主题查找下面的回复
	 * @author zhuyuping
	 * @param topic
	 * @return
	 */
	@Deprecated
	List<Reply> findByTopic(Topic topic);

	/**
	 * 分页查找获取分页信息
	 * @param pageNum
	 * @param topic
	 * @return
	 */
	@Deprecated
	PageBean getPageBean(int pageNum, Topic topic);

}
