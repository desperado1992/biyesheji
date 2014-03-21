package com.zyp.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zyp.base.BaseDaoImpl;
import com.zyp.model.Privilege;

import com.zyp.service.PrivilegeService;
@SuppressWarnings("unchecked")
@Service
public class PrivilegeServiceImpl extends BaseDaoImpl<Privilege,Long> implements PrivilegeService
{

	
	public List<Privilege> findTopList()
	{
		return getSession().createQuery("FROM Privilege p WHERE p.parent IS NULL").list();
	}



	public List<String> getAllPrivilegeUrls()
	{
		return getSession().createQuery("SELECT DISTINCT p.url FROM Privilege p WHERE p.url IS NOT NULL").list();
	}

}
