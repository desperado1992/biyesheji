package com.zyp.base;



import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.annotation.Resource;






import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.ParentPackage;




import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zyp.cfg.Configuration;

import com.zyp.model.User;


import com.zyp.service.AddressService;
import com.zyp.service.AdvisePositionService;
import com.zyp.service.AdviseService;
import com.zyp.service.AreaService;
import com.zyp.service.BrandService;
import com.zyp.service.CACategoryService;
import com.zyp.service.ChannelArticleService;
import com.zyp.service.ChannelService;
import com.zyp.service.DiscountService;
import com.zyp.service.ExpressService;
import com.zyp.service.ForumService;
import com.zyp.service.FrendLinkService;
import com.zyp.service.GoodsService;
import com.zyp.service.PayService;
import com.zyp.service.PrivilegeService;
import com.zyp.service.ReplyService;
import com.zyp.service.RoleService;
import com.zyp.service.SettingService;
import com.zyp.service.ShopcategoryService;
import com.zyp.service.SpecificationService;
import com.zyp.service.ThirdVelocityEmailService;
import com.zyp.service.TopicService;
import com.zyp.service.UserService;

@ParentPackage("basePackage")

public abstract class BaseAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected int pageNum = 1;
	
	
	@Resource
	protected UserService userService;
	@Resource
	protected PrivilegeService privilegeService;
	@Resource 
	protected ShopcategoryService shopcategoryService;
	@Resource
	protected SettingService settingService;
	@Resource
	protected GoodsService goodsService;
	
	@Resource
	protected BrandService brandService;
	@Resource
	protected SpecificationService specificationService;
	@Resource 
	protected RoleService roleService;
	@Resource 
	protected DiscountService discoutService;
	@Resource
	protected FrendLinkService frendLinkService;
	@Resource
	protected ChannelService channelService;
	@Resource
	protected AreaService areaService;
	@Resource
	protected AddressService addressService;
	@Resource
	protected PayService payService;
	@Resource
	protected ExpressService expressService;
	@Resource
	protected ThirdVelocityEmailService thirdVelocityEmailService;
	@Resource
	protected ChannelArticleService channelArticleService;
	@Resource
	protected AdviseService adviseService;
	@Resource
	protected AdvisePositionService advisePositionService;
	@Resource
	protected CACategoryService caCategoryService;
	@Resource
	protected ForumService forumService;
	@Resource
	protected TopicService topicService;
	@Resource
	protected ReplyService replyService;
	/**
	 * 获得当前用户
	 * @return
	 */
	protected User getCurrentUser(){
		
		return (User) ActionContext.getContext().getSession().get("user");
	}
	/**
	 * 上传文件的方法
	 * @param upload上传的临时文件
	 * @return
	 */
	protected String uploadFile(File upload) {
		SimpleDateFormat sdf=new SimpleDateFormat("/yyyy/MM/dd/");
		String basePath=ServletActionContext.getServletContext().getRealPath("/WEB-INF/"+Configuration.getUploadPath());
		String subPath=sdf.format(new Date());
		File filedir=new File(basePath + subPath);
		if(!filedir.exists()){
			filedir.mkdirs();
		}
		//这里我原本是打算采用md5对文件名加密并且加上时间错的 或者用URL编码 我这里采用UUID
		String path=basePath+subPath+UUID.randomUUID().toString();
		upload.renameTo(new File(path));//记住jdk5才把renameTO功能加强了 以前是没有效果的 貌似是这样的 我也记得不太清楚
		return path;
	}
	protected String uploadFile(File upload,String FileName) {
		SimpleDateFormat sdf=new SimpleDateFormat("/yyyy/MM/dd/");
		String basePath=ServletActionContext.getServletContext().getRealPath("/"+Configuration.getUploadPath());
		String bpath=Configuration.getUploadPath();
		String subPath=sdf.format(new Date());
		File filedir=new File(basePath + subPath);
		if(!filedir.exists()){
			filedir.mkdirs();
		}
		//这里我原本是打算采用md5对文件名加密并且加上时间错的 或者用URL编码 我这里采用UUID
		String path = subPath + UUID.randomUUID().toString()+FileName.substring(FileName.lastIndexOf("."));
		// >> 移动文件
		upload.renameTo(new File(basePath+path)); // 如果目标文件夹不存在，或是目标文件已存在，就会不成功，返回false，但不报错。
		//System.out.println(bpath+subPath + UUID.randomUUID().toString()+FileName.substring(FileName.lastIndexOf(".")));
		return bpath+path;
		
	}
	protected String uploadFileWithType(File upload,String type) {
		SimpleDateFormat sdf=new SimpleDateFormat("/yyyy/MM/dd/");
		String basePath=ServletActionContext.getServletContext().getRealPath("/WEB-INF/"+Configuration.getUploadPath());
		String subPath=sdf.format(new Date());
		File filedir=new File(basePath + subPath);
		if(!filedir.exists()){
			filedir.mkdirs();
		}
		//这里我原本是打算采用md5对文件名加密并且加上时间错的 或者用URL编码 我这里采用UUID
		String path=basePath+subPath+UUID.randomUUID().toString()+"."+type;
		upload.renameTo(new File(path));//记住jdk5才把renameTO功能加强了 以前是没有效果的 貌似是这样的 我也记得不太清楚
		return path;
	}
	
	/**
	 * 这里是处理json的方法
	 * 将对象转换成JSON字符串，并响应回前台
	 * @return
	 */
	protected void writeJson(Object object) {
		try {
			// SerializeConfig serializeConfig = new SerializeConfig();
			// serializeConfig.setAsmEnable(false);
			// String json = JSON.toJSONString(object);
			// String json = JSON.toJSONString(object, serializeConfig, SerializerFeature.PrettyFormat);
			String json = JSON.toJSONStringWithDateFormat(object, "yyyy-MM-dd HH:mm:ss");
			// String json = JSON.toJSONStringWithDateFormat(object, "yyyy-MM-dd HH:mm:ss", SerializerFeature.PrettyFormat);
			ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
			ServletActionContext.getResponse().getWriter().write(json);
			ServletActionContext.getResponse().getWriter().flush();
			ServletActionContext.getResponse().getWriter().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
}
