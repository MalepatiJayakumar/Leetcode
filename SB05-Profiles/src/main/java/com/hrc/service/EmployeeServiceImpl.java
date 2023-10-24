package com.hrc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrc.dao.IEmployeeDAO;
import com.hrc.dto.EmployeeDTO;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private IEmployeeDAO employeeDAO;

	@Override
	public List<EmployeeDTO> getEmployeesFromAddress(String address) {
		return employeeDAO.getEmployeesFromAddress(address);
	}
}