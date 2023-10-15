package com.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.practice.dto.EmployeeDTO;
import com.practice.service.EmployeeService;

@Controller
public class EmployeeController {

	static {
		System.out.println("EmployeeController.class has been loaded");
	}

	public EmployeeController() {
		System.out.println("EmployeeController object has been instantiated");
	}

	@Autowired
	private EmployeeService employeeService;

	public String saveEmployee() {
		EmployeeDTO emp = new EmployeeDTO(null, "dhanush", "Amazon", "Chennai", 15000.0d);
		return employeeService.saveEmployee(emp);
	}
	
	
}