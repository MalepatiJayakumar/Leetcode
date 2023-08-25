package com.practice.main;

import com.practice.serviceImpl.CreditCard;
import com.practice.serviceImpl.DebitCard;

public class TestApp {
	public static void main(String[] args) {
		/* Payment will be processed from credit card */
		ProcessPayment pp = new ProcessPayment(new CreditCard());
		
		/* As we are overriding the executable class , here the bill Amount will be executed from Debit Card */
		pp.setCard(new DebitCard());
		
		Boolean status = pp.processPayment(5000.00d);
		if(status) {
			System.out.println("Payment has been processed successfully , thank you for visiting..");
		}else {
			System.out.println("Payment failed , please try again");
		}
	}
}