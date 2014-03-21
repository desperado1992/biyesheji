package com.zyp.view.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;

import com.zyp.base.ModelDrivenBaseAction;
import com.zyp.model.Area;

@Namespace("/main")
@Action(value="deliveryAction",results={@Result(name="toList",type="redirectAction",location="deliveryAction!list.action"),@Result(name="list",location="/WEB-INF/jsp/admin/delivery/list.jsp"),@Result(name="saveUI",location="/WEB-INF/jsp/admin/delivery/saveUI.jsp")})
@Scope("prototype")
public class DeliveryAction extends ModelDrivenBaseAction<Area>
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 522543189205765412L;

	
	
	
}
