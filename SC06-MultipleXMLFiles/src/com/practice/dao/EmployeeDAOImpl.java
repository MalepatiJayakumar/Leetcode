package com.practice.dao;

import javax.sql.DataSource;

import com.practice.dto.Employee;

public class EmployeeDAOImpl implements IEmployeeDAO {

	private DataSource dataSource;
	
	public EmployeeDAOImpl(DataSource dataSource) {
		this.dataSource = dataSource;
		System.out.println("EmployeeDAOImpl >> 1 argument constructor :: " + dataSource.getClass().getName());
	}
	
	@Override
	public String saveEmployee(Employee employee) {
		
		return null;
	}

}
