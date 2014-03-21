package com.zyp.view.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;

import com.zyp.base.BaseAction;
@Namespace("/main")
@Action(value="logRecorderAction",results={@Result(name="toList",type="redirectAction",location="logRecorderAction!list.action"),@Result(name="list",location="/WEB-INF/jsp/admin/logRecorder/list.jsp")
})
@Scope("prototype")
public class LogRecorderAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1307798720978058774L;

	
	public String list(){
		
		return "list";
	}
	
}
