package com.practice.ecommerce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.practice.courrier.Courrier;

public class Amazon2 {

	private Courrier courrier;

	@Autowired
	public Amazon2(@Qualifier("dtdc")Courrier courrier) {
		this.courrier = courrier;
		System.out.println("Amazon1.Amazon()");
	}

	public String doShopping(String item) {
		System.out.println("Courrier is sending through :: " + courrier.getClass().getName());
		return courrier.doDelivery(item);
	}

	@Override
	public String toString() {
		return "Amazon [courrier=" + courrier + "]";
	}

}