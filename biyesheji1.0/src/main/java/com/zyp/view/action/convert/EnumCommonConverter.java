package com.zyp.view.action.convert;

import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

import com.zyp.model.IEnumConverter;
import com.zyp.model.Position;
@SuppressWarnings("rawtypes")

public class EnumCommonConverter extends StrutsTypeConverter {

	@Override
	@SuppressWarnings("unchecked")
	public Object convertFromString( Map context, String[] values, Class clazz) {
		 String str = values[0];  
	        if (str != null && !"".equals(str)) {  
	            try {  
	             
					IEnumConverter[] enums = (IEnumConverter[]) clazz.getMethod("values").invoke(null);// 调用枚举的values方法  
	                if (null != enums && enums.length > 0) {  
	                    for (IEnumConverter e : enums) {  
	                        if (str.equals(e.getValue().toString())) {  
	                            return e;  
	                        }  
	                    }  
	                }  
	            } catch (Exception e) {  
	                e.printStackTrace();  
	            }  
	        }  
	        return null; 
	}

	@Override
	public String convertToString(Map context, Object o) {
		  return null != o && o instanceof IEnumConverter ? ((IEnumConverter) o).getText() : "";  
	}
	
	  public static void main(String[] args) {  
	        Object obj = new EnumCommonConverter().convertFromString(null, new String[] { "1" }, Position.class);  
	        System.out.println(obj);  
	  
	    }  

}
