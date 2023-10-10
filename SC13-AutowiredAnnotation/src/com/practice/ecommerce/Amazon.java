package com.practice.ecommerce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.practice.courrier.Courrier;

public class Amazon {

	@Autowired
	@Qualifier("delhivery") // we don't need to provide qualifier name if variable name is matching with
							// bean name to map. As here we have courrier and delhivery so we are using @Qualifier
	private Courrier courrier;

	public Amazon() {
		System.out.println("Amazon.Amazon()");
	}

	public Courrier getCourrier() {
		return courrier;
	}

	public void setCourrier(Courrier courrier) {
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