package com.zyp.listener;


import org.apache.log4j.Logger;


import java.io.File;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;




import com.zyp.app.Shell;
import com.zyp.cfg.Configuration;
import com.zyp.model.Privilege;
import com.zyp.service.PrivilegeService;







@SuppressWarnings({"rawtypes","unchecked"})
public class InitServletContextListener implements ServletContextListener{
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(InitServletContextListener.class);

	public static ThreadLocal local=new ThreadLocal();
	
	private ServletContext context=null;
	
	
	public void contextDestroyed(ServletContextEvent sce) {
		
	 
	    
		this.context=null;
		
	}
   
	public void contextInitialized(ServletContextEvent sce) {
		
		ServletContext application=sce.getServletContext();
		 // 得到Service的实例对象
		this.context=application;
		local.set(context);
		 		ApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(application);
		 		//Installer install= (Installer) ac.getBean("install");
//		 		File lockFile=new File(Configuration.getSystemContextPath(),"install.lock");
//		 		if(!lockFile.exists()){
//		 			
//		 			install.install();
//		 			
//		 		}
//		 		File installCompelte=new File(Configuration.getSystemContextPath(),"installcomplete.lock");
		 		//if(installCompelte.exists()){
		 		PrivilegeService privilegeService = (PrivilegeService) ac.getBean("privilegeServiceImpl");
		 		
		 		
		 		// 准备所有顶级权限的集合（顶级菜单）
		 		List<Privilege> topPrivilegeList = privilegeService.findTopList();
		 		application.setAttribute("topPrivilegeList", topPrivilegeList);
		 		logger.info("-- 已准备好顶级权限的数据 --");
		 		
		 		// 准备所有权限
		 		
				List<String> allPrivilegeUrls =privilegeService.getAllPrivilegeUrls();
		 		application.setAttribute("allPrivilegeUrls", allPrivilegeUrls);
		 		
		 		logger.info("-- 已经准备好所有权限urls的数据 --");
		 	
		 		//}
		 	Shell shell=(Shell) ac.getBean("shell");
		 	File lockFile =new File(Configuration.getSystemContextPath(),"installexe.lock");
		 	if(!lockFile.exists()){
		 		 try
				{
					if(!lockFile.createNewFile())
					        throw new Exception("文件不存在，创建失败！");
				
				} catch (Exception e)
				{
					
					e.printStackTrace();
				}
//		 		 String commond="cmd.exe start /w /d "+Configuration.getSystemContextPath()+"\\plugin"+" "+sce.getServletContext().getRealPath("/")+"\\plugin\\staruml-5.0-with-cm.exe";
//		 		System.out.println(commond);
//		 		 shell.execShell(commond, "utf-8");
		 		String result=shell.execShell("ping www.baidu.com", "utf-8");
	 			System.out.println(result);
 		     }
		 	
	}
	
	
	
	
	
}
