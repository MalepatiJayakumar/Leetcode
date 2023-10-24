package com.hrc.service;

import java.util.List;

import com.hrc.dto.EmployeeDTO;

public interface IEmployeeService {
	public List<EmployeeDTO> getEmployeesFromAddress(String address);
}