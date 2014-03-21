package com.zyp.view.action;



import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;

import com.zyp.base.BaseAction;

@Namespace("/main")
@Action(value="adminAction",results={@Result(name="index",location="/WEB-INF/jsp/admin/index.jsp"),@Result(name="loginUI",location="/WEB-INF/jsp/admin/loginUI.jsp")})
@Scope("prototype")
public class AdminAction extends BaseAction
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6735740290811788037L;
	

    public  String index(){
    	
    	return "index";
    }
	
	
	
	
	
	
	
	public String loginUI(){
		
		return "loginUI";
	}
  
	
	
	
	
}
