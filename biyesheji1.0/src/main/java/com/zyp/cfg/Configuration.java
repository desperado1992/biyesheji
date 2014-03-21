package com.zyp.cfg;

import com.zyp.util.PropertyUtil;



public class Configuration {

	private  static ThreadLocal<Integer> pageSize=new ThreadLocal<Integer>();
	private  static ThreadLocal<String> uploadPath=new ThreadLocal<String>();
	
	private  static ThreadLocal<String> systemContextPath=new ThreadLocal<String>();
	
	private static ThreadLocal<String> email=new ThreadLocal<String>();
	
	
	static{
	pageSize.set(Integer.parseInt(PropertyUtil.getProperty("pageSize")));
	uploadPath.set(PropertyUtil.getProperty("uploadDir"));
	systemContextPath.set(System.getProperty("user.dir"));
	email.set(PropertyUtil.getProperty("email"));
	}

	public static Integer getPageSize()
	{
		Integer ps=pageSize.get();
	   if(ps==null){
		   ps=Integer.parseInt(PropertyUtil.getProperty("pageSize"));
		   pageSize.set(ps);
	   }
		return ps;
	}

	public static String getUploadPath()
	{
		String upath=uploadPath.get();
		if(upath==null&&"".equals(upath)){
			upath=PropertyUtil.getProperty("uploadDir");
			uploadPath.set(upath);
		}		
		return upath;
	}
	public static String getSystemContextPath()
	{
	String sysPath=systemContextPath.get();
	   if(sysPath==null){
		   sysPath=System.getProperty("user.dir");
		   systemContextPath.set(sysPath);
	   }
	   
	 
		return sysPath;
		
	}
	
	public static String getEmail()
	{
	String em=email.get();
	   if(em==null){
		   em=PropertyUtil.getProperty("email");
		  email.set(em);
	   }
	   
	  
		return em;
		
	}

	

  
	
	
	
	
	
	
	
	
	
	
	
	
	
}
