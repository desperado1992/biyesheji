package com.zyp.view.action;


import java.util.Date;
import java.util.List;


import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;

import com.opensymphony.xwork2.ActionContext;
import com.zyp.base.ModelDrivenBaseAction;

import com.zyp.model.ChannelArticle;
import com.zyp.model.ChannelArticleCategory;


@Namespace("/main")
@Action(value="channelArticleAction",results={@Result(name="toList",type="redirectAction",location="channelArticleAction!list.action"),@Result(name="list",location="/WEB-INF/jsp/admin/channelArticle/list.jsp"),@Result(name="saveUI",location="/WEB-INF/jsp/admin/channelArticle/saveUI.jsp")
})
@Scope("prototype")
public class ChannelArticleAction extends ModelDrivenBaseAction<ChannelArticle>
{

	

	private static final long serialVersionUID = -8744996677736492148L;
	private String articleCategoryId;
	
	
	
	/**
	 * 
	 */
	
	public String list(){
		
		List<ChannelArticle> channelArticles=channelArticleService.findAll();
		for (ChannelArticle channelArticle : channelArticles) {
			System.out.println(channelArticle.getcArticleCategory().getName());
			System.out.println("ChannelArticleAction.list()");
		}
		ActionContext.getContext().put("channelArticles", channelArticles);
	
		return "list";
	}
	public String addUI(){
	List<ChannelArticleCategory> cArticleCategoryList=caCategoryService.findAll();
	ActionContext.getContext().put("cArticleCategoryList", cArticleCategoryList);	
	return "saveUI";
	}
    public String editUI(){
			ChannelArticle channelArticle=channelArticleService.findById(model.getId());
			articleCategoryId=channelArticle.getcArticleCategory().getId();
			List<ChannelArticleCategory> cArticleCategoryList=caCategoryService.findAll();
			ActionContext.getContext().put("cArticleCategoryList", cArticleCategoryList);
			ActionContext.getContext().getValueStack().push(channelArticle);
    	
    	return "saveUI";
	}
   public String add(){
	ChannelArticleCategory  cArticleCategory=caCategoryService.findById(articleCategoryId);
	System.out.println(cArticleCategory.getName());
	model.setPostTime(new Date());
	model.setcArticleCategory(cArticleCategory);
		channelArticleService.save(model);
		return "toList";
	}
   public String edit(){
	   ChannelArticleCategory  cArticleCategory=caCategoryService.findById(articleCategoryId);
		model.setcArticleCategory(cArticleCategory);
		channelArticleService.update(model);
	   
		return "toList";
	}
	
   public String  delete(){
	   
	   channelArticleService.delete(model.getId());
	   return "toList";
   }
public String getArticleCategoryId() {
	return articleCategoryId;
}
public void setArticleCategoryId(String articleCategoryId) {
	this.articleCategoryId = articleCategoryId;
}

	
	
}
