package com.hrc.dao;

import java.util.List;

import com.hrc.dto.EmployeeDTO;

public interface IEmployeeDAO {
	public List<EmployeeDTO> getEmployeesFromAddress(String address);
}