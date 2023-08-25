package com.practice.main;

import com.practice.service.ICard;
import com.practice.serviceImpl.CreditCard;

public class ProcessPayment {
	
	/* field Injection */
//	private ICard icard = new CreditCard();

	private ICard iCard = null;
	/* Constructor Injection */
	public ProcessPayment(ICard iCard) {
		this.iCard = iCard;
	}
	/* Setter Injection */
	public void setCard(ICard iCard) {
		this.iCard = iCard;
	}
	
	public Boolean processPayment(Double billAmount) {
		return iCard.doPaymentProcess(billAmount);
	}
	
}
