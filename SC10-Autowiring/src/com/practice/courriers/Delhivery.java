package com.practice.courriers;

public class Delhivery implements Courrier {

	static {
		System.out.println("Delhivery .class is being loaded");
	}
	
	public Delhivery() {
		System.out.println("Delhivery class instance object has been created");
	}
	
	@Override
	public String deliverPackage(String item) {
		System.out.println("Inside deliverPackage in Delhivery >> "+item);
		return "success";
	}
}
