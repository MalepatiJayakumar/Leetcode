package com.practice.courrier;

public class DTDC implements Courrier {

	@Override
	public String doDelivery(String item) {
		System.out.println("DTDC.doDelivery()");
		return "success";
	}
}