package com.zyp.view.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;

import com.opensymphony.xwork2.ActionContext;
import com.zyp.base.ModelDrivenBaseAction;

import com.zyp.model.ShopCategory;


@Namespace("/main")
@Action(value="shopcategoryAction",results={@Result(name="toList",type="redirectAction",location="shopcategoryAction!list.action"),@Result(name="list",location="/WEB-INF/jsp/admin/shopcategory/list.jsp"),@Result(name="saveUI",location="/WEB-INF/jsp/admin/shopcategory/saveUI.jsp")})
@Scope("prototype")
public class ShopcategoryAction extends ModelDrivenBaseAction<ShopCategory>
{

	/**
	 * 
	 */
	private String categoryId;
	
	private static final long serialVersionUID = 4962535713847556205L;

	public String list(){
		//shopcategoryService.findAll();
	List<ShopCategory> categorys=shopcategoryService.findAll();
		
	ActionContext.getContext().put("categorys", categorys);
	ActionContext.getContext().put("count", String.valueOf(categorys.size()));
     return "list";		
	}
	
	public String addUI(){
		
		List<ShopCategory> categorys=shopcategoryService.findAll();
		
		ActionContext.getContext().put("categorys", categorys);
		
		return "saveUI";
	}
	
	public String editUI(){
	 ShopCategory shopCategory=shopcategoryService.findById(model.getId());
			 List<ShopCategory> categorys=shopcategoryService.findAll();
		
		ActionContext.getContext().put("categorys", categorys);
		ActionContext.getContext().getValueStack().push(shopCategory);
		
		return "saveUI";
	}
	
	public String add(){
		if(categoryId!=null){
	ShopCategory category=shopcategoryService.findById(categoryId);
	model.setParent(category);	
		}
		shopcategoryService.save(model);
		
		return "toList";
	}
	
	public String edit(){
	ShopCategory category=shopcategoryService.findById(model.getId());
	ShopCategory parent=shopcategoryService.findById(categoryId);
	category.setParent(parent);
	shopcategoryService.update(model);
		
		return "toList";
	}
	
	public String delete(){
		shopcategoryService.delete(model.getId());
		
		return  "toList";
	}

	public String getCategoryId()
	{
		return categoryId;
	}

	public void setCategoryId(String categoryId)
	{
		this.categoryId = categoryId;
	}
	
}
