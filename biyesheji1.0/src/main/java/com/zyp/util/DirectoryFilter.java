package com.zyp.util;

import java.io.File;
import java.io.FilenameFilter;

public class DirectoryFilter implements FilenameFilter
{
	 String myString;  
	    public DirectoryFilter(String myString)  
	    {  
	        this.myString = myString;  
	    }  

	@Override
	public boolean accept(File dir, String name)
	{
		  String f= new File(name).getName();  
	        if(f.contains(myString) || f.equals(myString)){  
	            return true;  
	        }  
	        return false; 
	}

}
