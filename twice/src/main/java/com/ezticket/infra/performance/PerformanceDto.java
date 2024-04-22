package com.ezticket.infra.performance;

import java.util.Date;
import java.util.List;

public class PerformanceDto {
	
	
	// 공연 정보
	private Integer prSeq;
	private String prTitle;
	private String prperformanceType;
	private String prViewingTime;
	private String prStartDate;
	private String prEndDate;
	
	private String prHostedPlanned;
	private Integer prAgeLimit;
	private Integer prAttenDance;
	private String prDetails;
	private Date prRgstrDate;
	private Date prModifiedDate;
	private Integer prdeleteNY;
	
	
	//공연 평점
	private Double grade;
	
	//출연진 정보
	private String cmName;
	
	// 공연장소 
	private String plplace;
	private Integer plSeq;
	private Double pllongitude;
	private Double plhardness;
	
	//공연관 
	private Integer taSeq;
	private String tatheaterNumber;
	
	// 공연 시간/날짜
	private Integer pdSeq;
	private String pdselectionDate;
	private String pdselectionTime;
	
	
	//좌석정보
	private Integer stSeq;
	private String stRating;
	private String stSeatCode;
	private String stSeatNumber;
	private String stPrise;
	private String stReservation;
	
	private List<String> seat;
	private Integer seatcount;
	private String totalprice;
	private String mbSeq;

	//티켓정보
	private Integer pmSeq;
	private String pmTicketCode;
	
	//예약 좌석 테이블 
	private String sltSeq;
	
	
	
	//댓글 정보
	private String rvSeq;
	private String rvWriter;
	private String rvRvwCntnt;
	private String rvGpa;
	private Integer score;
	private Date rvRgstrDate;
	
	
	
	
	// 답글 정보
	private String rpSeq;
	private String rpWriter;
	private String rpRvwCntnt;
	private Date rpRgstrDate;
	
	
//	카카오 결제 정보
	private String tid; // 결제 고유 번호
    private String next_redirect_mobile_url; // 모바일 웹일 경우 받는 결제페이지 url
    private String next_redirect_pc_url; // pc 웹일 경우 받는 결제 페이지
    private String created_at; // 결제 준비 요청 시간
    
    
    
    
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public String getNext_redirect_mobile_url() {
		return next_redirect_mobile_url;
	}
	public void setNext_redirect_mobile_url(String next_redirect_mobile_url) {
		this.next_redirect_mobile_url = next_redirect_mobile_url;
	}
	public String getNext_redirect_pc_url() {
		return next_redirect_pc_url;
	}
	public void setNext_redirect_pc_url(String next_redirect_pc_url) {
		this.next_redirect_pc_url = next_redirect_pc_url;
	}
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
	public String getPrStartDate() {
		return prStartDate;
	}
	public void setPrStartDate(String prStartDate) {
		this.prStartDate = prStartDate;
	}
	public String getPrEndDate() {
		return prEndDate;
	}
	public void setPrEndDate(String prEndDate) {
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
	public Double getGrade() {
		return grade;
	}
	public void setGrade(Double grade) {
		this.grade = grade;
	}
	public String getCmName() {
		return cmName;
	}
	public void setCmName(String cmName) {
		this.cmName = cmName;
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
	public Double getPllongitude() {
		return pllongitude;
	}
	public void setPllongitude(Double pllongitude) {
		this.pllongitude = pllongitude;
	}
	public Double getPlhardness() {
		return plhardness;
	}
	public void setPlhardness(Double plhardness) {
		this.plhardness = plhardness;
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
	public String getStRating() {
		return stRating;
	}
	public void setStRating(String stRating) {
		this.stRating = stRating;
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
	public String getStPrise() {
		return stPrise;
	}
	public void setStPrise(String stPrise) {
		this.stPrise = stPrise;
	}
	public String getStReservation() {
		return stReservation;
	}
	public void setStReservation(String stReservation) {
		this.stReservation = stReservation;
	}
	public List<String> getSeat() {
		return seat;
	}
	public void setSeat(List<String> seat) {
		this.seat = seat;
	}
	public Integer getSeatcount() {
		return seatcount;
	}
	public void setSeatcount(Integer seatcount) {
		this.seatcount = seatcount;
	}
	public String getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(String totalprice) {
		this.totalprice = totalprice;
	}
	public String getMbSeq() {
		return mbSeq;
	}
	public void setMbSeq(String mbSeq) {
		this.mbSeq = mbSeq;
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
	public String getSltSeq() {
		return sltSeq;
	}
	public void setSltSeq(String sltSeq) {
		this.sltSeq = sltSeq;
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
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
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
