package com.highradius.service;

import java.util.List;

import com.highradius.dtos.CustomerDTO;

public interface ICustomerService {
	public List<CustomerDTO> getAllCustomers();
	public CustomerDTO saveCustomer(CustomerDTO customerDTO);
	public CustomerDTO updateCustomer(CustomerDTO customer);
}