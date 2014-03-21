package com.zyp.service;

import java.util.List;

import com.zyp.base.BaseDao;
import com.zyp.model.Channel;


public interface ChannelService extends BaseDao<Channel, Long>
{

	List<Channel> findTopParent();

	List<Channel> findByProperty(String propName, Object propertyValue);

	List<Channel> findTopByProperty(String propName, Object propertyValue);



	

	
}
