package com.zyp.view.action;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;

import com.opensymphony.xwork2.ActionContext;
import com.zyp.base.ModelDrivenBaseAction;


import com.zyp.model.Goods;
import com.zyp.model.ShopCategory;
import com.zyp.model.Specification;

@Namespace("/main")
@Action(value="shopAction",results={@Result(name="toList",type="redirectAction",location="shopAction!list.action"),@Result(name="list",location="/WEB-INF/jsp/admin/shop/list.jsp"),@Result(name="saveUI",location="/WEB-INF/jsp/admin/shop/saveUI.jsp")})
@Scope("prototype")
public class ShopAction extends ModelDrivenBaseAction<Goods>
{

	private String categoryId;
	private File  shopImg;
	 private String shopImgFileName; //文件名称
	    private String shopImgContentType; //文件类型
    private Long specifId;//规格
	/**
	 * 
	 */
	private static final long serialVersionUID = 2709684793120311276L;

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
	
	public String addUI(){
		
	  List<ShopCategory> categorys=shopcategoryService.findAll();
	 List<Specification> specifications=specificationService.findAll();
	 
	  ActionContext.getContext().put("categorys", categorys);
	  ActionContext.getContext().put("specifications", specifications);
		return "saveUI";
	}
	
	public String add(){
		
		if(shopImg!=null){
			String path = uploadFile(shopImg,shopImgFileName);
		
			model.getImg().add(path);
		}
		 
		model.setPostTime(new Date());
		discoutService.save(model.getDiscount());	

			
		
		
		model.getSpecifications().add(specificationService.findById(specifId));
		ShopCategory category=shopcategoryService.findById(categoryId);
		model.setCategory(category);
		goodsService.save(model);
		return "toList";
	}
	
	public String editUI(){
		List<ShopCategory> categorys=shopcategoryService.findAll();
	     Goods good=goodsService.findById(model.getId());
	     List<Specification> specifications=specificationService.findAll();
		  ActionContext.getContext().put("categorys", categorys);
		  ActionContext.getContext().put("specifications", specifications);
		  ActionContext.getContext().getValueStack().push(good);
		return "saveUI";
	}
	
	public String edit(){
		
		ShopCategory category=shopcategoryService.findById(categoryId);
		  Goods good=goodsService.findById(model.getId());
			if(shopImg!=null){
				String path = uploadFile(shopImg,shopImgFileName);
				  good.getImg().add(path);
			}
		good.setUpdateTime(new Date());
		good.setCategory(category);
		goodsService.update(good);
		return "toList";
	}
	
	public String delete(){
		
		Goods goods=goodsService.findById(model.getId());
		goods.getImg().clear();
		
		goodsService.delete(model.getId());
		return "toList";
	}
	

	public String getCategoryId()
	{
		return categoryId;
	}

	public void setCategoryId(String categoryId)
	{
		this.categoryId = categoryId;
	}

	

	public File getShopImg()
	{
		return shopImg;
	}

	public void setShopImg(File shopImg)
	{
		this.shopImg = shopImg;
	}

	public Long getSpecifId()
	{
		return specifId;
	}

	public void setSpecifId(Long specifId)
	{
		this.specifId = specifId;
	}

	public String getShopImgFileName()
	{
		return shopImgFileName;
	}

	public void setShopImgFileName(String shopImgFileName)
	{
		this.shopImgFileName = shopImgFileName;
	}

	public String getShopImgContentType()
	{
		return shopImgContentType;
	}

	public void setShopImgContentType(String shopImgContentType)
	{
		this.shopImgContentType = shopImgContentType;
	}
	
	


}
