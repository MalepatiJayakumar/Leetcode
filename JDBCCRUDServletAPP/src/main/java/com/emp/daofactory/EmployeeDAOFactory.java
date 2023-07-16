package com.emp.daofactory;

import com.emp.persistence.EmployeeDAOImpl;
import com.emp.persistence.IEmployeeDAO;

public class EmployeeDAOFactory {
	
	static IEmployeeDAO employeeDAO;
	
	public static IEmployeeDAO getEmployeeService() {
		if(employeeDAO == null) {
			employeeDAO = new EmployeeDAOImpl();
		}
		return employeeDAO;
	}
}
