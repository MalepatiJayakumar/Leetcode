package com.practice.controller;

import com.practice.DTO.CustomerRequest;
import com.practice.service.ICustomerService;

public class MainController {
	
	private ICustomerService customerService;
	
	public MainController(ICustomerService customerService) {
		this.customerService = customerService;
		System.out.println("MainController >> one argument constructor :: "+customerService.getClass().getName());
	}
	
	public String calculateIntrest(CustomerRequest request) {
		return customerService.calculateSimpleIntrest(request);
	}
	
}