package com.ezticket.infra.Base;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class BaseDto {
	private Integer iuSeq;
	private Integer iuType;
	private Integer iuDefaultNy;
	private Integer iuSort;

	private String iuOriginalName;
	private String iuUuidName;
	private String iuExt;
	private Integer iuSize;
	private Integer iuDelNy;
	private Integer pseq;
	private Date iuRegDateTime;
	
	
	
	
	

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
	public Integer getPseq() {
		return pseq;
	}
	public void setPseq(Integer pseq) {
		this.pseq = pseq;
	}
	public Date getIuRegDateTime() {
		return iuRegDateTime;
	}
	public void setIuRegDateTime(Date iuRegDateTime) {
		this.iuRegDateTime = iuRegDateTime;
	}
	
	
	
}
