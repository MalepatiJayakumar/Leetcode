package com.practice.service;

import java.util.Date;

public class DateOperationsService {

	private Date date = null;
	
	static {
		System.out.println("DateOperationsService class is getting loaded...");
	}
	
	public DateOperationsService() {
		System.out.println("DateOperationsService object is being instantiated..");
	}
	
	public void setDate(Date date) {
		System.out.println("Setter for Date field is called..");
		this.date = date;
	}
	
	public Date getDate() {
		return date;
	}
}