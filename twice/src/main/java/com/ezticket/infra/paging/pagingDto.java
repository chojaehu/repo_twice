package com.ezticket.infra.paging;

import com.ezticket.infra.code.Pagination;

public class pagingDto {
	
	private int page = 1;
	private int recordSize = 5;
	private int pageSize = 10;
	private String keyword;       
	private String searchType;
	private Pagination pagination;
	
	
	

	public int getPage() {
		return page;
	}




	public void setPage(int page) {
		this.page = page;
	}




	public int getRecordSize() {
		return recordSize;
	}




	public void setRecordSize(int recordSize) {
		this.recordSize = recordSize;
	}




	public int getPageSize() {
		return pageSize;
	}




	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}




	public String getKeyword() {
		return keyword;
	}




	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}




	public String getSearchType() {
		return searchType;
	}




	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}




	public Pagination getPagination() {
		return pagination;
	}




	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}




	public int getOffset() {
		return (page-1)* recordSize;
	}
}
