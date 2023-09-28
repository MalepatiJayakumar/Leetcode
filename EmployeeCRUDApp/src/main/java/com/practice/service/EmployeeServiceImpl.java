package com.practice.service;

import com.practice.dao.IEmployeeDAO;
import com.practice.daoFactory.EmployeeDAOFactory;
import com.practice.entity.Employee;

public class EmployeeServiceImpl implements IEmployeeService {

	IEmployeeDAO employeeDAO = null;
	
	@Override
	public String addEmployee(Employee emp) {
		if(employeeDAO == null) {
			employeeDAO = EmployeeDAOFactory.getEmployeeDAO();
		}
		return employeeDAO.addEmployee(emp);
	}

}
