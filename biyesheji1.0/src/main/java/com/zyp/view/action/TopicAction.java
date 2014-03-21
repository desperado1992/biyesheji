package com.zyp.view.action;

import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.zyp.base.ModelDrivenBaseAction;
import com.zyp.model.Forum;
import com.zyp.model.Reply;
import com.zyp.model.Topic;
import com.zyp.model.User;
import com.zyp.service.UserService;
import com.zyp.util.HqlHelper;

/**
 * 
 * @author zhuyuping
 *
 */
@SuppressWarnings("unused")
@Namespace("/main")
@Action(value="topicAction",results={@Result(name="toShow",type="redirectAction",location="topicAction!show.action",params={"id","${id}"}),@Result(name="addUI",location="/WEB-INF/jsp/admin/topic/addUI.jsp"),@Result(name="show",location="/WEB-INF/jsp/admin/topic/show.jsp")})
@Scope("prototype")
public class TopicAction extends ModelDrivenBaseAction<Topic> {

	
	private static final long serialVersionUID = 1L;
    private Long forumtoId;
    
    
	//现实单个主题列表
	public String show(){
	
	Topic topic=topicService.findById(model.getId());
	ActionContext.getContext().put("topic", topic);
	
	
//	List<Reply> replyList=replyService.findByTopic(topic);
//	ActionContext.getContext().put("replyList", replyList); 
//	PageBean pageBean=replyService.getPageBean(pageNum,topic);	
//	ActionContext.getContext().getValueStack().push(pageBean);
	new HqlHelper(Reply.class, "r")//
	.addCondition("r.topic=?", topic)//
	.addOrder("r.postTime", true)//
	.buildPageBeanForStruts2(pageNum, replyService);
	return "show";
	}
	//添加主题页面
	public String addUI(){
		
	
		Forum forum= forumService.findById(forumtoId);
		ActionContext.getContext().put("forum", forum);
		
		return "addUI";
	}
	//添加主题
	public String add(){
	
		
	User user=getCurrentUser();

		model.setAuthor(userService.findById(user.getId()));
		model.setForum(forumService.findById(forumtoId));
		model.setIpAddr(ServletActionContext.getRequest().getRemoteAddr());
		model.setPostTime(new Date());
		
		topicService.save(model);
		
		
		
		return "toShow";
	}
	public Long getForumtoId()
	{
		return forumtoId;
	}
	public void setForumtoId(Long forumtoId)
	{
		this.forumtoId = forumtoId;
	}
	
	
	
	

	
	
	
}
