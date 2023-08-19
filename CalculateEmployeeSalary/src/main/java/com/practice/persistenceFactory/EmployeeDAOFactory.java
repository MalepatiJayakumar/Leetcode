package com.practice.persistenceFactory;

import com.practice.persistence.EmployeeDAO;
import com.practice.persistence.EmployeeDAOImpl;

public class EmployeeDAOFactory {

	private static EmployeeDAO employeeDAO;

	public static EmployeeDAO getEmployeeDAO() {
		if (employeeDAO == null) {
			employeeDAO = new EmployeeDAOImpl();
		}
		return employeeDAO;
	}
}