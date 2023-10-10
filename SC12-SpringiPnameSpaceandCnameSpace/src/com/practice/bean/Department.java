package com.practice.bean;

import java.util.Date;

public class Department {
	private Integer dNo;
	private String dName;
	private Date startDate;

	public Department(Integer dNo, String dName, Date startDate) {
		super();
		this.dNo = dNo;
		this.dName = dName;
		this.startDate = startDate;
	}

	public Integer getdNo() {
		return dNo;
	}

	public void setdNo(Integer dNo) {
		this.dNo = dNo;
	}

	public String getdName() {
		return dName;
	}

	public void setdName(String dName) {
		this.dName = dName;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Override
	public String toString() {
		return "Department [dNo=" + dNo + ", dName=" + dName + ", startDate=" + startDate + "]";
	}
}