package com.practice.persistence;

import com.practice.entity.Employee;

public interface IEmployeeDAO {
	
	public Boolean addEmployee(Employee employee);
	
	public Employee searchEmployee(Long id);
	
	public Boolean deleteEmployee(Long id);
	
	public Boolean updateEmployee(Employee employee);
}