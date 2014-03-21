package com.zyp.spring.email;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class ThirdVelocityEmailAppConfig
{
	//从配置文件中读取相应的邮件配置属性  
    private @Value("${email.host}") String emailHost;  
    private @Value("${email.username}") String userName;  
    private @Value("${email.password}") String password;  
    private @Value("${mail.smtp.auth}") String mailAuth;  
    //JavaMailSender用来发送邮件的类  
    public @Bean JavaMailSender  mailSender(){  
       JavaMailSenderImpl ms = new JavaMailSenderImpl();  
       ms.setHost(emailHost);  
       ms.setUsername(userName);  
       ms.setPassword(password);  
       Properties pp = new Properties();  
       pp.setProperty("mail.smtp.auth", mailAuth);  
       ms.setJavaMailProperties(pp);  
       return ms;     
    }    
}
