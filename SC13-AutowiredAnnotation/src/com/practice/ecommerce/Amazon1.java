package com.practice.ecommerce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.practice.courrier.Courrier;

public class Amazon1 {
	
	private Courrier courrier;

	public Amazon1() {
		System.out.println("Amazon1.Amazon()");
	}

	public Courrier getCourrier() {
		return courrier;
	}

	@Autowired
	public void setCourrier(@Qualifier("bDart")Courrier courrier) {
		System.out.println("Amazon.setCourrier()");
		this.courrier = courrier;
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