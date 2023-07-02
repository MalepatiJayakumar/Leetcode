package in.fplanner.controller;

import java.util.List;
import java.util.Scanner;

import in.fplanner.Util.Constants;
import in.fplanner.dto.Employee;
import in.fplanner.service.IEmployeeService;
import in.fplanner.servicefactory.EmployeeServiceFactory;

public class TestApp {
	public static void main(String[] args) {

		IEmployeeService employeeService = EmployeeServiceFactory.getEmployeeService();

		Scanner scan = new Scanner(System.in);
		System.out.println("please enter operation to perform");
		String operation = scan.next();
		switch (operation.toUpperCase()) {
		case "INSERT": {
			addEmployees(employeeService);
			break;
		}
		case "SELECT": {
			System.out.println("Enter employee id to search");
			Long id = scan.nextLong();
			selectEmployee(employeeService, id);
			break;
		}
		case "UPDATE": {
			updateEmployee(employeeService);
			break;
		}
		case "DELETE": {
			System.out.println("Enter employee id to delete");
			Long id = scan.nextLong();
			deleteEmployee(employeeService, id);
			break;
		}
		}
		scan.close();
	}

	public static void selectEmployee(IEmployeeService employeeService , Long id) {
		Employee employee = employeeService.searchEmployee(id);
		if(employee != null) {
			System.out.println();
			System.out.println("employee name :: "+employee.getName());
			System.out.println("employee age :: "+employee.getAge());
			System.out.println("employee address :: "+employee.getAddress());
			System.out.println("employee salary :: "+employee.getSalary());
		}else {
			System.out.println("No employee found with provided employee id");
		}
		System.out.println();
		/*
		please enter operation to perform
		select
		Enter employee id to search
		24
		Connections has been closed successfully.

		employee name :: jai
		employee age :: 21
		employee address :: HYD
		employee salary :: 5000
		*/
	}

	public static void addEmployees(IEmployeeService employeeService) {

		// Adding an Student
		String output = employeeService.addEmployee("jai", 24L, "HYD");
		if (Constants.SUCCESS.equalsIgnoreCase(output)) {
			System.out.println("Data Inserted successfully....");
		} else {
			System.out.println("Data insertion failed");
		}
	}
	
	public static void updateEmployee(IEmployeeService employeeService) {
		Scanner scan = new Scanner(System.in);
		List<Employee> employees = employeeService.getAllEmployees();
		System.out.println("id\tname\tage\taddress\tsalary");
		for(Employee emp : employees) {
			System.out.println(emp.getId()+"\t"+emp.getName()+"\t"+emp.getAge()+"\t"+emp.getAddress()+"\t"+emp.getSalary());
		}
		System.out.println("please enter employee id to update");
		Long id = scan.nextLong();
		scan.close();
	}
	
	public static void deleteEmployee(IEmployeeService employeeService , Long id) {
		String response = employeeService.deleteEmployee(id);
		if(Constants.SUCCESS.equalsIgnoreCase(response)) {
			System.out.println("Employee with "+id+" has been deleted successfully....");
		}else {
			System.out.println("Employee with "+id+" deletion has been failed");
		}
	}
}