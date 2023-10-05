package com.practice.DTO;

public class CustomerDTO {

	private String id;
	private String name;
	private Float pAmt;
	private Integer period;
	private Float intrestPercent;
	private Float total;
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
	public Float getpAmt() {
		return pAmt;
	}
	public void setpAmt(Float pAmt) {
		this.pAmt = pAmt;
	}
	public Integer getPeriod() {
		return period;
	}
	public void setPeriod(Integer period) {
		this.period = period;
	}
	public Float getIntrestPercent() {
		return intrestPercent;
	}
	public void setIntrestPercent(Float intrestPercent) {
		this.intrestPercent = intrestPercent;
	}
	public Float getTotal() {
		return total;
	}
	public void setTotal(Float total) {
		this.total = total;
	}
	
	@Override
	public String toString() {
		return "CustomerDTO [id=" + id + ", name=" + name + ", pAmt=" + pAmt + ", period=" + period
				+ ", intrestPercent=" + intrestPercent + ", total=" + total + "]";
	}
	
}