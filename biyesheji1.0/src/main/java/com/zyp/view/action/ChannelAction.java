package com.zyp.view.action;


import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;

import com.opensymphony.xwork2.ActionContext;
import com.zyp.base.ModelDrivenBaseAction;
import com.zyp.model.Channel;
import com.zyp.model.ChannelArticle;
import com.zyp.util.ChannelUtils;

@Namespace("/main")
@Action(value="channelAction",results={@Result(name="toList",type="redirectAction",location="channelAction!list.action"),@Result(name="list",location="/WEB-INF/jsp/admin/channel/list.jsp"),@Result(name="saveUI",location="/WEB-INF/jsp/admin/channel/saveUI.jsp"),@Result(name="navigation",location="/WEB-INF/jsp/admin/channel/navigation.jsp"),@Result(name="navigationSaveUI",location="/WEB-INF/jsp/admin/channel/navigationSaveUI.jsp"),@Result(name="toNavigation",type="redirectAction",location="channelAction!navigation.action"),@Result(name="navigationSaveUI",location="/WEB-INF/jsp/admin/channel/navigationSaveUI.jsp")

})
@Scope("prototype")
public class ChannelAction extends ModelDrivenBaseAction<Channel>
{

	
	
	private String title;
	
	private String contents;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private Long parentId;
	
	
	public String list(){
		
		return "list";
	}
	
	
	
	public String navigation(){
		
		   List<Channel> channels=channelService.findAll();
		   ActionContext.getContext().put("channels", channels);
		return "navigation";
	}
	
	 public String addUI(){
		 
      List<Channel> channels=channelService.findTopParent();
      
		 List<Channel> channelList=ChannelUtils.getAllChannels(channels);
		 ActionContext.getContext().put("channelList", channelList);
		 return "navigationSaveUI";
	 }
    public String add(){
    	
    	System.out.println(contents);
     Channel parent=channelService.findById(parentId);
     model.setParent(parent);
     ChannelArticle article=new ChannelArticle();
     article.setTitle(title);
     article.setContent(contents);
     channelArticleService.save(article);
     model.setArticle(article);
 
	channelService.save(model); 
    	
		 return "toNavigation";
	 }
    public String editUI(){
    	List<Channel> channels=channelService.findTopParent();
		 List<Channel> channelList=ChannelUtils.getAllChannels(channels);
		 ActionContext.getContext().put("channelList", channelList);
		  Channel channel=channelService.findById(model.getId());
		  ActionContext.getContext().getValueStack().push(channel);
		 if(channel.getParent()!=null){
			 
			 parentId=channel.getParent().getId();
		 }
    	return "navigationSaveUI";
    }
  public String edit(){
   Channel channel=channelService.findById(model.getId());	
   Channel parent=channelService.findById(parentId);
   channel.setParent(parent);
ChannelArticle article=channel.getArticle();
article.setTitle(title);
article.setContent(contents);
channelArticleService.update(article);

   try {
	BeanUtils.copyProperties(channel, model);
} catch (Exception e) {
	
	e.printStackTrace();
} 
   channel.setArticle(article);
   channelService.update(channel);
   
    return 	"toNavigation";
    }
 
  public String delete(){
	   channelService.delete(model.getId());
	   
	    return 	"toNavigation";
	    }
  
	


	public Long getParentId() {
		return parentId;
	}


	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}


	


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getContents() {
		return contents;
	}


	public void setContents(String contents) {
		this.contents = contents;
	}
	
	
}
