package com.zyp.view.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;

import com.opensymphony.xwork2.ActionContext;
import com.zyp.base.BaseAction;
import com.zyp.model.Role;
@Namespace("/main")
@Action(value="chatAction",results={@Result(name="chat1",location="/WEB-INF/jsp/admin/chat1.jsp"),@Result(name="chat2",location="/WEB-INF/jsp/admin/chat2.jsp")})
@Scope("prototype")
public class ChatAction extends BaseAction
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4434756562537824323L;

	
	public String chat(){
		 List<Role> roles=roleService.findAll(); 
		 ActionContext.getContext().put("roles", roles);
		
		   
		   return "chat1";
	   }
	
	   public String chatrtc(){
		   
		   
		   return "chat2";
	   }
}
