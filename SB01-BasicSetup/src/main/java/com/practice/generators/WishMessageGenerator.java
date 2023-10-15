package com.practice.generators;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WishMessageGenerator {
	
	@Autowired
	private LocalDateTime localDateTime;
	
	static {
		System.out.println("WishMessageGenerator.class file is being loaded");
	}
	public WishMessageGenerator() {
		System.out.println("WishMessageGenerator object has been instantiated");
	}
	
	public String generateWishMessage(String name) {
		String msg = null;
		Integer hour = localDateTime.getHour();
		if(hour < 11) {
			msg = "Good morning "+name;
		}else if(hour < 15) {
			msg = "Good afternoon "+name;
		}else if(hour < 18) {
			msg = "Good evening "+name;
		}else {
			msg = "Good night "+name;
		}
		return msg;
	}
	
	@Override
	public String toString() {
		return "WishMessageGenerator [date=" + localDateTime + "]";
	}
	
}