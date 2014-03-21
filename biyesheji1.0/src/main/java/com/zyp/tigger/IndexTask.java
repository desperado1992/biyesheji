package com.zyp.tigger;

import java.util.TimerTask;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.zyp.service.FreemarkerService;



public class IndexTask extends TimerTask
{

	 ServletContextEvent context;  
	 WebApplicationContext wac;  
	 FreemarkerService freemarkerService;
	
	    public IndexTask(ServletContextEvent event) {  
	        context = event;  
	        ServletContext application = context.getServletContext();  
	        wac = WebApplicationContextUtils.getWebApplicationContext(application);  
	   
	    }  
	
	@Override
	public void run()
	{
	try
	{
		System.out.println("IndexTask.run()");
		freemarkerService=(FreemarkerService) wac.getBean("freemarkerServiceImpl");
		
		
		freemarkerService.createHtml();
	} catch (Exception e)
	{
		
	}
		
		

	}

}
