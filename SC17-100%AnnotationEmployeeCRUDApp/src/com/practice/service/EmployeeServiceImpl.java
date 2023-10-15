package com.practice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.dao.EmployeeDAO;
import com.practice.dto.EmployeeDTO;
import com.practice.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO employeeDAO;

	static {
		System.out.println("EmployeeServiceImpl.class file has been loaded");
	}

	public EmployeeServiceImpl() {
		System.out.println("EmployeeServiceImpl object has been instantiated");
	}

	@Override
	public String saveEmployee(EmployeeDTO empDTO) {
		return employeeDAO.saveEmployee(calculateHike(empDTO));
	}

	public Employee calculateHike(EmployeeDTO empDTO) {
		return new Employee(null, empDTO.getName(), empDTO.getOrganization(), empDTO.getLocation(),
				empDTO.getSalary() + 50000.0d);
	}
}