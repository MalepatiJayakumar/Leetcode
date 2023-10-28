package com.highradius.dao;

import java.util.List;
import java.util.Map;

import com.hrc.dto.EmployeeDTO;

public interface IEmployeeDAO {
	public List<Map<String,Object>> getAllEmployees();
	public void updateEmployee(EmployeeDTO employee);
	public Map<String,Object> getEmployee(Long id);
}