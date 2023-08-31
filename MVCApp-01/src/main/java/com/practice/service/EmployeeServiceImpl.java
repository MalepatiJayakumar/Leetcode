package com.practice.service;

import com.practice.dto.Employee;
import com.practice.persistence.EmployeeDAOImpl;
import com.practice.persistence.IEmployeeDAO;

public class EmployeeServiceImpl implements IEmployeeService {
	
	IEmployeeDAO employeeDAO;
	
	@Override
	public Employee getEmployee(Long id) {
		getEmployeeDAO();
		return employeeDAO.getEmployee(id);
	}
	
	
	public IEmployeeDAO getEmployeeDAO() {
		if(employeeDAO == null) {
			employeeDAO = new EmployeeDAOImpl();
		}
		return employeeDAO;
	}

}
