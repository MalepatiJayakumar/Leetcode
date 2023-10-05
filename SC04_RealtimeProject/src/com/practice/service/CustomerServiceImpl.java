package com.practice.service;

import com.practice.DTO.CustomerRequest;
import com.practice.dao.ICustomerDAO;

public class CustomerServiceImpl implements ICustomerService {

	private ICustomerDAO customerDAO;
	
	public CustomerServiceImpl(ICustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
		System.out.println("CustomerServiceImpl >> one argument constructor :: "+customerDAO.getClass().getName());
	}
	
	@Override
	public String calculateSimpleIntrest(CustomerRequest request) {
		return null;
	}
}