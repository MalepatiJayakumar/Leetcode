package com.practice.courriers;

public class DTDC implements Courrier {

	static {
		System.out.println("DTDC .class is being loaded");
	}
	
	public DTDC() {
		System.out.println("DTDC class instance object has been created");
	}
	
	@Override
	public String deliverPackage(String item) {
		System.out.println("Inside deliverPackage in DTDC >> "+item);
		return "success";
	}
}