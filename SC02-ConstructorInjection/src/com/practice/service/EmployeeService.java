package com.practice.service;

import java.util.Date;

public class EmployeeService {
	
	public Date date = null;;
	
	static {
		System.out.println("Inside static block in EmployeeService");
	}
	
	public EmployeeService(Date date){
		System.out.println("Inside EmployeeService constructor");
		this.date = date;
		System.out.println(date);
	}
	
}