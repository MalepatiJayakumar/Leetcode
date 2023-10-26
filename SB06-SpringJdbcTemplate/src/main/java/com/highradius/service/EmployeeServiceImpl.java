package com.highradius.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.highradius.dao.IEmployeeDAO;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private IEmployeeDAO employeeDAO;
	
	@Override
	public List<Map<String, Object>> getAllEmployees() {
		return employeeDAO.getAllEmployees();
	}
}
