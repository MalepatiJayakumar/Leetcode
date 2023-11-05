package com.highradius.controller;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.highradius.service.IEmployeeService;
import com.hrc.dto.EmployeeDTO;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	private Logger logger = Logger.getLogger(EmployeeController.class);
	
	@Autowired
	private IEmployeeService employeeService;

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<Map<String, Object>>> getAllEmployees() {
		logger.debug("Inside EmployeeController method getAllEmployees() ");
		return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
	}

	@RequestMapping(value = "/update-employee", method = RequestMethod.POST)
	public ResponseEntity<?> updateEmployee(@RequestBody EmployeeDTO employee) {
		employeeService.updateEmployee(employee);
		return ResponseEntity.ok().build();
	}

	@RequestMapping(value = "/get-employee/{id}", method = RequestMethod.GET)
	public ResponseEntity<EmployeeDTO> getEmployeeWithId(@PathVariable Long id) {
		System.out.println("EmployeeController.getEmployeeWithId() >> id :: "+id);
		return new ResponseEntity<>(employeeService.getEmployee(id), HttpStatus.OK);
	}
}