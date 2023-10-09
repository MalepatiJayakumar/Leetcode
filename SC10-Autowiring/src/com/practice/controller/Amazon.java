package com.practice.controller;

import com.practice.courriers.Courrier;

public class Amazon {
	
	private Courrier courrier;

	public Courrier getCourrier() {
		System.out.println("Amazon.getCourrier()");
		return courrier;
	}

	public void setCourrier(Courrier courrier) {
		System.out.println("Amazon.setCourrier() >> "+courrier.getClass().getName());
		this.courrier = courrier;
	}

	@Override
	public String toString() {
		return "Amazon [courrier=" + courrier + "]";
	}
	
}