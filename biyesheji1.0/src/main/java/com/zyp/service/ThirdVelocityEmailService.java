package com.zyp.service;

import java.util.Map;

public interface ThirdVelocityEmailService
{
	public void sendEmail(final Map<String,Object> model,final String subject,final String vmfile,final String[] mailTo,final String [] files);  
    
}
