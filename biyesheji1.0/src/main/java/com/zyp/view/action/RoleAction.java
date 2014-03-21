package com.zyp.view.action;

import java.util.HashSet;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;

import com.opensymphony.xwork2.ActionContext;
import com.zyp.base.ModelDrivenBaseAction;
import com.zyp.model.Privilege;
import com.zyp.model.Role;


@Namespace("/main")
@Action(value="roleAction",results={@Result(name="toList",type="redirectAction",location="roleAction!list.action"),@Result(name="list",location="/WEB-INF/jsp/admin/role/list.jsp"),@Result(name="saveUI",location="/WEB-INF/jsp/admin/role/saveUI.jsp"),@Result(name="setPrivilege",location="/WEB-INF/jsp/admin/role/setPrivilegeUI.jsp")})
@Scope("prototype")
public class RoleAction extends ModelDrivenBaseAction<Role>
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1006898133446037428L;
	private Long[] privilegeIds;
	
	public String list(){
		//shopcategoryService.findAll();
		List<Role> roles=roleService.findAll();
		ActionContext.getContext().put("roles", roles);
     return "list";		
	}
	
	public String addUI(){
		
		
		
		return "saveUI";
	}
	
	public String add(){
		
	 roleService.save(model);
		
		return "toList";
	}
	
	public String editUI(){
		
		Role role=roleService.findById(model.getId());
		ActionContext.getContext().getValueStack().push(role);
		return "saveUI";
	}
	
	public String edit(){
		
		roleService.update(model);
		return "toList";
	}
	
	public String delete(){
		
		roleService.delete(model.getId());
		return "toList";
	}
	
	public String setPrivilegeUI(){
		//准备数据
 	   Role role= roleService.findById(model.getId());
 	   ActionContext.getContext().put("role", role);
 	   List<Privilege> topPrivilegeList=privilegeService.findTopList();
 	   
 	   ActionContext.getContext().put("topPrivilegeList", topPrivilegeList);
 	   int index=0;
 	   privilegeIds=new Long[role.getPrivileges().size()];
 	   for(Privilege privilege : role.getPrivileges()){
 		   
 		   privilegeIds[index++]=privilege.getId();
 	   }
		
		
		return "setPrivilege";
	}
	
	 /**修改**/
    public String setPrivilege(){
 	  Role role=roleService.findById(model.getId());
       //设置需要修改的属性
 	  
 	  List<Privilege> privilegeList=privilegeService.findByids(privilegeIds);
 	  role.setPrivileges(new HashSet<Privilege>(privilegeList));
 	  //设置要修改属性
 	  roleService.update(role);
 	  
       
 	   
 	   
 	  
 	   return "toList";
    }

	public Long[] getPrivilegeIds()
	{
		return privilegeIds;
	}

	public void setPrivilegeIds(Long[] privilegeIds)
	{
		this.privilegeIds = privilegeIds;
	}
	
	
	
	
}
