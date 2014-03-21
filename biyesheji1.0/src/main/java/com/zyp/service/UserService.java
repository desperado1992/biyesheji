package com.zyp.service;



import com.zyp.base.BaseDao;

import com.zyp.model.User;

public interface UserService extends BaseDao<User,Long>
{

	User getByLoginNameAndPassword(String logName, String password);

	


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
