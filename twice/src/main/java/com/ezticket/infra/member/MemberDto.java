package com.ezticket.infra.member;

import java.util.Date;

public class MemberDto {

	private String mbSeq;
	private String mbName;
	private String mbEmail;
	private String mbEmailchek;
	private String mbPassword;
	private String mbPasswordCheck;
	private String mbgender;
	private String mbPhone;
	private Date mbDateBirth;
	private Date mbRgstrDate;
	private Date mbModifiedDate;
	private Integer mbdelectNY;
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
	public String getMbEmailchek() {
		return mbEmailchek;
	}
	public void setMbEmailchek(String mbEmailchek) {
		this.mbEmailchek = mbEmailchek;
	}
	public String getMbPassword() {
		return mbPassword;
	}
	public void setMbPassword(String mbPassword) {
		this.mbPassword = mbPassword;
	}
	public String getMbPasswordCheck() {
		return mbPasswordCheck;
	}
	public void setMbPasswordCheck(String mbPasswordCheck) {
		this.mbPasswordCheck = mbPasswordCheck;
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
	public Date getMbDateBirth() {
		return mbDateBirth;
	}
	public void setMbDateBirth(Date mbDateBirth) {
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
	public Integer getMbdelectNY() {
		return mbdelectNY;
	}
	public void setMbdelectNY(Integer mbdelectNY) {
		this.mbdelectNY = mbdelectNY;
	}
	
	
	
}
