package com.inf.service;

import com.inf.daoFactory.EmployeeDAOFactory;
import com.inf.dto.Employee;
import com.inf.persistence.IEmployeeDAO;

public class EmployeeServiceImpl implements IEmployeeService {
	
	private IEmployeeDAO employeeDAO;

	@Override
	public Integer saveEmployee(Employee emp) {
		if(employeeDAO == null) {
			employeeDAO = EmployeeDAOFactory.getEmployeeDAO();
		}
		
		return employeeDAO.saveEmployee(emp);
	}

}
