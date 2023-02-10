package com.practice.bean;

public class Account {
	
	String accName;
	String bankName;
	String accType;
	
	public Account(String accName, String bankName, String accType) {
		this.accName= accName;
		this.bankName= bankName;
		this.accType= accType;
	}
	
	public void setAccName(String accName) {
		this.accName= accName;
	}
	public void setBankName(String bankName) {
		this.bankName= bankName;
	}
	public void setAccType(String accType) {
		this.accType= accType;
	}
	
	public String getAccName() {
		return accName;
	}
	public String getBankName() {
		return bankName;
	}
	public String  getAccountType() {
		return accType;
	}

}
