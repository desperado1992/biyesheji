package com.zyp.service;

import com.zyp.base.BaseDao;
import com.zyp.model.Forum;



public interface ForumService extends BaseDao<Forum,Long>{

	//下移
	void moveDown(Long id);
    //上移
	void moveUp(Long id);

}
