package com.zyp.view.action;



import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;



import com.opensymphony.xwork2.ActionContext;
import com.zyp.base.ModelDrivenBaseAction;
import com.zyp.model.Forum;



@Namespace("/main")
@Action(value="forumManagerAction",results={@Result(name="toList",type="redirectAction",location="forumManagerAction!list.action"),@Result(name="list",location="/WEB-INF/jsp/admin/forumManage/list.jsp"),@Result(name="saveUI",location="/WEB-INF/jsp/admin/forumManage/saveUI.jsp")})
@Scope("prototype")
public class ForumManagerAction extends ModelDrivenBaseAction<Forum>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 列出
	 * @return
	 */
    public String list(){
    
     List<Forum> forumList=forumService.findAll();
      ActionContext.getContext().put("forumList", forumList);
     
    	return "list";
    }
    /**
     * 添加
     * @return
     */
    
    public String add(){
    
    forumService.save(model);
    	
     return "toList";	
    }
    /**
     * 新增页面
     * @return
     */
    public String addUI(){
    
    	
    	return "saveUI";
    }
    /**
     * 编辑
     * @return
     */
    public String editUI(){
    	
    Forum forum=forumService.findById(model.getId());	
      ActionContext.getContext().getValueStack().push(forum);	
    
    	return "saveUI";
    }
    /**
     * 修改
     * @return
     */
    public String edit(){
        Forum forum=forumService.findById(model.getId());
    	forum.setName(model.getName());
    	forum.setDescription(model.getDescription());
    	forumService.update(forum);
    	return "toList";
    }
    /**
     * 删除
     * @return
     */
    public String delete(){
    	
    	forumService.delete(model.getId());
    	
    	return "toList";
    }
	
    
    //上移
    public String moveUp(){
    	forumService.moveUp(model.getId());
    	
    return "toList";	
    }
    //下移
    public String moveDown(){
    	
    	forumService.moveDown(model.getId());
    	return "toList";
    }
    
	
}
