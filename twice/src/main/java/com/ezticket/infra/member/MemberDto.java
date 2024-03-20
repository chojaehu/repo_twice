package com.ezticket.infra.member;

import java.util.Date;

public class MemberDto {

	private String mbSeq;
	private String mbName;
	private String mbEmail;
	private String mbPassword;
	private String mbgender;
	private String mbPhone;
	private String mbDateBirth;
	private Date mbRgstrDate;
	private Date mbModifiedDate;
	private String delectNY;
	public String getMbSeq() {
		return mbSeq;
	}
	public void setMbSeq(String mbSeq) {
		this.mbSeq = mbSeq;
	}
	public String getMbName() {
		return mbName;
	}
	public void setMbName(String mbName) {
		this.mbName = mbName;
	}
	public String getMbEmail() {
		return mbEmail;
	}
	public void setMbEmail(String mbEmail) {
		this.mbEmail = mbEmail;
	}
	public String getMbPassword() {
		return mbPassword;
	}
	public void setMbPassword(String mbPassword) {
		this.mbPassword = mbPassword;
	}
	public String getMbgender() {
		return mbgender;
	}
	public void setMbgender(String mbgender) {
		this.mbgender = mbgender;
	}
	public String getMbPhone() {
		return mbPhone;
	}
	public void setMbPhone(String mbPhone) {
		this.mbPhone = mbPhone;
	}
	public String getMbDateBirth() {
		return mbDateBirth;
	}
	public void setMbDateBirth(String mbDateBirth) {
		this.mbDateBirth = mbDateBirth;
	}
	public Date getMbRgstrDate() {
		return mbRgstrDate;
	}
	public void setMbRgstrDate(Date mbRgstrDate) {
		this.mbRgstrDate = mbRgstrDate;
	}
	public Date getMbModifiedDate() {
		return mbModifiedDate;
	}
	public void setMbModifiedDate(Date mbModifiedDate) {
		this.mbModifiedDate = mbModifiedDate;
	}
	public String getDelectNY() {
		return delectNY;
	}
	public void setDelectNY(String delectNY) {
		this.delectNY = delectNY;
	}
	
	

}
