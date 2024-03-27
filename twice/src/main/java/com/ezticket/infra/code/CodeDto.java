package com.ezticket.infra.code;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;



public class CodeDto  {

	private String ifcgSeq;
	private String ifcgName;
	
	private String ifcdSeq;
	private String ifcdName;
	private Date ifcdRgstrDate;
	private Date ifcdModifiedDate;
	private Integer ifcddeleteNY;
	private String codegroupIfcgseq;
	
//	for cache
	public static List<CodeDto> cachedCodeArrayList = new ArrayList<CodeDto>();

	public String getIfcgSeq() {
		return ifcgSeq;
	}

	public void setIfcgSeq(String ifcgSeq) {
		this.ifcgSeq = ifcgSeq;
	}

	public String getIfcgName() {
		return ifcgName;
	}

	public void setIfcgName(String ifcgName) {
		this.ifcgName = ifcgName;
	}

	public String getIfcdSeq() {
		return ifcdSeq;
	}

	public void setIfcdSeq(String ifcdSeq) {
		this.ifcdSeq = ifcdSeq;
	}

	public String getIfcdName() {
		return ifcdName;
	}

	public void setIfcdName(String ifcdName) {
		this.ifcdName = ifcdName;
	}

	public Date getIfcdRgstrDate() {
		return ifcdRgstrDate;
	}

	public void setIfcdRgstrDate(Date ifcdRgstrDate) {
		this.ifcdRgstrDate = ifcdRgstrDate;
	}

	public Date getIfcdModifiedDate() {
		return ifcdModifiedDate;
	}

	public void setIfcdModifiedDate(Date ifcdModifiedDate) {
		this.ifcdModifiedDate = ifcdModifiedDate;
	}

	public Integer getIfcddeleteNY() {
		return ifcddeleteNY;
	}

	public void setIfcddeleteNY(Integer ifcddeleteNY) {
		this.ifcddeleteNY = ifcddeleteNY;
	}

	public String getCodegroupIfcgseq() {
		return codegroupIfcgseq;
	}

	public void setCodegroupIfcgseq(String codegroupIfcgseq) {
		this.codegroupIfcgseq = codegroupIfcgseq;
	}

	public static List<CodeDto> getCachedCodeArrayList() {
		return cachedCodeArrayList;
	}

	public static void setCachedCodeArrayList(List<CodeDto> cachedCodeArrayList) {
		CodeDto.cachedCodeArrayList = cachedCodeArrayList;
	}
	
	



}
