package com.zyp.util;

import org.jasypt.util.text.BasicTextEncryptor;

public class JasyPtUtils {

	public static void main(String[] args) {
		 BasicTextEncryptor encryptor = new BasicTextEncryptor();  
	        encryptor.setPassword("zhuyuping");  
	        String encrypted = encryptor.encrypt("123456");  
	        System.out.println(encrypted);  
	        //jiemi
//	        BasicTextEncryptor textEncryptor2 = new BasicTextEncryptor();   
//	        textEncryptor2.setPassword("root");   
//	        String oldPassword = textEncryptor2.decrypt(encrypted);     
//	        System.out.println(oldPassword);  
	}
	
	
}
