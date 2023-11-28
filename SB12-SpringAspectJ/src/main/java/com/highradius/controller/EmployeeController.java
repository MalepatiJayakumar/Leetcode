package com.highradius.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.highradius.dtos.CustomerDTO;
import com.highradius.service.ICustomerService;

@RestController
public class EmployeeController {

	@Autowired
	private ICustomerService customerService;

	@RequestMapping(value = "/get-all", method = RequestMethod.GET)
	public ResponseEntity<List<CustomerDTO>> getAllCustomers() {
		return new ResponseEntity<>(customerService.getAllCustomers(), HttpStatus.OK);
	}
	
}