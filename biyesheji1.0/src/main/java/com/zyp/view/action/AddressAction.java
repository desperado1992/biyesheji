package com.zyp.view.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;

import com.opensymphony.xwork2.ActionContext;
import com.zyp.base.ModelDrivenBaseAction;
import com.zyp.model.Address;
import com.zyp.model.User;


@Namespace("/main")
@Action(value="addressAction",results={@Result(name="list",location="/WEB-INF/jsp/admin/member/addressList.jsp"),@Result(name="toMember",type="redirectAction",location="memberAction!list.action"),@Result(name="saveUI",location="/WEB-INF/jsp/admin/member/saveUI.jsp")})
@Scope("prototype")
public class AddressAction extends ModelDrivenBaseAction<Address>
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2615413693499734149L;
	private Long memberId;

	public Long getMemberId()
	{
		return memberId;
	}

	public void setMemberId(Long memberId)
	{
		this.memberId = memberId;
	}
	
	public String addUI(){
	
User user=userService.findById(memberId);
List<Address> addrs=user.getAddresses();		

ActionContext.getContext().put("addrs", addrs);
ActionContext.getContext().getValueStack().push(user);

		return "list";
	}
	
	public String add(){
		User user=userService.findById(memberId);
		user.getAddresses().add(model);
		addressService.save(model);
		userService.update(user);
		return "toMember";
	}

	
	
}

