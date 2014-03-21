package com.zyp.install;





import javax.annotation.Resource;


import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;



import com.zyp.model.Privilege;
import com.zyp.model.Setting;
import com.zyp.model.User;





@Component
public class Installer {
    
	@Resource
	private SessionFactory sessionFactory;
	
	@Transactional
	public void install(){
		Session session=sessionFactory.getCurrentSession();
		
		//session.createSQLQuery("CREATE DATABASE IF NOT EXISTS "+"`"+ReaderUtils.getBundle().getString("database")+"`"+" DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;").executeUpdate();
		Setting setting =new Setting("title","网站标题","校园二手交易网");
		Setting setting2=new Setting("meta", "网站描述", "校园，二手，商店，购物，交易");
		//Setting setting3=new Setting("link", "友情连接", "www.baidu.com,www.sina.com");//用逗号隔开
		Setting setting4=new Setting("contect", "联系方式", "南昌大学电子商务091毕业设计QQ1050316096 电话18011790152");
		Setting setting5=new Setting("copyright", "版权信息", "版权所有 power by zhuyuping");
		Setting setting6=new Setting("notice","公告信息","欢迎进入二手交易网站！");
		Setting setting7=new Setting("home_title","主页展示","欢迎进入WEBOS---GO Shoping");
		Setting setting8=new Setting("home_keywords","主页关键字","二手，交易，南昌大学，webos,电子商务！");
		Setting setting9=new Setting("hone_description","主页描述","校园二手交易webos是一个专们 大学生校园 二手交易的跳骚网上交易平台！采用Spring3+Hibernate4+maven+SpringMVC+struts2+jqueryUI+mysql开发！。");

		session.save(setting);
		session.save(setting2);
	//	session.save(setting3);
		session.save(setting4);
		session.save(setting5);
		session.save(setting6);
		session.save(setting7);
		session.save(setting8);
		session.save(setting9);
//		Dict dict=new Dict("1", "0", "主页栏目");
//		Dict dict2=new Dict("2", "1", "其他栏目");
//		Dict dict3=new Dict("3", "0", "内部连接");
//		Dict dict4=new Dict("4", "1", "外部连接");
//		Dict dict5=new Dict("5", "0", "非推荐栏目");
//		Dict dict6=new Dict("6", "1", "推荐栏目");
//		Dict dict7=new Dict("7", "0", "非顶部导航栏目");
//		Dict dict8=new Dict("8", "1", "顶部导航栏目");
//		Dict dict9=new Dict("9", "0", "栏目不启用");
//		Dict dict10=new Dict("10", "1", "栏目启用");
//		Dict dict11=new Dict("11", "0", "导航类型");
//		Dict dict12=new Dict("12", "1", "图片类型");
//		Dict dict13=new Dict("13", "2", "视频类型");
//		Dict dict14=new Dict("14", "3", "内容类型");
//	    session.save(dict);
//	    session.save(dict2);
//	    session.save(dict3);
//	    session.save(dict4);
//	    session.save(dict5);
//	    session.save(dict6);
//	    session.save(dict7);
//	    session.save(dict8);
//	    session.save(dict9);
//	    session.save(dict10);
//	    session.save(dict11);
//	    session.save(dict12);
//	    session.save(dict13);
//	    session.save(dict14);
	    
	    Privilege privilege,privilege1,privilege2,privilege3,privilege4,privilege5,privilege6;
	    //String name, String description, String url, Privilege parent
	      privilege=new Privilege("网站设置","",null);
	      privilege.setIcon("home");
	      privilege1=new Privilege("网站设置","main/settingAction!list",privilege);
		  privilege2=new Privilege("支付管理","main/payAction!list",privilege);
		  privilege3=new Privilege("配送管理","main/deliveryAction!list",privilege);
		  session.save(privilege);
		   session.save(privilege1);
		   session.save(privilege2);
		   session.save(privilege3);
		   privilege4=new Privilege("系统设置","main/settingAction!list",privilege1);
		   privilege5=new Privilege("在线客服","main/messageAction!list",privilege1);
		   session.save(privilege4);
		   session.save(privilege5);
		   privilege4=new Privilege("支付方式","main/payAction!list",privilege2);
		   session.save(privilege4);
		   
		    privilege4=new Privilege("配送方式","main/deliveryAction!list",privilege3);
		    privilege5=new Privilege("地区管理","main/areaAction!list",privilege3);
		    privilege6=new Privilege("物流公司","main/deliveryAction!list",privilege3);
		      
		    session.save(privilege4);
			session.save(privilege5);
			session.save(privilege6);
			   
	    privilege=new Privilege("商品管理","",null);
	    privilege.setIcon("shopping_cart");
	     privilege1=new Privilege("商品管理","main/shopAction!list",privilege);
	     privilege2=new Privilege("商品分类管理","main/shopcategoryAction!list",privilege);
	     privilege3=new Privilege("商品类型管理","main/shoptypeAction!list",privilege);
	     privilege4=new Privilege("商品规格管理","main/specificationAction!list",privilege);
	     privilege5=new Privilege("品牌管理","main/shopbrandAction!list",privilege);
	       session.save(privilege);
		   session.save(privilege1);
		   session.save(privilege2);
		   session.save(privilege3);
		   session.save(privilege4);
		   session.save(privilege5);
		
		   
	    
	    
	    privilege=new Privilege("订单处理","",null);
	    privilege.setIcon("show_thumbnails");
	    
	    privilege1=new Privilege("订单管理","main/orderAction!list",privilege);
	    privilege2=new Privilege("快递单管理","main/deliverycardAction!list",privilege);
	    session.save(privilege);
		session.save(privilege1);
		session.save(privilege2);
	    
		
	    
	    privilege=new Privilege("会员管理","",null);
	    privilege.setIcon("adress_book");
	    
	  privilege1=new Privilege("会员管理","main/memberAction!list",privilege);
	  privilege2=new Privilege("商品评论","main/shopcommentAction!list",privilege);
	  privilege3=new Privilege("在线留言","main/shopleaveAction!list",privilege);
	    
	  session.save(privilege);
	   session.save(privilege1);
	   session.save(privilege2);
	   session.save(privilege3);
	  
	     privilege=new Privilege("页面内容","",null);
	     privilege.setIcon("sort");
		    
	     
	    privilege1=new Privilege("内容管理","main/contentAction!list",privilege);
		 privilege2=new Privilege("模板管理","main/pageTemplateAction!list",privilege);
		privilege3=new Privilege("缓存管理","main/pageCacheAction!list",privilege);
		 privilege4=new Privilege("网站更新管理","main/pageBuildAction!list",privilege);
	       session.save(privilege);
			   session.save(privilege1);
			   session.save(privilege2);
			   session.save(privilege3);
			   session.save(privilege4);
	     
		 
	     
	   privilege=new Privilege("权限管理","",null);
	   privilege.setIcon("cogwheels");
	   
	  privilege1=new Privilege("权限管理","main/privilegeAction!list",privilege);
	  privilege2=new Privilege("角色管理","main/roleAction!list",privilege);
	  privilege3=new Privilege("站内消息","main/pageMessageAction!list",privilege);
	  privilege4=new Privilege("操作日志","main/logRecorderAction!list",privilege);
	  session.save(privilege);
	   session.save(privilege1);
	   session.save(privilege2);
	   session.save(privilege3);
	   session.save(privilege4);
	    
	    privilege=new Privilege("文章管理","",null);
	    privilege.setIcon("picture");
	    privilege1=new Privilege("栏目管理","main/channelAction!list",privilege);
		privilege2=new Privilege("友情链接","main/frendLinkAction!list",privilege);
		
	    
	    session.save(privilege);
	    session.save(privilege1);
		session.save(privilege2);
	    
		privilege=new Privilege("论坛管理","",null);
	    privilege.setIcon("show_thumbnails_with_lines");
	    privilege1=new Privilege("论坛管理","main/forumManagerAction!list",privilege);
		privilege2=new Privilege("论坛","main/forumAction!list",privilege);
		
	    
	    session.save(privilege);
	    session.save(privilege1);
		session.save(privilege2);
	    
	
	   
	    User user=new User();
		user.setLogName("admin");
		user.setName("超级管理员");
		user.setPassword(DigestUtils.md5Hex("admin"));
		user.setEmail("zhuyuping1992@gmail.com");
	
		session.save(user);
		
		
		//File lockFile=new File(Configuration.getSystemContextPath(),"installcomplete.lock");
 		
	//XXX 务必完成	
	
	}
	
	
	
	public static void main(String[] args) {
		System.out.println("正在执行安装...");
	 ApplicationContext ctx= new ClassPathXmlApplicationContext(new String[]{
				"classpath:spring.xml","classpath:spring-hibernate.xml"
		});
		Installer installer= (Installer) ctx.getBean("installer");
		
		installer.install();
		
	    
		System.out.println("== 安装完毕 ==");
		
		
	}
	
	
	
	
	
	
	
	
}
