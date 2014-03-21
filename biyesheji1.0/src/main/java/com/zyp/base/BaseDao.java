package com.zyp.base;


import java.util.List;



import com.zyp.pageModel.PageBean;
import com.zyp.util.HqlHelper;





public interface BaseDao<T extends java.io.Serializable, PK extends java.io.Serializable> {

	/**
	 * 保存实体
	 * @param entity
	 */
	void save(T entity);
	/**
	 * 删除实体
	 * @param id
	 */
	void  delete(PK id);
	/***
	 * 更新实体
	 * @param entity
	 */
	
	void update(T entity);
	/**
	 * 查询实体通过id 如果id为空返回null
	 * @param id
	 * @return
	 */
	T findById(PK id);
	/**
	 * 通过多个id查询实体 
	 * @param ids
	 * @return
	 */
	List<T> findByids(PK[] ids);
	/**
	 * 查询所有实体
	 * @return
	 */
	List<T> findAll();
	/**
	 * 公共的查询分页信息的方法
	 * 
	 * @param pageNum
	 * @param hqlHelper
	 *            查询条件（HQL语句与参数列表）
	 * @return
	 */
	PageBean getPageBean(int pageNum, HqlHelper hqlHelper);
	/**
	 * 
	 * @param hqlHelper
	 * @return
	 */
	Long finalcountsql(HqlHelper hqlHelper);
	/**
	 *  
	 * @param hqlHelper
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	List finalsql(HqlHelper hqlHelper);
	
	
	
	
}
