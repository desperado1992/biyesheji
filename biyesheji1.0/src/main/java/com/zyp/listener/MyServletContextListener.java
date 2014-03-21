package com.zyp.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
@SuppressWarnings({"rawtypes","unchecked"})
public class MyServletContextListener implements ServletContextListener
{

	
	public static ThreadLocal local=new ThreadLocal();
	private ServletContext context=null;
	
	@Override
	public void contextInitialized(ServletContextEvent sce)
	{
	this.context=sce.getServletContext();
	local.set(context);
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce)
	{
	
		this.context=null;
	}

}
