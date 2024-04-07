package com.ezticket.infra.performance;


import com.ezticket.infra.Base.BaseVo;

public class PerformanceVo extends BaseVo{
	
	private String prSeq;
	private String plSeq;
	private String shprDate;
	
	


	public String getShprDate() {
		return shprDate;
	}
	public void setShpreDate(String shprDate) {
		this.shprDate = shprDate;
	}
	public String getPlSeq() {
		return plSeq;
	}
	public void setPlSeq(String plSeq) {
		this.plSeq = plSeq;
	}
	public String getPrSeq() {
		return prSeq;
	}

	public void setPrSeq(String prSeq) {
		this.prSeq = prSeq;
	}

}
