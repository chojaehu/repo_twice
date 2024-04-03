package com.ezticket.infra.performance;

import java.util.Date;

public class PerformanceDto {
	
	private Integer prSeq;
	private String prTitle;
	private String prperformanceType;
	private String prViewingTime;
	private Date prStartDate;
	private Date prEndDate;
	
	private String prHostedPlanned;
	private Integer prAgeLimit;
	private Integer prAttenDance;
	private String prDetails;
	private Date prRgstrDate;
	private Date prModifiedDate;
	private Integer prdeleteNY;
	
	// 공연장소 
	private String plplace;
	private Integer plSeq;
	
	//공연관 
	private Integer taSeq;
	private String tatheaterNumber;
	
	// 공연 시간/날짜
	private Integer pdSeq;
	private String pdselectionDate;
	private String pdselectionTime;
	
	//좌석정보
	private Integer stSeq;
	private String stSeatCode;
	private String stSeatNumber;

	//티켓정보
	private Integer pmSeq;
	private String pmTicketCode;
	
	//출연진 정보
	private String cmName;
	
	
	//댓글 정보
	private String rvSeq;
	private String rvWriter;
	private String rvRvwCntnt;
	private String rvGpa;
	private Date rvRgstrDate;
	
	
	// 답글 정보
	private String rpSeq;
	private String rpWriter;
	private String rpRvwCntnt;
	private Date rpRgstrDate;
	
	
	public Integer getPrSeq() {
		return prSeq;
	}
	public void setPrSeq(Integer prSeq) {
		this.prSeq = prSeq;
	}
	public String getPrTitle() {
		return prTitle;
	}
	public void setPrTitle(String prTitle) {
		this.prTitle = prTitle;
	}
	public String getPrperformanceType() {
		return prperformanceType;
	}
	public void setPrperformanceType(String prperformanceType) {
		this.prperformanceType = prperformanceType;
	}
	public String getPrViewingTime() {
		return prViewingTime;
	}
	public void setPrViewingTime(String prViewingTime) {
		this.prViewingTime = prViewingTime;
	}
	public Date getPrStartDate() {
		return prStartDate;
	}
	public void setPrStartDate(Date prStartDate) {
		this.prStartDate = prStartDate;
	}
	public Date getPrEndDate() {
		return prEndDate;
	}
	public void setPrEndDate(Date prEndDate) {
		this.prEndDate = prEndDate;
	}
	public String getPrHostedPlanned() {
		return prHostedPlanned;
	}
	public void setPrHostedPlanned(String prHostedPlanned) {
		this.prHostedPlanned = prHostedPlanned;
	}
	public Integer getPrAgeLimit() {
		return prAgeLimit;
	}
	public void setPrAgeLimit(Integer prAgeLimit) {
		this.prAgeLimit = prAgeLimit;
	}
	public Integer getPrAttenDance() {
		return prAttenDance;
	}
	public void setPrAttenDance(Integer prAttenDance) {
		this.prAttenDance = prAttenDance;
	}
	public String getPrDetails() {
		return prDetails;
	}
	public void setPrDetails(String prDetails) {
		this.prDetails = prDetails;
	}
	public Date getPrRgstrDate() {
		return prRgstrDate;
	}
	public void setPrRgstrDate(Date prRgstrDate) {
		this.prRgstrDate = prRgstrDate;
	}
	public Date getPrModifiedDate() {
		return prModifiedDate;
	}
	public void setPrModifiedDate(Date prModifiedDate) {
		this.prModifiedDate = prModifiedDate;
	}
	public Integer getPrdeleteNY() {
		return prdeleteNY;
	}
	public void setPrdeleteNY(Integer prdeleteNY) {
		this.prdeleteNY = prdeleteNY;
	}
	public String getPlplace() {
		return plplace;
	}
	public void setPlplace(String plplace) {
		this.plplace = plplace;
	}
	public Integer getPlSeq() {
		return plSeq;
	}
	public void setPlSeq(Integer plSeq) {
		this.plSeq = plSeq;
	}
	public Integer getTaSeq() {
		return taSeq;
	}
	public void setTaSeq(Integer taSeq) {
		this.taSeq = taSeq;
	}
	public String getTatheaterNumber() {
		return tatheaterNumber;
	}
	public void setTatheaterNumber(String tatheaterNumber) {
		this.tatheaterNumber = tatheaterNumber;
	}
	public Integer getPdSeq() {
		return pdSeq;
	}
	public void setPdSeq(Integer pdSeq) {
		this.pdSeq = pdSeq;
	}
	public String getPdselectionDate() {
		return pdselectionDate;
	}
	public void setPdselectionDate(String pdselectionDate) {
		this.pdselectionDate = pdselectionDate;
	}
	public String getPdselectionTime() {
		return pdselectionTime;
	}
	public void setPdselectionTime(String pdselectionTime) {
		this.pdselectionTime = pdselectionTime;
	}
	public Integer getStSeq() {
		return stSeq;
	}
	public void setStSeq(Integer stSeq) {
		this.stSeq = stSeq;
	}
	public String getStSeatCode() {
		return stSeatCode;
	}
	public void setStSeatCode(String stSeatCode) {
		this.stSeatCode = stSeatCode;
	}
	public String getStSeatNumber() {
		return stSeatNumber;
	}
	public void setStSeatNumber(String stSeatNumber) {
		this.stSeatNumber = stSeatNumber;
	}
	public Integer getPmSeq() {
		return pmSeq;
	}
	public void setPmSeq(Integer pmSeq) {
		this.pmSeq = pmSeq;
	}
	public String getPmTicketCode() {
		return pmTicketCode;
	}
	public void setPmTicketCode(String pmTicketCode) {
		this.pmTicketCode = pmTicketCode;
	}
	public String getCmName() {
		return cmName;
	}
	public void setCmName(String cmName) {
		this.cmName = cmName;
	}
	public String getRvSeq() {
		return rvSeq;
	}
	public void setRvSeq(String rvSeq) {
		this.rvSeq = rvSeq;
	}
	public String getRvWriter() {
		return rvWriter;
	}
	public void setRvWriter(String rvWriter) {
		this.rvWriter = rvWriter;
	}
	public String getRvRvwCntnt() {
		return rvRvwCntnt;
	}
	public void setRvRvwCntnt(String rvRvwCntnt) {
		this.rvRvwCntnt = rvRvwCntnt;
	}
	public String getRvGpa() {
		return rvGpa;
	}
	public void setRvGpa(String rvGpa) {
		this.rvGpa = rvGpa;
	}
	public Date getRvRgstrDate() {
		return rvRgstrDate;
	}
	public void setRvRgstrDate(Date rvRgstrDate) {
		this.rvRgstrDate = rvRgstrDate;
	}
	public String getRpSeq() {
		return rpSeq;
	}
	public void setRpSeq(String rpSeq) {
		this.rpSeq = rpSeq;
	}
	public String getRpWriter() {
		return rpWriter;
	}
	public void setRpWriter(String rpWriter) {
		this.rpWriter = rpWriter;
	}
	public String getRpRvwCntnt() {
		return rpRvwCntnt;
	}
	public void setRpRvwCntnt(String rpRvwCntnt) {
		this.rpRvwCntnt = rpRvwCntnt;
	}
	public Date getRpRgstrDate() {
		return rpRgstrDate;
	}
	public void setRpRgstrDate(Date rpRgstrDate) {
		this.rpRgstrDate = rpRgstrDate;
	}
	
}
