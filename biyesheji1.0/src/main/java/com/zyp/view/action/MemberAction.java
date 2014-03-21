package com.zyp.view.action;

import java.io.File;
import java.util.HashSet;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;

import com.opensymphony.xwork2.ActionContext;
import com.zyp.base.ModelDrivenBaseAction;

import com.zyp.model.Role;
import com.zyp.model.User;

@Namespace("/main")
@Action(value="memberAction",results={@Result(name="toList",type="redirectAction",location="memberAction!list.action"),@Result(name="toAddress",type="redirectAction",location="addressAction!addUI.action"),@Result(name="list",location="/WEB-INF/jsp/admin/member/list.jsp"),@Result(name="saveUI",location="/WEB-INF/jsp/admin/member/saveUI.jsp")})
@Scope("prototype")
public class MemberAction extends ModelDrivenBaseAction<User>
{

	private File  userImg;
	 private String userImgFileName; //文件名称
	    private String userImgContentType; //文件类型
	
	private  Long[]  roleIds;
	
	public Long[] getRoleIds()
	{
		return roleIds;
	}

	public void setRoleIds(Long[] roleIds)
	{
		this.roleIds = roleIds;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 9144487586199444682L;

	public String list(){
		
		List<User> users=userService.findAll();
		ActionContext.getContext().put("users", users);
		
		return "list";
	}
	
	public String addUI(){
		 List<Role> roleList=roleService.findAll();
	      ActionContext.getContext().put("roleList", roleList);
		
		return  "saveUI";
	}
	public String add(){
		if(userImg!=null){
			String path = uploadFile(userImg,userImgFileName);
		
			model.setFace(path);
		}
		
List<Role> roleList=roleService.findByids(roleIds);
    	
    model.setRoles(new HashSet<Role>(roleList));
    String PasswdMD5=DigestUtils.md5Hex("123456");
    model.setPassword(PasswdMD5);
    	userService.save(model);
	      
		
		return "toList";
	}
	
	public String editUI(){
	
		 
    System.out.println("MemberAction.editUI()"+model.getId());
      User user=userService.findById(model.getId());
      ActionContext.getContext().getValueStack().push(user); 
      List<Role> roleList=roleService.findAll();
  	ActionContext.getContext().put("roleList", roleList);
  	if(user.getRoles().size()>0){
    	roleIds=new Long[user.getRoles().size()];
    	int index=0;
    	for(Role role : user.getRoles()){
    		roleIds[index++]=role.getId();
    	}
    	
    }
		   return "saveUI";
	
	}
	public String edit(){
		 
		if(userImg!=null){
			String path = uploadFile(userImg,userImgFileName);
		
			model.setFace(path);
		}
		  
		 	    
		        List<Role> roleList=roleService.findByids(roleIds);
		        
		        model.setRoles(new HashSet<Role>(roleList));
		        
		        userService.update(model);
		       
		
	
	
		return "toList";
	}
	
	public String AddAddress(){
		
		User user=userService.findById(model.getId());
		ActionContext.getContext().getValueStack().push(user);
		
		return "toAddress";
				
	}
	
	
	
	
	public String delete(){
		
		userService.delete(model.getId());
		return "toList";
	}

	public File getUserImg()
	{
		return userImg;
	}

	public void setUserImg(File userImg)
	{
		this.userImg = userImg;
	}

	public String getUserImgFileName()
	{
		return userImgFileName;
	}

	public void setUserImgFileName(String userImgFileName)
	{
		this.userImgFileName = userImgFileName;
	}

	public String getUserImgContentType()
	{
		return userImgContentType;
	}

	public void setUserImgContentType(String userImgContentType)
	{
		this.userImgContentType = userImgContentType;
	}
	
	
	
}
