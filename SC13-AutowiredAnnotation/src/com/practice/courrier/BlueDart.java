package com.practice.courrier;

public class BlueDart implements Courrier {

	@Override
	public String doDelivery(String item) {
		System.out.println("BlueDart.doDelivery()");
		return "success";
	}

}
