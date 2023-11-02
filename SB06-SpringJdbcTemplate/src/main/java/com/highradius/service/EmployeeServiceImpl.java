package com.highradius.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.highradius.dao.IEmployeeDAO;
import com.highradius.helper.Helper;
import com.hrc.dto.EmployeeDTO;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private IEmployeeDAO employeeDAO;

	@Override
	public List<Map<String, Object>> getAllEmployees() {
		return employeeDAO.getAllEmployees();
	}

	@Override
	public void updateEmployee(EmployeeDTO employee) {
		System.out.println("employee :: "+employee.getSalary());
		Helper.updateEmployeeRequest(Helper.convertMapToEmployeeDTO(employeeDAO.getEmployee(employee.getId())),employee);
		employeeDAO.updateEmployee(employee);
	}

	@Override
	public EmployeeDTO getEmployee(Long empId) {
		return employeeDAO.getEmployeeByIdUsingMapper(empId);
	}
}