package in.fplanner.servicefactory;

import in.fplanner.service.IEmployeeService;
import in.fplanner.service.EmployeeServiceImpl;

//Abstraction logic of implementation
public class EmployeeServiceFactory {

	// making an private constructor to avoid object creation
	private EmployeeServiceFactory() {

	}

	private static IEmployeeService employeeService = null;

	public static IEmployeeService getEmployeeService() {

		// singleTon pattern code
		if (employeeService == null) {
			employeeService = new EmployeeServiceImpl();
		}
		return employeeService;
	}
}