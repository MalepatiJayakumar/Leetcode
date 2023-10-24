package com.hrc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hrc.dto.EmployeeDTO;
import com.hrc.service.IEmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	IEmployeeService employeeService;

	@RequestMapping(value = "/from-address/{address}", method = RequestMethod.GET)
	public ResponseEntity<List<EmployeeDTO>> getEmployeesFromAddress(@PathVariable String address) {
		System.out.println(address);
		return new ResponseEntity<>(employeeService.getEmployeesFromAddress(address), HttpStatus.OK);
	}
}