package com.zyp.service.impl;








import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;



import com.zyp.base.BaseDaoImpl;

import com.zyp.model.User;

import com.zyp.service.UserService;



@Service
public class UserServiceImpl extends BaseDaoImpl<User,Long> implements UserService
{

	@Override
	public User getByLoginNameAndPassword(String logName, String password)
	{
		
		return (User) getSession().createQuery("FROM User u WHERE u.logName=? and u.password=?").setParameter(0, logName).setParameter(1,DigestUtils.md5Hex(password)).uniqueResult();
	}

	

	
	
	
	
	
	

	




	
	
	
}
