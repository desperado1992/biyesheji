package com.zyp.service;

import java.util.List;

import com.zyp.base.BaseDao;
import com.zyp.model.Privilege;


public interface PrivilegeService  extends BaseDao<Privilege,Long>
{

	List<Privilege> findTopList();

	List<String> getAllPrivilegeUrls();

	

}
