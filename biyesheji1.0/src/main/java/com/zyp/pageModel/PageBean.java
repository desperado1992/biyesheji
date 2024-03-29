package com.zyp.pageModel;

import java.util.List;
@SuppressWarnings("rawtypes")
public class PageBean {
                  

private List recordList		;//本页的数据列表
private int currentPage		;//当前页
private int pageCount		;//总页数
private int pageSize		;//每页显示多少条记录
private int recordCount		;//总记录数
private int beginPageIndex  ;//页码/列表的开始索引（包含）
private int endPageIndex	;//页码列表的结束索引（包含）



public PageBean(List recordList, int currentPage, int pageSize, int recordCount) {
	
	this.recordList = recordList;
	this.currentPage = currentPage;
	this.pageSize = pageSize;
	this.recordCount = recordCount;
	//要计算其他三个属性的值
	 pageCount=(recordCount + pageSize - 1) / pageSize;
	if(pageCount <= 10){
		beginPageIndex = 1;
		endPageIndex = 10;
	}
	else{
		beginPageIndex = currentPage - 4;
		endPageIndex = currentPage + 5;
		if(beginPageIndex < 1){
			beginPageIndex = 1;
			endPageIndex = 10;
		}else if(endPageIndex > pageCount){
			endPageIndex = pageCount;
			beginPageIndex = pageSize - 9;
			
		}
		
		
	}
	
}
public List getRecordList() {
	return recordList;
}
public void setRecordList(List recordList) {
	this.recordList = recordList;
}
public int getCurrentPage() {
	return currentPage;
}
public void setCurrentPage(int currentPage) {
	this.currentPage = currentPage;
}
public int getPageCount() {
	return pageCount;
}
public void setPageCount(int pageCount) {
	this.pageCount = pageCount;
}
public int getPageSize() {
	return pageSize;
}
public void setPageSize(int pageSize) {
	this.pageSize = pageSize;
}
public int getRecordCount() {
	return recordCount;
}
public void setRecordCount(int recordCount) {
	this.recordCount = recordCount;
}
public int getBeginPageIndex() {
	return beginPageIndex;
}
public void setBeginPageIndex(int beginPageIndex) {
	this.beginPageIndex = beginPageIndex;
}
public int getEndPageIndex() {
	return endPageIndex;
}
public void setEndPageIndex(int endPageIndex) {
	this.endPageIndex = endPageIndex;
}
	                        
	
	
	
	
	
	
	
	
	
}
