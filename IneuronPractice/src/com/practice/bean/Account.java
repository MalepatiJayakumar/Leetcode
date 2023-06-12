package com.practice.bean;

import java.io.Serializable;

public class Account implements Serializable{
	private String userName;
	private transient String password;
	private String email;
	
	public Account(String userName , String password , String email) {
		this.userName = userName;
		this.password = password;
		this.email    = email;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "Account [userName=" + userName + ", password=" + password + ", email=" + email + "]";
	}
}