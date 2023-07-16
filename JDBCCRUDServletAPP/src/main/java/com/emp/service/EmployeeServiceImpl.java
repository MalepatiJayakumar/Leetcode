package com.emp.service;

import java.io.IOException;
import java.sql.SQLException;

import com.emp.daofactory.EmployeeDAOFactory;
import com.emp.dto.Employee;
import com.emp.persistence.IEmployeeDAO;

public class EmployeeServiceImpl implements IEmployeeService {

	IEmployeeDAO employeeDAO;

	@Override
	public String addEmployee(Employee employee) throws SQLException {
		if (employeeDAO == null) {
			employeeDAO = EmployeeDAOFactory.getEmployeeService();
		}
		return employeeDAO.addEmployee(employee);
	}

	@Override
	public Employee searchEmployee(Long id) throws IOException, SQLException {
		if (employeeDAO == null) {
			employeeDAO = EmployeeDAOFactory.getEmployeeService();
		}
		return employeeDAO.searchEmployee(id);
	}

	@Override
	public String updateEmployee(Employee employee) throws IOException, SQLException {
		if (employeeDAO == null) {
			employeeDAO = EmployeeDAOFactory.getEmployeeService();
		}
		return employeeDAO.updateEmployee(employee);
	}

	@Override
	public String deleteEmployee(Long id) throws IOException {
		if (employeeDAO == null) {
			employeeDAO = EmployeeDAOFactory.getEmployeeService();
		}
		return employeeDAO.deleteEmployee(id);
	}
}
