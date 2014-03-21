package com.zyp.view.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;

import com.zyp.base.ModelDrivenBaseAction;

import com.zyp.model.PayModel;
@Namespace("/main")
@Action(value="payAction",results={@Result(name="toList",type="redirectAction",location="payAction!list.action"),@Result(name="list",location="/WEB-INF/jsp/admin/pay/list.jsp"),@Result(name="saveUI",location="/WEB-INF/jsp/admin/pay/saveUI.jsp")})
@Scope("prototype")
public class PayAction extends ModelDrivenBaseAction<PayModel>
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6143567233242589901L;

}
