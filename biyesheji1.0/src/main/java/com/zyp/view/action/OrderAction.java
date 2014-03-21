package com.zyp.view.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;

import com.zyp.base.ModelDrivenBaseAction;

import com.zyp.model.Orders;

@Namespace("/main")
@Action(value="orderAction",results={@Result(name="toList",type="redirectAction",location="orderAction!list.action"),@Result(name="list",location="/WEB-INF/jsp/privilege/order/list.jsp"),@Result(name="saveUI",location="/WEB-INF/jsp/admin/order/saveUI.jsp")})
@Scope("prototype")
public class OrderAction extends ModelDrivenBaseAction<Orders>
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5082413466258766820L;

	public String list(){
		//shopcategoryService.findAll();
		
     return "list";		
	}
	
	public String addUI(){
		
		
		
		return "saveUI";
	}
	
}
