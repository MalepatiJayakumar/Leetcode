package com.practice.controller;

public class UserManager {
	private User user;
	
	public UserManager(User user) {
		this.user = user;
	}
	
	public User getUser() {
		return user;
	}

	@Override
	public String toString() {
		return "UserManager [user=" + user + "]";
	}
}