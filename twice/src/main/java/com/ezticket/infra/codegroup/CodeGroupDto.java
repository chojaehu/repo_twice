package com.ezticket.infra.codegroup;

import java.util.Date;

public class CodeGroupDto {
	
	private String ifcgSeq;
	private String ifcgName;
	private Date ifcgRgstrDate;
	private Date ifcgModifiedDate;
	private Integer ifcgdeleteNY;


	private Integer xCount;


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


	public Date getIfcgRgstrDate() {
		return ifcgRgstrDate;
	}


	public void setIfcgRgstrDate(Date ifcgRgstrDate) {
		this.ifcgRgstrDate = ifcgRgstrDate;
	}


	public Date getIfcgModifiedDate() {
		return ifcgModifiedDate;
	}


	public void setIfcgModifiedDate(Date ifcgModifiedDate) {
		this.ifcgModifiedDate = ifcgModifiedDate;
	}


	public Integer getIfcgdeleteNY() {
		return ifcgdeleteNY;
	}


	public void setIfcgdeleteNY(Integer ifcgdeleteNY) {
		this.ifcgdeleteNY = ifcgdeleteNY;
	}


	public Integer getxCount() {
		return xCount;
	}


	public void setxCount(Integer xCount) {
		this.xCount = xCount;
	}

	
	

}
