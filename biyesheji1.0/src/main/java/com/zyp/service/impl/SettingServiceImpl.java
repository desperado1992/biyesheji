package com.zyp.service.impl;

import org.springframework.stereotype.Service;

import com.zyp.base.BaseDaoImpl;
import com.zyp.model.Setting;
import com.zyp.service.SettingService;
@Service
public class SettingServiceImpl extends BaseDaoImpl<Setting, Long> implements SettingService{

	@Override
	public Setting findByPro(String prop) {
		
		return (Setting) getSession().createQuery("FROM Setting s WHERE s.name=?").setParameter(0, prop).uniqueResult();
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
