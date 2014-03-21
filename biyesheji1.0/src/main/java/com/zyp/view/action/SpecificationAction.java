package com.zyp.view.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;

import com.opensymphony.xwork2.ActionContext;
import com.zyp.base.ModelDrivenBaseAction;

import com.zyp.model.Specification;
@Namespace("/main")
@Action(value="specificationAction",results={@Result(name="toList",type="redirectAction",location="SpecificationAction!list.action"),@Result(name="list",location="/WEB-INF/jsp/admin/specification/list.jsp"),@Result(name="saveUI",location="/WEB-INF/jsp/admin/specification/saveUI.jsp")})
@Scope("prototype")
public class SpecificationAction extends ModelDrivenBaseAction<Specification>
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3882772774049438323L;

	
	public String list(){
		//shopcategoryService.findAll();
		
	 List<Specification> specifications=specificationService.findAll();
		ActionContext.getContext().put("specifications", specifications);
     return "list";		
	}
	
	public String addUI(){
		
		
		
		return "saveUI";
	}
	public String add(){
		
		specificationService.save(model);
		
		return "toList";
	}
	
	public String editUI(){
		
	Specification specification=specificationService.findById(model.getId());
	ActionContext.getContext().getValueStack().push(specification);
	
		return "saveUI";
	}
	
	public String edit(){
		
		specificationService.update(model);
		
		return "toList";
	}
	
	public String delete(){
		
		specificationService.delete(model.getId());
		return "toList";
	}
}
