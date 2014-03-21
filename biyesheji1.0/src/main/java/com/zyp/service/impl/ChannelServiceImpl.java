package com.zyp.service.impl;



import java.util.List;

import org.springframework.stereotype.Service;


import com.zyp.base.BaseDaoImpl;
import com.zyp.model.Channel;
import com.zyp.service.ChannelService;




@Service
public class ChannelServiceImpl extends BaseDaoImpl<Channel, Long> implements ChannelService
{

	@SuppressWarnings("unchecked")
	@Override
	public List<Channel> findTopParent() {
	
			
			return getSession().createQuery("FROM  Channel c  WHERE  c.parent IS NULL").list();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Channel> findByProperty(String propName, Object propertyValue)
	{
		
		return getSession().createQuery("FROM Channel c WHERE c."+propName+"=? AND c.is_stop=0 ORDER BY c.orders ASC").setParameter(0, propertyValue).list();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Channel> findTopByProperty(String propName, Object propertyValue)
	{
		
		return getSession().createQuery("FROM Channel c WHERE c."+propName+"=? AND c.parent IS NULL AND c.is_stop=0 ORDER BY c.orders ASC").setParameter(0, propertyValue).list();
	}

	
	

	

	

	
	
}
