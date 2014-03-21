package com.zyp.service.impl;

import java.io.File;
import java.util.Map;

import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;
import org.springframework.ui.velocity.VelocityEngineUtils;

import com.zyp.cfg.Configuration;
import com.zyp.service.ThirdVelocityEmailService;
@Component
public class ThirdVelocityEmailServiceImpl implements ThirdVelocityEmailService
{

	 @Resource
	 private JavaMailSender  mailSender;
	 @Resource
	 private VelocityEngine velocityEngine;
	
	@Override
	public void sendEmail(final Map<String, Object> model, final String subject, final String vmfile, final String[] mailTo, final String[] files)
	{
		
		 MimeMessagePreparator preparator = new MimeMessagePreparator() {
	           //注意MimeMessagePreparator接口只有这一个回调函数
	         public void prepare(MimeMessage mimeMessage) throws Exception
	         {
	            MimeMessageHelper message = new MimeMessageHelper(mimeMessage,true,"UTF-8");
	            //这是一个生成Mime邮件简单工具，如果不使用GBK这个，中文会出现乱码
	            //如果您使用的都是英文，那么可以使用MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
	            message.setTo(mailTo);//设置接收方的email地址
	            message.setSubject(subject);//设置邮件主题
	            message.setFrom(Configuration.getEmail());//设置发送方地址
	             String text = VelocityEngineUtils.mergeTemplateIntoString(
	               velocityEngine, vmfile,"UTF-8", model);
	             //从模板中加载要发送的内容，vmfile就是模板文件的名字
	             //注意模板中有中文要加GBK，model中存放的是要替换模板中字段的值
	            message.setText(text, true);
	           
	            //将发送的内容赋值给MimeMessageHelper,后面的true表示内容解析成html
	            //如果您不想解析文本内容，可以使用false或者不添加这项
	            FileSystemResource file;
	            for(String s:files)//添加附件
	            {
	            	s=MimeUtility.encodeWord(s);
	               file = new FileSystemResource(new File(s));//读取附件
	              
	               message.addAttachment(s, file);//向email中添加附件
	            }
	          }
	      };
	 
	       mailSender.send(preparator);//发送邮件
	}
	
	/**
	 * 
	 * 
	 *  ApplicationContext context =
           new ClassPathXmlApplicationContext("com/guan/chapter19/email/ThirdVelocityEmailConfig.xml");
       ThirdVelocityEmailService tves = context.getBean(ThirdVelocityEmailService.class);
       Map<String,Object> model = new HashMap<String,Object>();
       model.put("userName","zhuyuping");
       model.put("emailAddress", "zhuyuping1992@126.com");
       tves.sendEmail(model,"欢迎您的加入","welcome.vm",new String[]{"zhuyuping1992@163.com"},new String[]{"F:/Sunset.jpg","F:/spring-hibernate.rar"});
       //参数说明：替换velocity模板的变量和值对，邮件主题，velocity模板文件的路径，接收方email地址，附件
       //简单说明，如果您要群发，可以在接收方email地址中多传入几个email地址，附件可以一次发送多个
       }
	 * 
	 * 
	 */

}
