package com.zyp.view.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;

import com.opensymphony.xwork2.ActionContext;
import com.zyp.base.ModelDrivenBaseAction;
import com.zyp.model.Brand;


@Namespace("/main")
@Action(value="shopbrandAction",results={@Result(name="toList",type="redirectAction",location="shopbrandAction!list.action"),@Result(name="list",location="/WEB-INF/jsp/admin/shopbrand/list.jsp"),@Result(name="saveUI",location="/WEB-INF/jsp/admin/shopbrand/saveUI.jsp")})
@Scope("prototype")
public class ShopbrandAction extends ModelDrivenBaseAction<Brand>
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5712326253327546193L;

	public String list(){
		//shopcategoryService.findAll();
		List<Brand> brands=brandService.findAll();
		
		ActionContext.getContext().put("brands", brands);
		
     return "list";		
	}
	
	public String addUI(){
		
		
		
		return "saveUI";
	}
	
	public String add(){
		
		
		brandService.save(model);
		return "toList";
	}
	
	public String editUI(){
		Brand brand =brandService.findById(model.getId());
		ActionContext.getContext().getValueStack().push(brand);
		return "saveUI";
	}
	
	public String edit(){
		brandService.update(model);
		
		return "toList";
	}

   public String delete(){
	   brandService.delete(model.getId());
	   
	   return "toList";
   }
}
