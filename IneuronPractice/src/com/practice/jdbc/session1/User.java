package com.practice.jdbc.session1;

import java.sql.Date;

public class User {
//	user_name,email,dob
	
	private String userName;
	private String email;
	private Date date;
	
	public User(String userName , String email , Date date) {
		this.userName = userName;
		this.email    = email;
		this.date     = date;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
