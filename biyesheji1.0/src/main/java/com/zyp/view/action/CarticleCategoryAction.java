package com.zyp.view.action;


import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;


import com.opensymphony.xwork2.ActionContext;
import com.zyp.base.ModelDrivenBaseAction;

import com.zyp.model.ChannelArticleCategory;


@Namespace("/main")
@Action(value="carticleCategoryAction",results={@Result(name="toList",type="redirectAction",location="carticleCategoryAction!list.action"),@Result(name="list",location="/WEB-INF/jsp/admin/carticleCategory/list.jsp"),@Result(name="saveUI",location="/WEB-INF/jsp/admin/carticleCategory/saveUI.jsp")
})
@Scope("prototype")
public class CarticleCategoryAction extends ModelDrivenBaseAction<ChannelArticleCategory>
{

	

	
	
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8744996677736492148L;
	public String list(){
		
	List<ChannelArticleCategory> articleCategories=caCategoryService.findAll();
	ActionContext.getContext().put("cArticleCategorys", articleCategories);
		return "list";
	}
	public String addUI(){
	
		
		
	return "saveUI";
	}
    public String editUI(){
	
    	ChannelArticleCategory articleCategory=caCategoryService.findById(model.getId());
    	
    	ActionContext.getContext().getValueStack().push(articleCategory);
    	
    	return "saveUI";
	}
   public String add(){
	   
		caCategoryService.save(model);
	   
		return "toList";
	}
   public String edit(){
		caCategoryService.update(model);
	   
		return "toList";
	}
	
   public String  delete(){
	   caCategoryService.delete(model.getId());
	 
	   return "toList";
   }

	
}
