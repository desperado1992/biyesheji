package com.zyp.view.action;

import java.util.Date;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;

import com.opensymphony.xwork2.ActionContext;
import com.zyp.base.ModelDrivenBaseAction;

import com.zyp.model.Goods;
@Namespace("/main")
@Action(value="shoptypeAction",results={@Result(name="toList",type="redirectAction",location="shoptypeAction!list.action"),@Result(name="list",location="/WEB-INF/jsp/admin/shoptype/list.jsp"),@Result(name="saveUI",location="/WEB-INF/jsp/admin/shoptype/saveUI.jsp")})
@Scope("prototype")
public class ShoptypeAction extends ModelDrivenBaseAction<Goods>
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4175922628663624804L;

	public String list(){
		//shopcategoryService.findAll();
		List<Goods> goods=goodsService.findAll();
		ActionContext.getContext().put("goods", goods);
//		for (Goods goods2 : goods)
//		{
//			System.out.println(goods2.getName()+goods2.getDescription());
//		}
		ActionContext.getContext().put("count", String.valueOf(goods.size()));
		
		
		return "list";		
	}
	//上架
	public String Racking(){
		int status=1;
	List<Goods> goods=goodsService.findBystatus(status);
	for (Goods gd : goods)
	{
		gd.setStatus(1);
		gd.setUpdateTime(new Date());
		goodsService.update(gd);
	}
	
		
		return "toList";
	}
	
	public String editUI(){
		
		Goods goods=goodsService.findById(model.getId());
		ActionContext.getContext().getValueStack().push(goods);
		
		return "saveUI";
	}
	
	public String edit(){
		
		model.setUpdateTime(new Date());
		goodsService.update(model);
		return "toList";
	}
	//下架
	public String outstock(){
		
	Goods goods=goodsService.findById(model.getId());
	int status=goods.getStatus();
	if(status!=-1){
	goods.setStatus(status-1);
	goods.setUpdateTime(new Date());
	goodsService.update(goods);
	}
		return "toList";
	}
	
	
}
