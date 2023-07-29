package com.inf.serviceFactory;

import com.inf.service.EmployeeServiceImpl;
import com.inf.service.IEmployeeService;

public class EmployeeServiceFactory {

	private static IEmployeeService employeeService;

	public static IEmployeeService getEmployeeService() {
		if (employeeService == null) {
			employeeService = new EmployeeServiceImpl();
		}
		return employeeService;
	}
}