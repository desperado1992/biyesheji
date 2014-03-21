package com.zyp.util;

import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;




/**
 * 这个工具类读取默认配置文件
 * @author zhuyuping2012-12-19上午12:25:58
 *
 */

public class PropertyUtil {

	/**
	 * @param args
	 */
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		PropertyUtil  test01 = new PropertyUtil();
		System.out.println(test01.getProperty("pageSize"));
	}

	
	/*
	 * 获取属性文件的值
	 */
	private static final Logger logger = Logger.getLogger(PropertyUtil.class);
	private static Properties properties;
	static {
		// 加载属性文件
			try {
				InputStream inputStream = PropertyUtil.class.getClassLoader().getResourceAsStream("default.properties");
				try {
					properties=new Properties();
					properties.load(inputStream);
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					inputStream.close();
				}
			} catch (Exception e) {
				logger.error(e.getMessage());
			}
	}

	public static String getProperty(String key) {
		return properties.getProperty(key);
	}
	
	
	
}