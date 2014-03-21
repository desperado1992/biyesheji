package com.zyp.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;


import com.zyp.base.BaseDaoImpl;
import com.zyp.cfg.Configuration;
import com.zyp.model.Goods;

import com.zyp.pageModel.PageBean;

import com.zyp.service.GoodsService;

@Service
public class GoodsServiceImpl extends BaseDaoImpl<Goods, String> implements GoodsService
{

	@SuppressWarnings("unchecked")
	@Override
	
	public List<Goods> findBystatus(int status)
	{
		
		return getSession().createQuery("FROM  Goods g  WHERE g.status=?").setParameter(0, status).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public PageBean findNewSHOP(int pageNum)
	{
        int pageSize=Configuration.getPageSize();
		
		List<Goods> goodList=getSession().createQuery("FROM Goods g ORDER BY  g.postTime DESC").setFirstResult((pageNum-1)*pageSize).setMaxResults(pageSize).list();
	
		Long count=(Long) getSession().createQuery("SELECT COUNT(*) FROM Goods").uniqueResult();
	    return new PageBean(goodList, pageNum, pageSize, count.intValue());
		
	
	}

	@SuppressWarnings("unchecked")
	@Override
	public PageBean findHotSHOP(int pageNum)
	{
		
        int pageSize=Configuration.getPageSize();
		
		List<Goods> goodList=getSession().createQuery("SELECT g FROM Goods g,Sales s WHERE g.id=s.goodId ORDER BY  s.quantity DESC").setFirstResult((pageNum-1)*pageSize).setMaxResults(pageSize).list();
	
		
		Long count=(Long) getSession().createQuery("SELECT COUNT(*) FROM Goods g,Sales s WHERE g.id=s.goodId").uniqueResult();
	    return new PageBean(goodList, pageNum, pageSize, count.intValue());
	}

	
	
	
	
	
}
