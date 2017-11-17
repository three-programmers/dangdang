package com.jk.util;

public class PageUtil {
	private Integer pageIndex;//页号
	private Integer count;//每页显示条数
	private Integer pageCount;//总页数
	private Integer totalCount;//总记录数
	public Integer getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Integer getPageCount() {
		if(this.totalCount % count == 0){
			pageCount =  totalCount / count;
			return pageCount;
		}else{
			pageCount =  totalCount / count +1;
			return pageCount;
		}
	}
	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}
	public PageUtil(){
		
	}
	public PageUtil(Integer pageIndex,Integer count){
		this.pageIndex = pageIndex;
		this.count = count;
	}
	public PageUtil(Integer pageIndex,Integer count,Integer totalCount){
		this.pageIndex = pageIndex;
		this.count = count;
		this.totalCount = totalCount;
	}
	public  Integer fromRecord(){
		return (pageIndex-1)*count;
	}
}
