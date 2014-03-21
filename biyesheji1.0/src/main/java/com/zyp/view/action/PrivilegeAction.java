package com.zyp.view.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;

import com.zyp.base.ModelDrivenBaseAction;
import com.zyp.model.Privilege;

@Namespace("/main")
@Action(value="privilegeAction",results={@Result(name="toList",type="redirectAction",location="privilegeAction!list.action"),@Result(name="list",location="/WEB-INF/jsp/privilege/role/list.jsp"),@Result(name="saveUI",location="/WEB-INF/jsp/admin/privilege/saveUI.jsp")})
@Scope("prototype")
public class PrivilegeAction extends ModelDrivenBaseAction<Privilege>
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9220553222948984826L;
	public String list(){
		//shopcategoryService.findAll();
		
     return "list";		
	}
	
	public String addUI(){
		
		
		
		return "saveUI";
	}
}
