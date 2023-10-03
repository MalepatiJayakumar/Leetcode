package com.practice.service;

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
		return "success";
	}
	
}