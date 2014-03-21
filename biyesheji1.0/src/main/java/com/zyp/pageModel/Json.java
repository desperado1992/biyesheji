package com.zyp.pageModel;

import java.io.Serializable;

public class Json implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1706541745706980529L;
	private String message="";
	private boolean success=false;
	private Object obj=null;
	public Json()
	{
		
	}
	public String getMessage()
	{
		return message;
	}
	public void setMessage(String message)
	{
		this.message = message;
	}
	public boolean isSuccess()
	{
		return success;
	}
	public void setSuccess(boolean success)
	{
		this.success = success;
	}
	public Object getObj()
	{
		return obj;
	}
	public void setObj(Object obj)
	{
		this.obj = obj;
	}
	
	
	
	
	
	
}
