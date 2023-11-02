package com.highradius.service;

import java.util.List;
import java.util.Map;

import com.hrc.dto.EmployeeDTO;

public interface IEmployeeService {
	public List<Map<String,Object>> getAllEmployees();
	public void updateEmployee(EmployeeDTO employee);
	public EmployeeDTO getEmployee(Long empId);
}