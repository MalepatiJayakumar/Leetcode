package com.practice.execution;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value = "wmg")
public class WishMessageGenerator {

	@Autowired(required = false)
	private LocalDateTime date;

	static {
		System.out.println("WishMessageGenerator.class file is being loaded");
	}

	public WishMessageGenerator() {
		System.out.println("WishMessageGenerator object is being instantiated");
	}

	public String generateWishMessage(String userName) {
		int hour = date.getHour();
		String msg = "";
		if (hour <= 11) {
			msg = "Good morning " + userName + " have a nice day";
		} else if (hour <= 15) {
			msg = "Good afternoon " + userName;
		} else if (hour <= 19) {
			msg = "Good evening " + userName + " how was your office today";
		} else {
			msg = "Good night " + userName;
		}
		return msg;
	}
}