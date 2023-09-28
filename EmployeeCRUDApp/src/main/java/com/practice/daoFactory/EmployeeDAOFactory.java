package com.practice.daoFactory;

import com.practice.dao.EmployeeDAOImpl;
import com.practice.dao.IEmployeeDAO;

public class EmployeeDAOFactory {
	public static IEmployeeDAO employeeDAO = null;
	
	public static IEmployeeDAO getEmployeeDAO() {
		if(employeeDAO == null) {
			employeeDAO = new EmployeeDAOImpl();
		}
		return employeeDAO;
	}
}