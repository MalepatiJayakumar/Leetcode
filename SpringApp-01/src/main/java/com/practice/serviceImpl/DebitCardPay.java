package com.practice.serviceImpl;

import com.practice.service.ICardPay;

public class DebitCardPay implements ICardPay {

	public DebitCardPay() {
		System.out.println("DebitCardPay object has been instantiated");
	}
	
	public boolean doPayment(Double billAmount) {
		System.out.println("Inside doPayment in DebitCardPay");
		if(billAmount <= 500) {
			return true;
		}
		return false;
	}

}
