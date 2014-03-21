package com.zyp.view.action;



import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;


import com.opensymphony.xwork2.ActionContext;
import com.zyp.base.ModelDrivenBaseAction;

import com.zyp.model.Advise;
import com.zyp.model.AdvisePosition;



@Namespace("/main")
@Action(value="adviseAction",results={@Result(name="list",location="/WEB-INF/jsp/admin/advise/list.jsp"),@Result(name="toList",type="redirectAction",location="adviseAction!list.action"),@Result(name="saveUI",location="/WEB-INF/jsp/admin/advise/saveUI.jsp")})
@Scope("prototype")
public class AdviseAction extends ModelDrivenBaseAction<Advise>
{

	
	private Long adPositionId;
	
	

	private static final long serialVersionUID = -2615413693499734149L;

	
	public String list(){
	

		List<Advise> advises=adviseService.findAll();
         
		ActionContext.getContext().put("advises", advises);
		
		return "list";
	}
	
	public String add(){
	
	AdvisePosition advisePosition=advisePositionService.findById(adPositionId);
	
	   model.setAdvisePosition(advisePosition);
	
		adviseService.save(model);
		
		return "toList";
	}
	
	public String editUI(){
        List<AdvisePosition> advisePositions=advisePositionService.findAll();
		
		ActionContext.getContext().put("advisePositionList", advisePositions);
		
		Advise advise=adviseService.findById(model.getId());
		 adPositionId=advise.getAdvisePosition().getId();
		 ActionContext.getContext().getValueStack().push(advise);
		return "saveUI";
	}
	
	public String addUI(){
		
		List<AdvisePosition> advisePositions=advisePositionService.findAll();
		
		ActionContext.getContext().put("advisePositionList", advisePositions);
		
		return "saveUI";
	}
	
	public String edit(){
		adviseService.update(model);
		
		
		return "toList";
	}
	
	public String delete(){
		adviseService.delete(model.getId());
		
		return "toList";
	}

	public Long getAdPositionId() {
		return adPositionId;
	}

	public void setAdPositionId(Long adPositionId) {
		this.adPositionId = adPositionId;
	}
	
	
	
}

