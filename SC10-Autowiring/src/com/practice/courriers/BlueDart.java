package com.practice.courriers;

public class BlueDart implements Courrier {

	static {
		System.out.println("BlueDart .class is being loaded");
	}
	
	public BlueDart() {
		System.out.println("BlueDart class instance object has been created");
	}
	
	@Override
	public String deliverPackage(String item) {
		System.out.println("Inside deliverPackage in BlueDart >> "+item);
		return "success";
	}

}
