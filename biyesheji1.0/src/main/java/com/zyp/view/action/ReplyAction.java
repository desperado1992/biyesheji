package com.zyp.view.action;

import java.util.Date;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;



import com.opensymphony.xwork2.ActionContext;
import com.zyp.base.ModelDrivenBaseAction;
import com.zyp.model.Reply;
import com.zyp.model.Topic;
import com.zyp.model.User;


@Namespace("/main")
@Action(value="replyAction",results={@Result(name="toTopicShow",type="redirectAction",location="topicAction!show",params={"id","${topicId}"}),@Result(name="addUI",location="/WEB-INF/jsp/admin/reply/addUI.jsp")})
@Scope("prototype")
public class ReplyAction extends ModelDrivenBaseAction<Reply> {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    //发表回复页面
	
   private String topicId;
   
	public String addUI(){
		Topic topic=topicService.findById(topicId);
		ActionContext.getContext().put("topic", topic);
		
		return "addUI";
		
	}
	
	public String add(){
	model.setTopic(topicService.findById(topicId));
		
	User user=getCurrentUser();

	model.setAuthor(userService.findById(user.getId()));
	
		model.setIpAddr(ServletActionContext.getRequest().getRemoteAddr());
		model.setPostTime(new Date());
		replyService.save(model);
		
		return "toTopicShow";
	}

	public String getTopicId() {
		return topicId;
	}

	public void setTopicId(String topicId) {
		this.topicId = topicId;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
