package com.zyp.model;

public interface IEnumConverter {
	 /** 
     * 得到序数 
     */  
    Integer getOrdinal();  
  
    /** 
     * 返回此枚举常量的名称，在其枚举声明中对其进行声明 
     */  
    String getName();  
  
    String getText();  
      
    Integer getValue();  
}
