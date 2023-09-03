package com.practice.serviceFactory;

import com.practice.service.EmployeeServiceImpl;
import com.practice.service.IEmployeeService;

public class EmployeeServiceFactory {
	
	private static IEmployeeService employeeService;
	
	public static IEmployeeService getEmployeeService() {
		if(employeeService == null) {
			employeeService = new EmployeeServiceImpl();
		}
		return employeeService;
	}
}