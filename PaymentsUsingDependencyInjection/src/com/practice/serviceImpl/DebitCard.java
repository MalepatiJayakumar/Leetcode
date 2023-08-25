package com.practice.serviceImpl;

import com.practice.service.ICard;

public class DebitCard implements ICard {

	@Override
	public Boolean doPaymentProcess(Double billAmount) {
		System.out.println("Processing payment of "+billAmount+" using debit card");
		return Boolean.TRUE;
	}

}
