package com.practice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.dao.EmployeeDAO;
import com.practice.dto.EmployeeDTO;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	static {
		System.out.println("EmployeeServiceImpl.class file has been loaded");
	}
	
	public EmployeeServiceImpl() {
		System.out.println("EmployeeServiceImpl object has been instantiated");
	}
	
	@Autowired
	private EmployeeDAO employeeDAO;
	
	@Override
	public String saveEmployee(EmployeeDTO emp) {
		System.out.println("EmployeeServiceImpl.saveEmployee()");
		return employeeDAO.saveEmployee(emp);
	}

}
