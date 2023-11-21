package com.highradius.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.highradius.dtos.CustomerDTO;
import com.highradius.service.ICustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private ICustomerService customerService;

	@RequestMapping(value = "/get-all", method = RequestMethod.GET)
	public ResponseEntity<List<CustomerDTO>> getAllCustomers() {
		return new ResponseEntity<>(customerService.getAllCustomers(), HttpStatus.OK);
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<CustomerDTO> saveCustomer(@RequestBody CustomerDTO customer) {
		return new ResponseEntity<>(customerService.saveCustomer(customer), HttpStatus.OK);
	}
	
	@RequestMapping(value="/upate", method=RequestMethod.POST)
	public ResponseEntity<CustomerDTO> updateCustomer(@RequestBody CustomerDTO customer) {
		return new ResponseEntity<>(customerService.updateCustomer(customer), HttpStatus.OK);
	}
}