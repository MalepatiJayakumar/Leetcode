package com.pratice.serviceFactory;

import com.practice.service.EmployeeServiceImpl;
import com.practice.service.IEmployeeService;

public class EmployeeServiceFactory {

	static IEmployeeService employeeService;
	
	public static IEmployeeService getEmployeeService() {
		if(employeeService == null) {
			employeeService = new EmployeeServiceImpl();
		}
		return employeeService;
	}
	
}
