package in.fplanner.persistence;

import java.util.List;

import in.fplanner.dto.Employee;

public interface IEmployeeDAO {

	public String addEmployee(String name, Long age, String address);

	public Employee searchEmployee(Long id);

	public String updateEmployee(Long id, String name, Long age, String address);

	public String deleteEmployee(Long id);

	public List<Employee> getAllEmployees();
}
