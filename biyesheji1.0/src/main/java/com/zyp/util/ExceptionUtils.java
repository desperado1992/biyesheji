package com.zyp.util;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

public class ExceptionUtils
{
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(ExceptionUtils.class);
	
	

		

		/**
		 * 返回错误信息字符串
		 * 
		 * @param ex
		 *            Exception
		 * @return 错误信息字符串
		 */
		public static String getExceptionMessage(Exception ex) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			ex.printStackTrace(pw);
			String errorMessage = sw.toString();
			pw.close();
			try {
				sw.close();
			} catch (IOException e) {
				logger.error(e);
			}
			return errorMessage;
		}

	
}
