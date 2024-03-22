package com.ezticket.infra.performance;

import java.util.Date;

public class PerformanceDto {
	
	private Integer prSeq;
	private String prTitle;
	
	private Date prStartDate;
	private Date prEndDate;
	
	private String prHostedPlanned;
	private Integer prAgeLimit;
	private Integer prAttenDance;
	private String prDetails;
	private Date prRgstrDate;
	private Date prModifiedDate;
	private Integer prdeleteNY;
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
}
