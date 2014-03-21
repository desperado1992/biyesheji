package com.zyp.view.action;



import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;


import com.opensymphony.xwork2.ActionContext;
import com.zyp.base.ModelDrivenBaseAction;

import com.zyp.model.FrendLink;

@Namespace("/main")
@Action(value="frendLinkAction",results={@Result(name="toList",type="redirectAction",location="frendLinkAction!list.action"),@Result(name="list",location="/WEB-INF/jsp/admin/frendLink/list.jsp"),@Result(name="saveUI",location="/WEB-INF/jsp/admin/frendLink/saveUI.jsp")})
@Scope("prototype")
public class FrendLinkAction  extends ModelDrivenBaseAction<FrendLink>
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2273433142780434604L;

	
	public String list(){
		
		List<FrendLink> frendLinks=frendLinkService.findAll();
		ActionContext.getContext().put("frendlinks", frendLinks);
		
     return "list";		
	}
	
	public String addUI(){
		
		
		
		return "saveUI";
	}
	
	public String add(){
		String url=model.getUrl();
	if(!"".equals(url)){
		if(!url.contains("http://")){
		 url="http://"+url;	
		}
		model.setUrl(url);
		frendLinkService.save(model);
	}
		
		
		
		return "toList";
	}
	
	public String editUI(){
	 FrendLink frendLink=frendLinkService.findById(model.getId());
	ActionContext.getContext().getValueStack().push(frendLink);	
	 return "saveUI";
	}
	
	public String edit(){
		
		frendLinkService.update(model);
		
		return "toList";
	}

   public String delete(){
	  
	   frendLinkService.delete(model.getId());
	   
	   return "toList";
   }
}
