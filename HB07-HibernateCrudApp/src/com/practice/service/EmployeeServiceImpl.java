package com.practice.service;

import com.practice.dto.EmployeeDTO;
import com.practice.entity.Employee;
import com.practice.persistence.IEmployeeDAO;
import com.practice.persistenceFactory.EmployeeDAOFactory;

public class EmployeeServiceImpl implements IEmployeeService {
	
	IEmployeeDAO employeeDAO =null;
	
	@Override
	public Boolean addEmployee(EmployeeDTO employee) {
		if(employeeDAO == null) {
			employeeDAO = EmployeeDAOFactory.getEmployeeDAO();
		}
		return employeeDAO.addEmployee(null);
	}

	@Override
	public EmployeeDTO searchEmployee(Long id) {
		if(employeeDAO == null) {
			employeeDAO = EmployeeDAOFactory.getEmployeeDAO();
		}
		Employee emp = employeeDAO.searchEmployee(id);
		return new EmployeeDTO(emp.getId(),emp.getName(),emp.getOrganization(),emp.getLocation(),emp.getSalary());
	}

	@Override
	public Boolean deleteEmployee(Long id) {
		if(employeeDAO == null) {
			employeeDAO = EmployeeDAOFactory.getEmployeeDAO();
		}
		return employeeDAO.deleteEmployee(id);
	}

	@Override
	public Boolean updateEmployee(EmployeeDTO employee) {
		// TODO Auto-generated method stub
		return null;
	}

}
