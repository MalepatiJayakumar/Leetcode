package com.inf.daoFactory;

import com.inf.persistence.EmployeeDAOImpl;
import com.inf.persistence.IEmployeeDAO;

public class EmployeeDAOFactory {

	private static IEmployeeDAO employeeDAO;

	public static IEmployeeDAO getEmployeeDAO() {
		if (employeeDAO == null) {
			employeeDAO = new EmployeeDAOImpl();
		}
		return employeeDAO;
	}

}