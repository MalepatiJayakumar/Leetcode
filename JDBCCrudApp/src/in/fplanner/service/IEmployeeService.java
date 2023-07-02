package in.fplanner.service;

import java.util.List;

import in.fplanner.dto.Employee;

public interface IEmployeeService {

	public String addEmployee(String name, Long age, String address);

	public Employee searchEmployee(Long id);

	public String updateEmployee(Long id, String name, Long age, String address);

	public String deleteEmployee(Long id);
	
	public List<Employee> getAllEmployees();

}
