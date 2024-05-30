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
	private MultipartFile excelfile;
	
	//iuSeq, iuType, iuDefaultNy, iuSort, iuPath, iuOriginalName, iuUuidName, iuExt, iuSize, iuDelNy, pseq, iuRegDateTime
	
	private Integer iuSeq;
	private Integer iuType;
	private Integer iuDefaultNy;
	private Integer iuSort;
	private String iuPath;
	private String iuOriginalName;
	private String iuUuidName;
	private String iuExt;
	private Integer iuSize;
	private Integer iuDelNy;
	private Integer psseq;
	private Date iuRegDateTime;
	
	

	
	
	
	
	public MultipartFile getExcelfile() {
		return excelfile;
	}
	public void setExcelfile(MultipartFile excelfile) {
		this.excelfile = excelfile;
	}
	public Integer getIuSeq() {
		return iuSeq;
	}
	public void setIuSeq(Integer iuSeq) {
		this.iuSeq = iuSeq;
	}
	public Integer getIuType() {
		return iuType;
	}
	public void setIuType(Integer iuType) {
		this.iuType = iuType;
	}
	public Integer getIuDefaultNy() {
		return iuDefaultNy;
	}
	public void setIuDefaultNy(Integer iuDefaultNy) {
		this.iuDefaultNy = iuDefaultNy;
	}
	public Integer getIuSort() {
		return iuSort;
	}
	public void setIuSort(Integer iuSort) {
		this.iuSort = iuSort;
	}
	public String getIuPath() {
		return iuPath;
	}
	public void setIuPath(String iuPath) {
		this.iuPath = iuPath;
	}
	public String getIuOriginalName() {
		return iuOriginalName;
	}
	public void setIuOriginalName(String iuOriginalName) {
		this.iuOriginalName = iuOriginalName;
	}
	public String getIuUuidName() {
		return iuUuidName;
	}
	public void setIuUuidName(String iuUuidName) {
		this.iuUuidName = iuUuidName;
	}
	public String getIuExt() {
		return iuExt;
	}
	public void setIuExt(String iuExt) {
		this.iuExt = iuExt;
	}
	public Integer getIuSize() {
		return iuSize;
	}
	public void setIuSize(Integer iuSize) {
		this.iuSize = iuSize;
	}
	public Integer getIuDelNy() {
		return iuDelNy;
	}
	public void setIuDelNy(Integer iuDelNy) {
		this.iuDelNy = iuDelNy;
	}
	public Integer getPsseq() {
		return psseq;
	}
	public void setPsseq(Integer psseq) {
		this.psseq = psseq;
	}
	public Date getIuRegDateTime() {
		return iuRegDateTime;
	}
	public void setIuRegDateTime(Date iuRegDateTime) {
		this.iuRegDateTime = iuRegDateTime;
	}
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
