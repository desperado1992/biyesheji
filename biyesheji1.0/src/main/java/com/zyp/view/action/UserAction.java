package com.zyp.view.action;




import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;

import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;


import com.opensymphony.xwork2.ActionContext;
import com.zyp.base.ModelDrivenBaseAction;




import com.zyp.model.User;






@Namespace("/main")
@Action(value="userAction",results={@Result(name="toIndex",type="redirectAction",location="adminAction!index.action"),@Result(name="loginUI",location="/WEB-INF/jsp/admin/loginUI.jsp")})
@Scope("prototype")
public class UserAction extends ModelDrivenBaseAction<User>
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2956291758816918403L;
   
  
   public String register(){
		System.out.println("UserAction.register()");
	   userService.save(model);
		
		return "loginUI";
	}
   
   public String login(){
	  
	  User user=userService.getByLoginNameAndPassword(model.getLogName(),model.getPassword());
	 
	  
	
	  if(user == null){
  		//用户或密码不正确
		
  		addFieldError("loginError", "用户名或者密码不正确");
  		return "loginUI";
  			
  	}else{
  		//正确就登陆用户
  		ActionContext.getContext().getSession().put("user", user);
      	return "toIndex";
  	}
   	
   	
	}
   
   
   public String logOut(){
	   if(ActionContext.getContext().getSession().get("user")!=null){
		   
		   ActionContext.getContext().getSession().remove("user");
		   
	   }
	   
	   return "loginUI";
	   
   }
   
   
   
}
