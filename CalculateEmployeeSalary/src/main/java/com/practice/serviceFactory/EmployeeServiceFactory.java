package com.practice.serviceFactory;

import com.practice.service.EmployeeService;
import com.practice.service.EmployeeServiceImpl;

public class EmployeeServiceFactory {

	private static EmployeeService employeeService;

	public static EmployeeService getEmployeeService() {
		if (employeeService == null) {
			employeeService = new EmployeeServiceImpl();
		}
		return employeeService;
	}
}
