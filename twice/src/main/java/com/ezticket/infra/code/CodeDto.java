package com.ezticket.infra.code;

import java.util.Date;

public class CodeDto {
	
	
	
	private String groupnumber;
	private String groupname;
	
	private String number;
	private String name;
	private Date regDate;
	private Date mdfcnDate;
	private Integer deleteNY;
	private String codegroup_number;
	

	
	public String getGroupnumber() {
		return groupnumber;
	}
	public void setGroupnumber(String groupnumber) {
		this.groupnumber = groupnumber;
	}
	public String getGroupname() {
		return groupname;
	}
	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}
	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public void setDeleteNY(Integer delectNY) {
		this.deleteNY = delectNY;
	}
	public String getCodegroup_number() {
		return codegroup_number;
	}
	public void setCodegroup_number(String codegroup_number) {
		this.codegroup_number = codegroup_number;
	}
	
	
	

}
