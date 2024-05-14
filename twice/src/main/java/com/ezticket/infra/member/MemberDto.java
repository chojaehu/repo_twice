package com.ezticket.infra.member;

import java.util.Date;
import org.springframework.web.multipart.MultipartFile;

import com.ezticket.infra.Base.BaseDto;

public class MemberDto extends BaseDto {

	private String mbSeq;
	private String mbName;
	
	private String mbEmail;
	
	private String mbPassword;
	private String mbnewPassword;
	private String mbPasswordCheck;
	
	private String mbgender;
	private String mbPhone;
	private String mbDateBirth;
	private Date mbRgstrDate;
	private Date mbModifiedDate;
	private Integer mbdelectNY;
	private String mbpostalCode;
	private String mbrdnmAdres;
	private String mbaddress;
	private String mbdetailAddress;
	private String mbseeAlso;
	private String mblongitude;
	private String mblatitude;
	
	private MultipartFile[] uploadflies;
	
	
	//mbpostalCode, mbrdnmAdres, mbaddress, mbdetailAddress, mbseeAlso, mblongitude, mblatitude
	
	
	
	public String getMbnewPassword() {
		return mbnewPassword;
	}
	public MultipartFile[] getUploadflies() {
		return uploadflies;
	}
	public void setUploadflies(MultipartFile[] uploadflies) {
		this.uploadflies = uploadflies;
	}
	public String getMbpostalCode() {
		return mbpostalCode;
	}
	public void setMbpostalCode(String mbpostalCode) {
		this.mbpostalCode = mbpostalCode;
	}
	public String getMbrdnmAdres() {
		return mbrdnmAdres;
	}
	public void setMbrdnmAdres(String mbrdnmAdres) {
		this.mbrdnmAdres = mbrdnmAdres;
	}
	public String getMbaddress() {
		return mbaddress;
	}
	public void setMbaddress(String mbaddress) {
		this.mbaddress = mbaddress;
	}
	public String getMbdetailAddress() {
		return mbdetailAddress;
	}
	public void setMbdetailAddress(String mbdetailAddress) {
		this.mbdetailAddress = mbdetailAddress;
	}
	public String getMbseeAlso() {
		return mbseeAlso;
	}
	public void setMbseeAlso(String mbseeAlso) {
		this.mbseeAlso = mbseeAlso;
	}
	public String getMblongitude() {
		return mblongitude;
	}
	public void setMblongitude(String mblongitude) {
		this.mblongitude = mblongitude;
	}
	public String getMblatitude() {
		return mblatitude;
	}
	public void setMblatitude(String mblatitude) {
		this.mblatitude = mblatitude;
	}
	public void setMbnewPassword(String mbnewPassword) {
		this.mbnewPassword = mbnewPassword;
	}
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
	public Integer getMbdelectNY() {
		return mbdelectNY;
	}
	public void setMbdelectNY(Integer mbdelectNY) {
		this.mbdelectNY = mbdelectNY;
	}
	
	
	
}
