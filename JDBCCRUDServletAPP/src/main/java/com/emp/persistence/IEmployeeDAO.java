package com.emp.persistence;

import java.io.IOException;
import java.sql.SQLException;

import com.emp.dto.Employee;

public interface IEmployeeDAO {
	
	public String addEmployee(Employee employee) throws SQLException;
	
	public Employee searchEmployee(Long id) throws IOException, SQLException;
	
	public String updateEmployee(Employee employee) throws IOException, SQLException;
	
	public String deleteEmployee(Long id) throws IOException;

}
