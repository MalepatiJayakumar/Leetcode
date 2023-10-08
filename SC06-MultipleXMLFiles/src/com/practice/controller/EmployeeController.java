package com.practice.controller;

import com.practice.service.IEmployeeService;

public class EmployeeController {
	private IEmployeeService employeeService;

	public EmployeeController(IEmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
}