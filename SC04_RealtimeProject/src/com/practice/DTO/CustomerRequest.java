package com.practice.DTO;

public class CustomerRequest {
	private String id;
	private String name;
	private String pAmt;
	private String period;
	private String intrestPercent;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getpAmt() {
		return pAmt;
	}
	public void setpAmt(String pAmt) {
		this.pAmt = pAmt;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public String getIntrestPercent() {
		return intrestPercent;
	}
	public void setIntrestPercent(String intrestPercent) {
		this.intrestPercent = intrestPercent;
	}
	@Override
	public String toString() {
		return "CustomerRequest [id=" + id + ", name=" + name + ", pAmt=" + pAmt + ", period=" + period
				+ ", intrestPercent=" + intrestPercent + "]";
	}
}