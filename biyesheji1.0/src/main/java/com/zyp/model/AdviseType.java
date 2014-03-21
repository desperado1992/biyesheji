package com.zyp.model;

public enum AdviseType implements IEnumConverter{

	 NAV("导航类型", 1), PICTURE("图片类型", 2), VIDEO("视频类型", 3),CONTENT("内容类型", 4);  
	 private String text;  
	    private Integer value;  
	  
	    private AdviseType(String text, Integer value) {  
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
	    public static AdviseType getByOrdinal(Integer ordinal) {  
	        if (null != ordinal) {  
	            for (AdviseType t : AdviseType.values()) {  
	                if (t.ordinal() == ordinal) {  
	                    return t;  
	                }  
	            }  
	        }  
	        return null;  
	    }  
}
