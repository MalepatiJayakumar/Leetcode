package com.practice.service;

import com.practice.bean.Employee;
import com.practice.persistence.EmployeeDAO;
import com.practice.persistenceFactory.EmployeeDAOFactory;

public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDAO employeeDAO;
	
	@Override
	public Employee calculateSalary(Employee emp) {
		employeeDAO = EmployeeDAOFactory.getEmployeeDAO();
		emp.setEmpNetSalary(emp.getEmpBasicSalary()*2);
		emp.setEmpGrossSalary(emp.getEmpBasicSalary()*4);
		return emp;
	}

}
