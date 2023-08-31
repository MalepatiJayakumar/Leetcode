package com.practice.daoFactory;

import com.practice.persistence.EmployeeDAOImpl;
import com.practice.persistence.IEmployeeDAO;

public class EmployeeDAOFactory {

	static IEmployeeDAO employeeDAO;

	public IEmployeeDAO getEmployeeDAO() {
		if (employeeDAO == null) {
			employeeDAO = new EmployeeDAOImpl();
		}
		return employeeDAO;
	}
}
