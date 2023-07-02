package in.fplanner.daofactory;

import in.fplanner.persistence.IEmployeeDAO;
import in.fplanner.persistence.EmployeeDAOImpl;

public class EmployeeDAOFactory {

	private EmployeeDAOFactory() {

	}

	private static IEmployeeDAO employeeDAO = null;

	public static IEmployeeDAO getEmployeeDAO() {
		if (employeeDAO == null) {
			employeeDAO = new EmployeeDAOImpl();
		}
		return employeeDAO;
	}

}
