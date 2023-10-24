package com.highradius.service;

public class WishMessageService {
	public String getWishMessage(String user) {
		System.out.println("WishMessageService.getWishMessage()");
		return "Good Morning " + user;
	}
}