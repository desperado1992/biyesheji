package com.zyp.model;

import java.io.Serializable;




public class Dict implements Serializable
{
 /**
	 * 
	 */
	private static final long serialVersionUID = -6760652767508802736L;

private Long id;	


private String dictid;

public Long getId()
{
	return id;
}

public void setId(Long id)
{
	this.id = id;
}

public String getDictid()
{
	return dictid;
}

public void setDictid(String dictid)
{
	this.dictid = dictid;
}



 

 private String key;
 
 private String value;




public String getKey()
{
	return key;
}

public void setKey(String key)
{
	this.key = key;
}

public String getValue()
{
	return value;
}

public void setValue(String value)
{
	this.value = value;
}





public Dict(String dictid, String key, String value)
{
	
	this.dictid = dictid;
	this.key = key;
	this.value = value;
}

public Dict()
{
	
}
	
	
	
}
