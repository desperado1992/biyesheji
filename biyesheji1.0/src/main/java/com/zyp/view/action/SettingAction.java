package com.zyp.view.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;

import com.zyp.base.ModelDrivenBaseAction;
import com.zyp.model.Setting;
@Namespace("/main")
@Action(value="settingAction",results={@Result(name="toList",type="redirectAction",location="settingAction!list.action"),@Result(name="list",location="/WEB-INF/jsp/admin/setting/index.jsp")})
@Scope("prototype")
public class SettingAction extends ModelDrivenBaseAction<Setting>
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -737888487219078291L;

	
	
	
	public String list(){
		
		Setting title=settingService.findByPro("title");
		Setting meta=settingService.findByPro("meta");
		Setting contect=settingService.findByPro("contect");
		Setting copyright=settingService.findByPro("copyright");
		Setting notice=settingService.findByPro("notice");
		Setting home_title=settingService.findByPro("home_title");
		Setting home_keywords=settingService.findByPro("home_keywords");
		Setting hone_description=settingService.findByPro("hone_description");
		//XX xmemcache
		return "list";
		
		
	}
	
	public String save(){
		
	
		return "toList";
	}
	
}
