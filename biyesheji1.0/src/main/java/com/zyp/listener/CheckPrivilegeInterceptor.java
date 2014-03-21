package com.zyp.listener;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.zyp.model.User;



public class CheckPrivilegeInterceptor extends AbstractInterceptor{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	

	public String intercept(ActionInvocation invocation) throws Exception {
		
		
	  User  user=(User) ActionContext.getContext().getSession().get("user");
//		当前访问的url去掉用用名前缀
	  
	  String actionName=invocation.getProxy().getActionName();
      String namespace=invocation.getProxy().getNamespace();
      String method=invocation.getProxy().getMethod();
      String privilegeUrl=null;
     
    
		   privilegeUrl= namespace+"/"+actionName+"!"+method; 
	  
//      去掉开头的“/”
	  if(privilegeUrl.startsWith("/")){
		  privilegeUrl=privilegeUrl.substring(1); 
	  }

	  //	  如果未登录就转到相应登陆页或者放行
	  if(user == null){
			if(privilegeUrl.startsWith("main/userAction!login")){
			
//				如果正在使用登陆
				return invocation.invoke();
				
			}else{
//				如果不是去登陆
				return "loginUI";
			}
			
//			如果已经登陆就判断权限	
		}else{
		  if(user.hasPrivilegeByUrl(privilegeUrl)){
//			  如果有权限就放行		
			
			return invocation.invoke();
		  }else{
//			  如果没有权限就转到提示页面
			  return "noPrivilegeError";
			  
		  }
		}
	  
	  
		
	}

}
