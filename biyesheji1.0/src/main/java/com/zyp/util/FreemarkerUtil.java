package com.zyp.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Map;

import javax.servlet.ServletContext;


import org.springframework.stereotype.Component;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
@Component
public class FreemarkerUtil {
	//getTemplate("01.ftl")
	private static FreemarkerUtil freemarkerUtil=null;
	public static FreemarkerUtil getInstance(){
		if(freemarkerUtil==null){
			
			freemarkerUtil=new FreemarkerUtil();
		}
		return freemarkerUtil;
	}
	
	private Template getTemplate(String name) {
		try {
			//通过Freemaker的Configuration读取相应的ftl
			Configuration cfg = new Configuration();
			//设定去哪里读取相应的ftl模板文件
			cfg.setClassForTemplateLoading(this.getClass(),"/ftl");
			//在模板文件目录中找到名称为name的文件
			Template temp = cfg.getTemplate(name);
			return temp;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void print(String name,Map<String,Object> root) {
		try {
			//通过Template可以将模板文件输出到相应的流
			Template temp = this.getTemplate(name);
			temp.process(root, new PrintWriter(System.out));
		} catch (TemplateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void fprint(String name,Map<String,Object> root,String outFile) {
		FileWriter out = null;
		try {
			//通过一个文件输出流，就可以写到相应的文件中
			
			 File htmlFile = new File(outFile);
            if(!htmlFile.getParentFile().exists()){
                htmlFile.getParentFile().mkdirs();
            }
            if(!htmlFile.exists()){
                htmlFile.createNewFile();
            }
			out = new FileWriter(new File(outFile));
			Template temp = this.getTemplate(name);
			temp.setEncoding("UTF-8");
			temp.process(root, out);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		} finally {
			try {
				if(out!=null) out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	  public  void crateHTML(ServletContext context,String name,  
	           Map<String, Object> data, String templatePath, String targetHtmlPath) {
	        try { 
	             //filepath:ftl存放路径（/template/file/static）
	        	
	        	Template  template = this.getTemplate(name);
	           //templatePath:ftl文件名称（template.ftl）
	            
	            template.setEncoding("UTF-8");  
	            // 静态页面要存放的路径  
	            String htmlPath = targetHtmlPath;  
	            File htmlFile = new File(htmlPath);  
	            Writer out = new BufferedWriter(new OutputStreamWriter(  
	                    new FileOutputStream(htmlFile), "UTF-8"));  
	            // 处理模版 map数据 ,输出流
	            template.process(data, out);  
	            out.flush();  
	            out.close();  
	              
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	          
	    }  
	
	
}
