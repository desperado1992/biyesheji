package com.zyp.view.action;



import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;


import com.opensymphony.xwork2.ActionContext;
import com.zyp.base.ModelDrivenBaseAction;


import com.zyp.model.AdvisePosition;



@Namespace("/main")
@Action(value="advisePositionAction",results={@Result(name="list",location="/WEB-INF/jsp/admin/advisePosition/list.jsp"),@Result(name="toList",type="redirectAction",location="advisePositionAction!list.action"),@Result(name="saveUI",location="/WEB-INF/jsp/admin/advisePosition/saveUI.jsp")})
@Scope("prototype")
public class AdvisePositionAction extends ModelDrivenBaseAction<AdvisePosition>
{


	private static final long serialVersionUID = -2615413693499734149L;

	
	public String list(){
	

		List<AdvisePosition> advisePositions=advisePositionService.findAll();

		ActionContext.getContext().put("advisePositions", advisePositions);
		return "list";
	}
	
	public String add(){
	
		advisePositionService.save(model);
		
		return "toList";
	}
	
	public String editUI(){
	AdvisePosition advisePosition=advisePositionService.findById(model.getId());
	ActionContext.getContext().getValueStack().push(advisePosition);	
		return "saveUI";
	}
	
	public String addUI(){
		
		return "saveUI";
	}
	
	public String edit(){
		advisePositionService.update(model);
		return "toList";
	}
	
	public String delete(){
		advisePositionService.delete(model.getId());
		
		return "toList";
	}
}

