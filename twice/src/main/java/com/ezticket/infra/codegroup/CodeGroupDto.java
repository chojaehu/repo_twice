package com.ezticket.infra.codegroup;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class CodeGroupDto {
	
	private String ifcgSeq;
	private String ifcgName;
	private Date ifcgRgstrDate;
	private Date ifcgModifiedDate;
	private Integer ifcgdeleteNY;


	private Integer xCount;
	
	private MultipartFile uploadflie;
	
	
	private MultipartFile[] uploadflies;
	
	
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
	public MultipartFile getUploadflie() {
		return uploadflie;
	}
	public void setUploadflie(MultipartFile uploadflie) {
		this.uploadflie = uploadflie;
	}
	public MultipartFile[] getUploadflies() {
		return uploadflies;
	}
	public void setUploadflies(MultipartFile[] uploadflies) {
		this.uploadflies = uploadflies;
	}


	
}
