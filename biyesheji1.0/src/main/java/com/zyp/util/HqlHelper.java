package com.zyp.util;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.zyp.base.BaseDao;
import com.zyp.pageModel.PageBean;

/**
 * 辅助生产hql语句的类 
 * @author 
 *
 */

public class HqlHelper {

	private String fromClause;//from语句 必须
	private String whereClause="";//where语句  可选
	private String orderByClause="";//orderby语句 可选
	
	private List<Object> parameters =new ArrayList<Object>();//参数列表接受参数 
	/***
	 * 初始化from clause必须字段
	 * @param clazz
	 */
	
	public HqlHelper(Class clazz){
		
		this.fromClause="FROM "+clazz.getSimpleName()+" o";
	}
	/**
	 * 
	 * @param clazz
	 * @param alias  自定义对象的别名 
	 */
	public HqlHelper(Class clazz,String alias){
		
		this.fromClause="FROM "+clazz.getSimpleName()+" "+alias;
	}
	/**
	 * 拼接where语句的方法
	 * @param condition
	 * @param params
	 * @return
	 */
	public HqlHelper addCondition(String condition,Object... params){
		if(whereClause.length() == 0){
			whereClause=" WHERE " + condition;
		} else {
		    whereClause+=" AND " + condition;
		}
		if(params != null && params.length >= 0){
			for(Object obj : params){
				parameters.add(obj);
			}
			
		}
		
		
		return this;
	}
	/**
	 * 如果第1个参数为true，则拼接Where子句
	 * 
	 * @param append
	 * @param condition
	 * @param params
	 */
	public HqlHelper addCondition(boolean append,String condition,Object... params){
	 if(append){
		 addCondition(condition, params);
	 }
		
		
		return this;
	}
	/**
	 * 拼接order by语句
	 * @param propertyName
	 * @param isAsc  true表示升序，false表示降序
	 * @return
	 */
	public HqlHelper addOrder(String propertyName,boolean isAsc){
		if(orderByClause.length() == 0){
			orderByClause=" ORDER BY " + propertyName+" "+(isAsc ? "ASC" : "DESC");
		} else {
			orderByClause+=", "+propertyName+" "+(isAsc ? "ASC" : "DESC");
		}
		
			
		
		
		
		return this;
		}
	
	/**
	 * 如果第1个参数为true，则拼接OrderBy子句
	 * 
	 * @param append
	 * @param propertyName
	 *            属性名
	 * @param isAsc
	 *            true表示升序，false表示降序
	 */
	public HqlHelper addOrder(boolean append, String propertyName, boolean isAsc) {
		if (append) {
			addOrder(propertyName, isAsc);
		}
		return this;
	}
	
	/**
	 *生成查询结果语句返回
	 * @return
	 */
	public String getQueryListHql(){
		
		return fromClause + whereClause + orderByClause;
	}
	
	/**
	 *生成查询总记录数结果返回
	 * @return
	 */
	public String getQueryCountHql(){
		
		return "SELECT COUNT(*) "+fromClause + whereClause;
	}
	
	
	/**
	 * 获取参数列表，与HQL过滤条件中的'?'一一对应
	 * 
	 * @return
	 */
	public List<Object> getParameters() {
		return parameters;
	}
	/**
	 * 查询并准备分页信息（放到栈顶）
	 * 
	 * @param pageNum
	 * @param service
	 * @return
	 */
	public HqlHelper buildPageBeanForStruts2(int pageNum, BaseDao<?,?> service) {
		
		
		PageBean pageBean = service.getPageBean(pageNum, this);
		ActionContext.getContext().getValueStack().push(pageBean);
		return this;
	}
	
}
