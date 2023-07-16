package com.emp.servicefactory;

import com.emp.service.EmployeeServiceImpl;
import com.emp.service.IEmployeeService;

public class EmployeeServiceFactory {
	
	static IEmployeeService employeeService;
	
	public static IEmployeeService getEmployeeService() {
		if(employeeService == null) {
			employeeService = new EmployeeServiceImpl();
		}
		return employeeService;
	}
	
}
