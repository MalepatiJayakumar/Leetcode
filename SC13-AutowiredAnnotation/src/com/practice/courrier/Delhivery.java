package com.practice.courrier;

public class Delhivery implements Courrier {

	@Override
	public String doDelivery(String item) {
		System.out.println("Delhivery.doDelivery()");
		return "success";
	}

}
