package in.fplanner.service;

import java.util.List;

import in.fplanner.Util.Constants;
import in.fplanner.daofactory.EmployeeDAOFactory;
import in.fplanner.dto.Employee;
import in.fplanner.persistence.IEmployeeDAO;

//Service Logic
public class EmployeeServiceImpl implements IEmployeeService {

	IEmployeeDAO employeeDAO;

	@Override
	public String addEmployee(String name, Long age, String address) {
		employeeDAO = EmployeeDAOFactory.getEmployeeDAO();
		if(employeeDAO != null) {
			return employeeDAO.addEmployee(name, age, address);
		}
		return Constants.FAILED;
	}

	@Override
	public Employee searchEmployee(Long id) {
		employeeDAO = EmployeeDAOFactory.getEmployeeDAO();
		if(employeeDAO != null) {
			return employeeDAO.searchEmployee(id);
		}
		return null;
	}

	@Override
	public String updateEmployee(Long uid, String name, Long age, String address) {
		return null;
	}

	@Override
	public String deleteEmployee(Long id) {
		employeeDAO = EmployeeDAOFactory.getEmployeeDAO();
		if(employeeDAO != null) {
			return employeeDAO.deleteEmployee(id);
		}
		return null;
	}

	@Override
	public List<Employee> getAllEmployees() {
		employeeDAO = EmployeeDAOFactory.getEmployeeDAO();
		if(employeeDAO != null) {
			return employeeDAO.getAllEmployees();
		}
		return null;
	}

}