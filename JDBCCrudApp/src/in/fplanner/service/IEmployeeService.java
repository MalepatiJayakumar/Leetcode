package in.fplanner.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import in.fplanner.dto.Employee;

public interface IEmployeeService {
	
	public Employee getEmployee(Long id) throws IOException, SQLException;
	
	public String addEmployee(Employee emp) throws Exception;
	
	public List<Employee> getAllEmployees() throws Exception;
	
	public String deleteEmployee(Long id) throws SQLException, Exception;
	
	public String updateEmployee(Employee emp) throws SQLException, Exception;
}
