package com.zyp.base;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;



import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.transaction.annotation.Transactional;






import com.zyp.cfg.Configuration;


import com.zyp.pageModel.PageBean;
import com.zyp.util.HqlHelper;




@SuppressWarnings("unchecked")
@Transactional
public  class BaseDaoImpl<T extends Serializable,PK extends Serializable> implements BaseDao<T,PK> {



	@Resource
	private SessionFactory sessionFactory;
	
	protected Class<T> clazz;
	/**
	 * 获取当前session
	 * @return
	 */

	@SuppressWarnings("rawtypes")
	public BaseDaoImpl() {
		//通过反射得到T的真实类型
		ParameterizedType pt=(ParameterizedType) this.getClass().getGenericSuperclass();
	    this.clazz=(Class) pt.getActualTypeArguments()[0];	
	
	   
	    
	}
	protected  Session getSession(){
		
		return sessionFactory.getCurrentSession();
		
	}
	  
	
	public void save(T entity) {
		
	 //getSession().persist(entity);
		//getSession().saveOrUpdate(entity);
		getSession().save(entity);
	}

	
	public void delete(PK id) {
		
	getSession().delete(getSession().get(clazz, id));
	
	}

	
	public void update(T entity) {
		
		getSession().update(entity);
		//getSession().saveOrUpdate(entity);
		//getSession().merge(entity);
	}
	
	
	public T findById(PK id) {
		
		if(id==null){
			return null;
			}
		return (T) getSession().get(clazz, id);
	}
	
	public List<T> findByids(PK[] ids) {
		
		if(ids==null||ids.length==0){
			
			return Collections.EMPTY_LIST;
		}
		
		return getSession().createQuery("FROM "+ clazz.getSimpleName()+" WHERE id IN (:ids)").setParameterList("ids", ids).list();
	}


	public List<T> findAll() {
		
		return getSession().createQuery("FROM "+clazz.getSimpleName()).list();
	}

	public PageBean getPageBean(int pageNum, HqlHelper hqlHelper) {
		
		int pageSize = Configuration.getPageSize();
		List<Object> parameters = hqlHelper.getParameters();

		// 查询本页的数据列表
		Query listQuery = getSession().createQuery(hqlHelper.getQueryListHql());
		if (parameters != null && parameters.size() > 0) { // 设置参数
			for (int i = 0; i < parameters.size(); i++) {
				listQuery.setParameter(i, parameters.get(i));
			}
		}
		listQuery.setFirstResult((pageNum - 1) * pageSize);
		listQuery.setMaxResults(pageSize);
		
		@SuppressWarnings("rawtypes")
		List list = listQuery.list(); // 执行查询

		// 查询总记录数
		Query countQuery = getSession().createQuery(hqlHelper.getQueryCountHql());
		if (parameters != null && parameters.size() > 0) { // 设置参数
			for (int i = 0; i < parameters.size(); i++) {
				countQuery.setParameter(i, parameters.get(i));
			}
		}
		Long count = (Long) countQuery.uniqueResult(); // 执行查询

		return new PageBean(list,pageNum,pageSize,count.intValue());
	}
	/*
	 * 抽出的方法可以拼接生成sql查询并返回结果
	 */
	public Long finalcountsql(HqlHelper hqlHelper)
	{
		List<Object> parameters = hqlHelper.getParameters();
		Query query=getSession().createQuery(hqlHelper.getQueryCountHql());
		if(parameters!=null&&parameters.size()>0){
			for(int i=0;i<parameters.size();i++){
				
				query.setParameter(i, parameters.get(i));
			}
			
		}
		 Long count= (Long) query.uniqueResult();
		return count;
	}
/**
 * 抽出的方法可以拼接查询的sql并返回结果总数
 * @param hqlHelper
 * @return
 */
	@SuppressWarnings("rawtypes")
	public List finalsql(HqlHelper hqlHelper)
	{
		List<Object> parameters = hqlHelper.getParameters();
		Query query=getSession().createQuery(hqlHelper.getQueryListHql());
		if(parameters!=null&&parameters.size()>0){
			for(int i=0;i<parameters.size();i++){
				
				query.setParameter(i, parameters.get(i)).setFirstResult(0).setMaxResults(10);
			}
			
		}
	    List list=query.list();
		return list;
	}


	
	
   
}
