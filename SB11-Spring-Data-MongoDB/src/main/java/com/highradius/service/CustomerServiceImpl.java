package com.highradius.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.highradius.dtos.CustomerDTO;
import com.highradius.entity.Customer;
import com.highradius.generator.IDGenerator;
import com.highradius.repository.MongoCustomRepository;

@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private MongoCustomRepository repo;
	
	@Override
	public List<CustomerDTO> getAllCustomers() {
		List<Customer> customers = repo.findAll();
		if (customers == null || customers.isEmpty()) {
			return null;
		}
		List<CustomerDTO> customerDTOs = new ArrayList<>();
		for (Customer cus : customers) {
			CustomerDTO dto = new CustomerDTO();
			BeanUtils.copyProperties(cus, dto);
			customerDTOs.add(dto);
		}
		return customerDTOs;
	}

	@Override
	public CustomerDTO saveCustomer(CustomerDTO customerDTO) {
		Customer customer = new Customer();
		BeanUtils.copyProperties(customerDTO, customer);
		customer = repo.insert(customer);
		BeanUtils.copyProperties(customer, customerDTO);
		return customerDTO;
	}
	
	public List<CustomerDTO> getOnSortedOrder(){
		return null;
	}

	@Override
	@Transactional
	public CustomerDTO updateCustomer(CustomerDTO customerDTO) {
		if (customerDTO.getId() == null) {
			customerDTO.setId(IDGenerator.generateId());
		}
		Customer customer = new Customer();
		BeanUtils.copyProperties(customerDTO, customer);
		customer = repo.save(customer);
		BeanUtils.copyProperties(customerDTO, customer);
		return customerDTO;
	}
}