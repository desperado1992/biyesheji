package com.zyp.util;


import java.util.ResourceBundle;

public class ReaderUtils {

		public final static Object initLock = new Object();

		private final static String PROPERTIES_FILE_NAME = "config";

		private static ResourceBundle bundle = null;

		static {
			try {
				if (bundle == null) {
					synchronized (initLock) {
						if (bundle == null)
							bundle = ResourceBundle.getBundle(PROPERTIES_FILE_NAME);
					}
				}
			} catch (Exception e) {
				System.out.println("读取资源文件config.properties失败!");
			}
		}
		public static ResourceBundle getBundle() {
			return bundle;
		}
		public static void setBundle(ResourceBundle bundles) {
			bundle = bundles;
		}
		
		
	
}
