package in.fplanner.daofactory;

import in.fplanner.persistence.EmployeeDAOImpl;
import in.fplanner.persistence.IEmployeeDAO;

public class EmployeeDAOFactory {

	static IEmployeeDAO employeeDAO;
	
	public static IEmployeeDAO getEmployeeDAO() {
		if(employeeDAO == null) {
			employeeDAO = new EmployeeDAOImpl();
		}
		return employeeDAO;
	}
	
}
