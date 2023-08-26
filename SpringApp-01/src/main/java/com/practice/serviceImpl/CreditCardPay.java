package com.practice.serviceImpl;

import com.practice.service.ICardPay;

public class CreditCardPay implements ICardPay {

	public CreditCardPay() {
		System.out.println("CreditCardPay object has been instantiated");
	}
	
	public boolean doPayment(Double billAmount) {
		System.out.println("Inside doPayment in CreditCardPay");
		if(billAmount <= 1000) {
			return true;
		}
		return false;
	}

}
