package com.ezticket.infra.code;

public class CodeVo {
	private Integer shDelNy = 0; 								/* null 값을 받아야 되는 경우가 있어서 int 대신 Integer 사용 */
	private Integer shOptionDate = 1;							/* null 값을 받아야 되는 경우가 있어서 int 대신 Integer 사용 */
	private String shDateStart;
	private String shDateEnd;
	private Integer shOption;									/* null 값을 받아야 되는 경우가 있어서 int 대신 Integer 사용 */
	private String shValue;
	
	
	private int page ;
	private int recordSize ;
	private int pageSize ;
	private String keyword;       
	private String searchType;
	private Pagination pagination;
	
	public CodeVo() {
		this.page = 3;
		this.recordSize = 5;
        this.pageSize = 10;
	}
	
	public Integer getShDelNy() {
		return shDelNy;
	}


	public void setShDelNy(Integer shDelNy) {
		this.shDelNy = shDelNy;
	}


	public Integer getShOptionDate() {
		return shOptionDate;
	}


	public void setShOptionDate(Integer shOptionDate) {
		this.shOptionDate = shOptionDate;
	}


	public String getShDateStart() {
		return shDateStart;
	}


	public void setShDateStart(String shDateStart) {
		this.shDateStart = shDateStart;
	}


	public String getShDateEnd() {
		return shDateEnd;
	}


	public void setShDateEnd(String shDateEnd) {
		this.shDateEnd = shDateEnd;
	}


	public Integer getShOption() {
		return shOption;
	}


	public void setShOption(Integer shOption) {
		this.shOption = shOption;
	}


	public String getShValue() {
		return shValue;
	}


	public void setShValue(String shValue) {
		this.shValue = shValue;
	}


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
