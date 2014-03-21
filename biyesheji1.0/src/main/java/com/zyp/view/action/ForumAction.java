package com.zyp.view.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.zyp.base.ModelDrivenBaseAction;
import com.zyp.model.Forum;
import com.zyp.model.Topic;
import com.zyp.util.HqlHelper;

@SuppressWarnings("unused")
@Namespace("/main")
@Action(value="forumAction",results={@Result(name="list",location="/WEB-INF/jsp/admin/forum/list.jsp"),@Result(name="show",location="/WEB-INF/jsp/admin/forum/show.jsp")})
@Scope("prototype")
public class ForumAction extends ModelDrivenBaseAction<Forum>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 0 表示全部主题 <br>
	 * 1 表示只看精华帖
	 */
	private int viewType = 0;

	/**
	 * 0 代表默认排序(所有置顶帖在前面，并按最后更新时间降序排列)<br>
	 * 1 代表只按最后更新时间排序<br>
	 * 2 代表只按主题发表时间排序<br>
	 * 3 代表只按回复数量排序
	 */
	private int orderBy = 0;

	/**
	 * true 表示升序<br>
	 * false 表示降序
	 */
	private boolean asc = false;
	//显示板块列表
	public String list(){
	
		List<Forum> forumList=forumService.findAll();
		ActionContext.getContext().put("forumList", forumList);
		return "list";
	}
	//显示单个板块情况
	public String show(){
	Forum forum=forumService.findById(model.getId());
	ActionContext.getContext().put("forum", forum);
//		List<Topic> topicList=topicService.findByForum(forum);
//		ActionContext.getContext().put("topicList", topicList);
//		PageBean pageBean=topicService.getPageBean(pageNum,forum);
//	ActionContext.getContext().getValueStack().push(pageBean);
	new HqlHelper(Topic.class, "t")//
	.addCondition("t.forum=?", forum)//
	.addCondition(viewType == 1, "t.type=?", Topic.TYPE_BEST) // 1表示只看精华帖
	.addOrder(orderBy == 1, "t.lastUpdateTime", asc) // 1 代表只按最后更新时间排序
	.addOrder(orderBy == 2, "t.postTime", asc) // 2 代表只按主题发表时间排序
	.addOrder(orderBy == 3, "t.replyCount", asc) // 3 代表只按回复数量排序
	.addOrder(orderBy == 0, "(CASE t.type WHEN 2 THEN 2 ELSE 0 END)", false)//
	.addOrder(orderBy == 0, "t.lastUpdateTime", false) // 0 代表默认排序(所有置顶帖在前面，并按最后更新时间降序排列)
	.buildPageBeanForStruts2(pageNum, replyService);
	return "show";
	}
	
	
	public int getViewType() {
		return viewType;
	}
	public void setViewType(int viewType) {
		this.viewType = viewType;
	}
	public int getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(int orderBy) {
		this.orderBy = orderBy;
	}
	public boolean isAsc() {
		return asc;
	}
	public void setAsc(boolean asc) {
		this.asc = asc;
	}
	
	
	
	
}
