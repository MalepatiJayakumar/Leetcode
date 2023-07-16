package com.emp.service;

import java.io.IOException;
import java.sql.SQLException;

import com.emp.dto.Employee;

public interface IEmployeeService {
	
	public String addEmployee(Employee employee) throws SQLException;
	
	public Employee searchEmployee(Long id) throws IOException;
	
	public String updateEmployee(Employee employee);
	
	public String deleteEmployee(Long id);
	
}