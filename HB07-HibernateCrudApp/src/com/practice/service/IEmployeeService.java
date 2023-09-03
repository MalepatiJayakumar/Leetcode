package com.practice.service;

import com.practice.dto.EmployeeDTO;

public interface IEmployeeService {
	
	public Boolean addEmployee(EmployeeDTO employee);
	
	public EmployeeDTO searchEmployee(Long id);
	
	public Boolean deleteEmployee(Long id);
	
	public Boolean updateEmployee(EmployeeDTO employee);
	
}