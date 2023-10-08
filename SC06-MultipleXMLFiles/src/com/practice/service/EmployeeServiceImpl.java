package com.practice.service;

import com.practice.dao.IEmployeeDAO;
import com.practice.dto.Employee;

public class EmployeeServiceImpl implements IEmployeeService {

	private IEmployeeDAO employeeDAO;

	public EmployeeServiceImpl(IEmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}
	
	@Override
	public String saveEmployee(Employee employee) {
		return employeeDAO.saveEmployee(employee);
	}
}