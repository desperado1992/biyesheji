package com.zyp.view.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;

import com.zyp.base.ModelDrivenBaseAction;
import com.zyp.model.Area;


@Namespace("/main")
@Action(value="areaAction",results={@Result(name="toList",type="redirectAction",location="areaAction!list.action"),@Result(name="list",location="/WEB-INF/jsp/admin/area/list.jsp"),@Result(name="saveUI",location="/WEB-INF/jsp/admin/area/saveUI.jsp")})
@Scope("prototype")
public class AreaAction  extends ModelDrivenBaseAction<Area>
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2881964118758309324L;

}
