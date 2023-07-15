package in.fplanner.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import in.fplanner.daofactory.EmployeeDAOFactory;
import in.fplanner.dto.Employee;
import in.fplanner.persistence.IEmployeeDAO;

public class EmployeeServiceImpl implements IEmployeeService {

	IEmployeeDAO employeeDAO;
	
	@Override
	public Employee getEmployee(Long id) throws IOException, SQLException {
		if(employeeDAO == null) {
			employeeDAO = EmployeeDAOFactory.getEmployeeDAO();	
		}
		return employeeDAO.getEmployee(id);
	}

	@Override
	public String addEmployee(Employee emp) throws Exception {
		if(employeeDAO == null) {
			employeeDAO = EmployeeDAOFactory.getEmployeeDAO();	
		}
		return employeeDAO.addEmployee(emp);
	}

	@Override
	public List<Employee> getAllEmployees() throws Exception {
		if(employeeDAO == null) {
			employeeDAO = EmployeeDAOFactory.getEmployeeDAO();	
		}
		return employeeDAO.getAllEmployees();
	}

	@Override
	public String deleteEmployee(Long id) throws SQLException, Exception {
		if(employeeDAO == null) {
			employeeDAO = EmployeeDAOFactory.getEmployeeDAO();	
		}
		return employeeDAO.deleteEmployee(id);
	}

	@Override
	public String updateEmployee(Employee emp) throws SQLException, Exception {
		if(employeeDAO == null) {
			employeeDAO = EmployeeDAOFactory.getEmployeeDAO();	
		}
		return employeeDAO.updateEmployee(emp);
	}

}
