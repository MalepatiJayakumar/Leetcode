package com.practice.service;

import java.util.Random;

public class Flipkart {
	
	private Float discount;
	private Courier courier;
	
	static {
		System.out.println("Flipkart.class is loading...");
	}
	
	public Flipkart() {
		System.out.println("Flipkart object is being instantiated...");
	}
	
	public Float getDiscount() {
		return discount;
	}
	public void setDiscount(Float discount) {
		this.discount = discount;
	}
	public void setCourier(Courier courier) {
		this.courier = courier;
	}
	
	public String doShopping(String[] items , Float[] prices) {
		//Business logic
		System.out.println("Flipkart.doShopping() :: has been called >> for courier :: "+courier.getClass().getName());
		
		Float total = 0.0f;
		for(Float price : prices) {
			total+=price;
		}
		Integer orderId = new Random().nextInt(1000);
		courier.doShipping(orderId,items);
		return "Flipkart has intiated Delhivery for your product with Order id :: "+orderId;
	}
	
}