package com.practice.serviceImpl;

import com.practice.service.ICard;

public class CreditCard implements ICard {

	@Override
	public Boolean doPaymentProcess(Double billAmount) {
		System.out.println("Processing payment of "+billAmount+" using credit card");
		return Boolean.TRUE;
	}

}
