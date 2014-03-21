package com.zyp.service;



import java.util.List;

import com.zyp.base.BaseDao;
import com.zyp.model.Goods;
import com.zyp.pageModel.PageBean;



public interface GoodsService extends BaseDao<Goods,String>
{

	List<Goods> findBystatus(int status);

	PageBean findNewSHOP(int pageNum);

	PageBean findHotSHOP(int pageNum);

	

	


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
