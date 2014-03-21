package com.zyp.tigger;

import java.util.TimerTask;

import javax.servlet.ServletContext;

public class BackUpTableTask extends TimerTask  {
	ServletContext 	context;
	private static boolean isRunning = false; //执行的标志
     public BackUpTableTask(ServletContext 	context){
    	 this.context=context;
     }
	@Override
	public void run() {
		// TODO Auto-generated method stub
		if (!isRunning) { 
			isRunning = true; 
			System.out.println("开始执行任务..."); //开始定时任务 
			//---------处理我的业务
			System.out.println(context.getAttribute("classMap")+"==设置前=====classMap");
			String classMap=String.valueOf(Math.random()*1000000);
			context.setAttribute("classMap", classMap);
			System.out.println(context.getAttribute("classMap")+"===设置后====classMap");
		   //----------处理完毕
			System.out.println("执行任务完成..."); //任务完成 
			isRunning = false; 
			} else { 
				System.out.println("上一次任务执行还未结束..."); //上一次任务执行还未结束 
			} 

		
	}
}