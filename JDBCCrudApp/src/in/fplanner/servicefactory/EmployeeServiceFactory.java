package in.fplanner.servicefactory;

import in.fplanner.service.EmployeeServiceImpl;
import in.fplanner.service.IEmployeeService;

public class EmployeeServiceFactory {

	static IEmployeeService employeeService = null;

	public static IEmployeeService getEmployeeService() {
		if (employeeService == null) {
			employeeService = new EmployeeServiceImpl();
		}
		return employeeService;
	}

}
