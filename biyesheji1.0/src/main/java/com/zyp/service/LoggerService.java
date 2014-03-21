package com.zyp.service;

import com.zyp.base.BaseDao;
import com.zyp.model.LoggerRecord;

public interface LoggerService extends BaseDao<LoggerRecord, Long>{

	void addRecord(LoggerRecord loggerRecord);

	

	
	
}
