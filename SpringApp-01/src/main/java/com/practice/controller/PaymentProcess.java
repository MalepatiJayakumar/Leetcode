package com.practice.controller;

import com.practice.service.ICardPay;

public class PaymentProcess {
	
	private ICardPay iCardPay;
	
	public PaymentProcess(ICardPay iCardPay) {
		this.iCardPay = iCardPay;
	}
	
	public void setICardPay(ICardPay iCardPay) {
		this.iCardPay = iCardPay;
	}
	
	public void doPayment(Double billAmount) {
		boolean isPaymentDone = iCardPay.doPayment(billAmount);
		if(isPaymentDone) {
			System.out.println("Payment has been completed , thank you for visiting");
		}else {
			System.out.println("Payment failed ,please try again");
		}
	}
	
}
