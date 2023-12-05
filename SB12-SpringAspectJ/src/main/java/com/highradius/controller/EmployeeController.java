package com.highradius.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.highradius.service.IEmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private IEmployeeService employeeService;

	@RequestMapping(value = "/get-all", method = RequestMethod.GET)
	public ResponseEntity<String> getEmployee() throws Exception {
		return new ResponseEntity<>(employeeService.getEmployee(), HttpStatus.OK);
	}
	
	@RequestMapping(value="get-employee/{id}", method =RequestMethod.GET)
	public ResponseEntity<String> getEmployeeOnId(Long id){
		return new ResponseEntity<>(employeeService.getEmployeeOnId(),HttpStatus.OK);
	}
}