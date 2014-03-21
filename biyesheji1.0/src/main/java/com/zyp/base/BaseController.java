package com.zyp.base;


import java.io.File;
import java.io.IOException;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
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
import com.zyp.service.FreemarkerService;
import com.zyp.service.FrendLinkService;
import com.zyp.service.GoodsService;
import com.zyp.service.PayService;
import com.zyp.service.PrivilegeService;
import com.zyp.service.RoleService;
import com.zyp.service.SettingService;
import com.zyp.service.ShopcategoryService;
import com.zyp.service.SpecificationService;
import com.zyp.service.ThirdVelocityEmailService;
import com.zyp.service.UserService;
import com.zyp.util.DirectoryFilter;


public class BaseController {

	
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
	protected FreemarkerService freemarkerService;
	/**
	 * 将对象转换成JSON字符串，并响应回前台
	 * 
	 * @param object
	 * @throws IOException
	 */
	public void writeJson(Object object,HttpServletResponse response) {
		try {
			// SerializeConfig serializeConfig = new SerializeConfig();
			// serializeConfig.setAsmEnable(false);
			// String json = JSON.toJSONString(object);
			// String json = JSON.toJSONString(object, serializeConfig, SerializerFeature.PrettyFormat);
			String json = JSON.toJSONStringWithDateFormat(object, "yyyy-MM-dd HH:mm:ss");
			// String json = JSON.toJSONStringWithDateFormat(object, "yyyy-MM-dd HH:mm:ss", SerializerFeature.PrettyFormat);
			response.setContentType("text/html;charset=utf-8");
			
			response.getWriter().write(json);
			response.getWriter().flush();
			response.getWriter().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	protected void delOldHtml(String htmlDir,String htmlName){  
        File path = new File(htmlDir);  
        String[] indexfileList = path.list(new DirectoryFilter(htmlName));  
        if(indexfileList.length>=0){  
            for(String f:indexfileList){  
                File delf = new File(htmlDir+"/"+f);  
                delf.delete();  
            }  
        }  
    }  
	
}
