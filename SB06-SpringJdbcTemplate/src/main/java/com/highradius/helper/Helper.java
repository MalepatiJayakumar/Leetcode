package com.highradius.helper;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.hrc.dto.EmployeeDTO;

@Component
public class Helper {

	public static EmployeeDTO convertMapToEmployeeDTO(Map<String, Object> employeeData) {
		return new EmployeeDTO((String) employeeData.get("name"),
				Integer.parseInt(String.valueOf(employeeData.get("age"))), (String) employeeData.get("address"),
				Double.parseDouble(String.valueOf(employeeData.get("salary"))));
	}

	public static void updateEmployeeRequest(EmployeeDTO currentEmployee, EmployeeDTO employee) {
		employee.setName(employee.getName() != null ? employee.getName() : currentEmployee.getName());
		employee.setAge(employee.getAge() != null ? employee.getAge() : currentEmployee.getAge());
		employee.setAddress(employee.getAddress() != null ? employee.getAddress() : currentEmployee.getAddress());
		employee.setSalary(employee.getSalary() != null ? employee.getSalary() : currentEmployee.getSalary());
	}
}