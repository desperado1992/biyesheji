package com.zyp.tigger;

import java.util.Timer;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class TaskManagerListener  implements ServletContextListener {
	/**
	* 每分钟的毫秒数
	*/
	public static final long PERIOD_min = 1000*60;
	/**
	* 每小时的毫秒数
	*/
	public static final long PERIOD_hour = 1000*60*60;
	
	/**
	* 每天的毫秒数
	*/
	public static final long PERIOD_DAY = 1000*60*60*24;
	/**
	* 一周内的毫秒数
	*/
	public static final long PERIOD_WEEK = PERIOD_DAY * 7;
	/**
	* 无延迟
	*/
	public static final long NO_DELAY = 0;
	/**
	* 定时器
	*/
	private Timer timer;
 
	public void contextDestroyed(ServletContextEvent event) {
		// TODO Auto-generated method stub
		timer.cancel(); // 定时器销毁
		  event.getServletContext().log("定时器销毁");  
	}
   /**
    * 当容器启动时 初始化一个定时器
    */
	public void contextInitialized(ServletContextEvent event) {
		ServletContext context= event.getServletContext();
		
		// TODO Auto-generated method stub
		//定义定时器初始化
		timer = new Timer("我的业务需要定时执行",true); 
		 event.getServletContext().log("定时器已启动"); 
		 
		 timer.schedule(new IndexTask(event), 0, PERIOD_DAY);
		//启动定时任务,每分钟执行一次
		//timer.schedule(new BackUpTableTask(context),NO_DELAY, PERIOD_min/6);//每十秒执行一次
		//  timer.schedule(new BackUpTableTask(),NO_DELAY, 30000);
		

	}

}
