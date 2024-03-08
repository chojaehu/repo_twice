package com.ezticket.infra.codegroup;

import java.util.Date;

public class CodeGroupDto {
	
	private String number;
	private String groupname;
	private Date regDate;
	private Date mdfcnDate;
	private Integer deleteNY;


	private Integer xCount;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getGroupname() {
		return groupname;
	}

	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public Date getMdfcnDate() {
		return mdfcnDate;
	}

	public void setMdfcnDate(Date mdfcnDate) {
		this.mdfcnDate = mdfcnDate;
	}

	public Integer getDeleteNY() {
		return deleteNY;
	}

	public void setDeleteNY(Integer deleteNY) {
		this.deleteNY = deleteNY;
	}

	public Integer getxCount() {
		return xCount;
	}

	public void setxCount(Integer xCount) {
		this.xCount = xCount;
	}
	

}
