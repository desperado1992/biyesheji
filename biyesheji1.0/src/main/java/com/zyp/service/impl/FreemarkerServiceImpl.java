package com.zyp.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

import org.springframework.stereotype.Component;

import org.springframework.web.context.ServletContextAware;





import com.zyp.constants.SystemContext;

import com.zyp.model.Channel;
import com.zyp.model.FrendLink;
import com.zyp.model.Position;
import com.zyp.pageModel.PageBean;





import com.zyp.service.AdvisePositionService;
import com.zyp.service.AdviseService;
import com.zyp.service.CACategoryService;
import com.zyp.service.ChannelArticleService;
import com.zyp.service.ChannelService;
import com.zyp.service.FreemarkerService;
import com.zyp.service.FrendLinkService;
import com.zyp.service.GoodsService;
import com.zyp.util.FreemarkerUtil;


@Component
public class FreemarkerServiceImpl  implements FreemarkerService,ServletContextAware
{
	
	
	
	@Resource
	protected AdviseService adviseService;
	@Resource
	protected AdvisePositionService advisePositionService;
	@Resource
	protected CACategoryService caCategoryService;
	@Resource
	protected FrendLinkService frendLinkService;
	@Resource
	protected ChannelService channelService;
	@Resource
	protected GoodsService goodsService;
	@Resource
	protected ChannelArticleService channelArticleService;

	private ServletContext servletContext;
	

	public FreemarkerServiceImpl()
	{
		
		//servletContext=(ServletContext) InitServletContextListener.local.get();
		//servletContext=servletContext;
	}



	@Override
	public void createTop()
	{
		
		Map<String,Object> root=new HashMap<String,Object>();
		String propName="position";
		Object propertyValue=Position.TOP;
	   List<Channel> topNavs=channelService.findByProperty(propName,propertyValue);
	   

	   root.put("topNavs", topNavs);
	   
	   
//	 ServletContext context=(ServletContext)InitServletContextListener.local.get();
//	 System.out.println(context.getRealPath("/WEB-INF/templates/html")+"/top.html");
	   //System.out.println(request.getContextPath()+"/WEB-INF/templates/html/top.html");
	   //System.out.println(request.getSession().getServletContext().getRealPath("/WEB-INF/templates/html/"));
	 FreemarkerUtil.getInstance().fprint("top.ftl",root, servletContext.getRealPath(SystemContext.FTL_HTMLPATH)+"/top.html");	
	   //FreemarkerUtil.getInstance().print("top.ftl",root);
	 System.out.println("重新生成了Top缓存");
	}



	@Override
	public void createNav()
	{
		Map<String,Object> root=new HashMap<String,Object>();
		String propName="position";
		Object propertyValue=Position.MIDDLE;
		List<Channel> channels=channelService.findTopByProperty(propName, propertyValue);
		
		root.put("channels", channels);
		
		FreemarkerUtil.getInstance().fprint("nav.ftl",root,servletContext.getRealPath(SystemContext.FTL_HTMLPATH)+"/nav.html");	
	
		 System.out.println("重新生成了Nav缓存");
	}



	@Override
	public void createContent()
	{
		Map<String,Object> root=new HashMap<String,Object>();	
	int pagesum=1;
    PageBean newShops=goodsService.findNewSHOP(pagesum);
    PageBean hotShops=goodsService.findHotSHOP(pagesum);
	root.put("newShops", newShops);
    if(hotShops.getRecordList()!=null) 
        root.put("hotShops", hotShops);
    
		FreemarkerUtil.getInstance().fprint("content.ftl", root, servletContext.getRealPath(SystemContext.FTL_HTMLPATH)+"/content.html");
		 System.out.println("重新生成了Content缓存");
	}



	@Override
	public void createFooter()
	
	{
		
	Map<String,Object> root=new HashMap<String,Object>();	
	List<FrendLink>	frendLinks=frendLinkService.findAll();
	                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               
	root.put("frendLinks", frendLinks);
	FreemarkerUtil.getInstance().fprint("footer.ftl", root, servletContext.getRealPath(SystemContext.FTL_HTMLPATH)+"/footer.html");
	 System.out.println("重新生成了Footer缓存");
	}



	@Override
	public void createHtml()
	{
		
		Map<String,Object> root=new HashMap<String,Object>();
		String propName="position";
		Object propertyValue=Position.TOP;
	   List<Channel> topNavs=channelService.findByProperty(propName,propertyValue);
	   
	   root.put("ctx", "");
	   root.put("topNavs", topNavs);
	   
	   
//	 ServletContext context=(ServletContext)InitServletContextListener.local.get();
//	 System.out.println(context.getRealPath("/WEB-INF/templates/html")+"/top.html");
	   //System.out.println(request.getContextPath()+"/WEB-INF/templates/html/top.html");
	   //System.out.println(request.getSession().getServletContext().getRealPath("/WEB-INF/templates/html/"));
	 FreemarkerUtil.getInstance().fprint("top.ftl",root, servletContext.getRealPath(SystemContext.FTL_HTMLPATH)+"/top.html");	
	   //FreemarkerUtil.getInstance().print("top.ftl",root);
	 System.out.println("重新生成了Top缓存");
		
	 Map<String,Object> root1=new HashMap<String,Object>();
		String propName1="position";
		Object propertyValue1=Position.MIDDLE;
		List<Channel> channels=channelService.findTopByProperty(propName1, propertyValue1);
		root1.put("ctx", "");
		root1.put("channels", channels);
		
		FreemarkerUtil.getInstance().fprint("nav.ftl",root1, servletContext.getRealPath(SystemContext.FTL_HTMLPATH)+"/nav.html");	
	
		 System.out.println("重新生成了Nav缓存");
		 
		 
			Map<String,Object> root2=new HashMap<String,Object>();	
			int pagesum=1;
		    PageBean newShops=goodsService.findNewSHOP(pagesum);
		    PageBean hotShops=goodsService.findHotSHOP(pagesum);
			root2.put("newShops", newShops);
		    if(hotShops.getRecordList()!=null) 
		        root2.put("hotShops", hotShops);
		    root2.put("ctx", "");
				FreemarkerUtil.getInstance().fprint("content.ftl", root2, servletContext.getRealPath(SystemContext.FTL_HTMLPATH)+"/content.html");
				 System.out.println("重新生成了Content缓存");
				 
				 Map<String,Object> root3=new HashMap<String,Object>();	
					List<FrendLink>	frendLinks=frendLinkService.findAll();
					root3.put("ctx", "");                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                
					root3.put("frendLinks", frendLinks);
					FreemarkerUtil.getInstance().fprint("footer.ftl", root3, servletContext.getRealPath(SystemContext.FTL_HTMLPATH)+"/footer.html");
					 System.out.println("重新生成了Footer缓存");
		
	}



	


	@Override
	public void createLogin()
	{
		//这里应该从后台取设置的注册项 然后生成到页面 表太多就不在创建表了
		Map<String,Object> root=new HashMap<String,Object>();
		FreemarkerUtil.getInstance().fprint("login.ftl", root,servletContext.getRealPath(SystemContext.FTL_HTMLPATH)+"/login.html");
		
		
		
	}



	@Override
	public void setServletContext(ServletContext context)
	{
		this.servletContext=context;
		
	}



	

	
	
	
	
    






	





	




	



	



	


}
