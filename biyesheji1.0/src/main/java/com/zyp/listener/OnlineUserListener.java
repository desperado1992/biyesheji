package com.zyp.listener;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.struts2.ServletActionContext;



public class OnlineUserListener implements HttpSessionListener
{

	Map<String,HttpSession> sessionMap=new HashMap<String,HttpSession>();
	Map<String,Object>  callMap=new HashMap<String, Object>();
	private HttpSession session=null;
	@Override
	public void sessionCreated(HttpSessionEvent se)
	{
	   session  =  se.getSession();
		sessionMap.put(session.getId(),  session);
		String ip=ServletActionContext.getRequest().getRemoteAddr();
		callMap.put(ip, session);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se)
	{
		
	  sessionMap.remove(se.getSession().getId());
		
	}

	public Map<String, HttpSession> getSessionMap()
	{
		return sessionMap;
	}

	

	public Map<String, Object> getCallMap()
	{
		return callMap;
	}

	

	
	
}
