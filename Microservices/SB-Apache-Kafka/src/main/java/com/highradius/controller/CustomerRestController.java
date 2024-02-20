package com.highradius.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.highradius.service.KafkaService;

@RestController
public class CustomerRestController {

	@Autowired
	private KafkaService customerService;

	/**
	 * This method is used to Customer records in post request
	 * 
	 * @param customers
	 * @return
	 */
	@PostMapping(value = "/addCustomer/{name}")
	public String addCustomer(@PathVariable String name) {
		System.out.println("CustomerRestController.addCustomer() >> "+name);
		return customerService.add(name);
	}
}