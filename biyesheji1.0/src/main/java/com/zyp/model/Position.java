package com.zyp.model;



public enum Position implements IEnumConverter{
	 TOP("顶部", 1), MIDDLE("中间", 2), BOTTOM("底部", 3);  
	 private String text;  
	    private Integer value;  
	  
	    private Position(String text, Integer value) {  
	        this.text = text;  
	        this.value = value;  
	    }  
	  
	    @Override  
	    public String getName() {  
	        return this.name();  
	    }  
	  
	    @Override  
	    public Integer getOrdinal() {  
	        return this.ordinal();  
	    }  
	  
	    @Override  
	    public String getText() {  
	        return text;  
	    }  
	  
	    @Override  
	    public Integer getValue() {  
	        return value;  
	    }  
	  
	    /** 
	     * 根据序数得到枚举 
	     *  
	     * @param ordinal 
	     * @return 
	     */  
	    public static Position getByOrdinal(Integer ordinal) {  
	        if (null != ordinal) {  
	            for (Position t : Position.values()) {  
	                if (t.ordinal() == ordinal) {  
	                    return t;  
	                }  
	            }  
	        }  
	        return null;  
	    }  
}
