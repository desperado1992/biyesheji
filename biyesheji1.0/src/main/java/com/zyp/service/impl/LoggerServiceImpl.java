package com.zyp.service.impl;


import org.springframework.stereotype.Service;

import com.zyp.base.BaseDaoImpl;
import com.zyp.model.LoggerRecord;
import com.zyp.service.LoggerService;
@Service
public class LoggerServiceImpl extends BaseDaoImpl<LoggerRecord, Long> implements LoggerService{

	@Override
	public void addRecord(LoggerRecord loggerRecord) {
		
		getSession().saveOrUpdate(loggerRecord);
	}

	
	

	
	
	

}
