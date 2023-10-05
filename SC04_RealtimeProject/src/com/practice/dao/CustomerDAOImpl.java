package com.practice.dao;

import com.practice.DTO.CustomerDTO;
import javax.sql.DataSource;

public class CustomerDAOImpl implements ICustomerDAO {
	
	private DataSource dataSource;
	
	public CustomerDAOImpl(DataSource dataSource) {
		this.dataSource = dataSource;
		System.out.println("CustomerDAOImpl >> 1 argument constructor :: " + dataSource.getClass().getName());
	}

	@Override
	public String saveCustomerDebt(CustomerDTO dto) {
		return null;
	}

}
