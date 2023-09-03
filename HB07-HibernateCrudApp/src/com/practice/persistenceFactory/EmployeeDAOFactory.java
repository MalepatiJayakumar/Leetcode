package com.practice.persistenceFactory;

import com.practice.persistence.EmployeeDAOImpl;
import com.practice.persistence.IEmployeeDAO;

public class EmployeeDAOFactory {
	
	private static IEmployeeDAO employeeDAO;
	
	public static IEmployeeDAO getEmployeeDAO() {
		if(employeeDAO == null) {
			employeeDAO = new EmployeeDAOImpl();
		}
		return employeeDAO;
	}
}