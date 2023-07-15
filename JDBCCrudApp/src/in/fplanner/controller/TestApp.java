package in.fplanner.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import in.fplanner.Util.Constants;
import in.fplanner.dto.Employee;
import in.fplanner.service.IEmployeeService;
import in.fplanner.servicefactory.EmployeeServiceFactory;

public class TestApp {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		IEmployeeService employeeService = EmployeeServiceFactory.getEmployeeService();
		System.out.println("1 :: Select employee with employee id");
		System.out.println("2 :: Add new Employee");
		System.out.println("3 :: Update existing employee");
		System.out.println("4 :: Delete employee with employee id");
		System.out.println("5 :: Fetch all employees");
		System.out.println("6 :: Exit");
			flow: {
				while (true) {
					System.out.print("Please enter option to continue :: ");
					String option = scan.next();
					switch (option) {
					case "1":
						getEmployee(employeeService);
						break;
					case "2":
						addEmployee(employeeService);
						break;
					case "3":
						updateEmployee(employeeService);
						break;
					case "4":
						deleteEmployee(employeeService);
						break;
					case "5":
						getAllEmployees(employeeService);
						break;
					case "6":
						System.out.println("Thanks for using the application....");
						break flow;
					default:
						System.out.println("Invalid input...");
						break flow;
					}
				}
			}
			scan.close();
	}

	private static void getAllEmployees(IEmployeeService employeeService) throws Exception {
		if (employeeService != null) {
			List<Employee> employees = employeeService.getAllEmployees();
			if (employees.isEmpty()) {
				System.out.println("No employees found..");
			} else {
				System.out.println("EMP_ID\tEMP_NAME\tEMP_AGE\tEMP_ADDRESS\tEMP_SALARY");
				for (Employee emp : employees) {
					System.out.println(emp.getId() + "\t" + emp.getName() + "\t\t" + emp.getAge() + "\t"
							+ emp.getAddress() + "\t\t" + emp.getSalary());
				}
			}
		}
	}

	private static void getEmployee(IEmployeeService employeeService) throws IOException, SQLException {
		if (employeeService != null) {
			System.out.println("Enter employee id to get details :: ");
			Long empId = scan.nextLong();
			Employee emp = employeeService.getEmployee(empId);
			System.out.println(emp);
		}
	}

	public static void addEmployee(IEmployeeService employeeService) throws Exception {
		if (employeeService != null) {
			Scanner scan = new Scanner(System.in);
			System.out.print("Enter Name of employee :: ");
			String name = scan.next();
			System.out.print("Enter Age of employee :: ");
			Integer age = scan.nextInt();
			System.out.print("Enter address of employee");
			String address = scan.next();
			System.out.print("Enter salary of employee");
			Double salary = scan.nextDouble();
			Employee emp = new Employee(name, age, address, salary);
			String output = employeeService.addEmployee(emp);
			if(Constants.SUCCESS.equalsIgnoreCase(output)) {
				System.out.println("Employee data has been inserted succesfully...");
			}else {
				System.out.println("Employee addition has been failed please try again..");
			}
			scan.close();
		}
	}

	public static void updateEmployee(IEmployeeService employeeService) throws Exception {
		if (employeeService != null) {
			System.out.println("Enter employee id to update");
			Long id = scan.nextLong();
			Employee emp = employeeService.getEmployee(id);
			if (emp != null) {
				System.out.print("Enter updated name of " + emp.getName() + " :: ");
				emp.setName(scan.next());
				System.out.print("Enter updated age of " + emp.getAge() + " :: ");
				emp.setAge(scan.nextInt());
				System.out.print("Enter updated name of " + emp.getAddress() + " :: ");
				emp.setAddress(scan.next());
				System.out.print("Enter updated salary of " + emp.getSalary() + " :: ");
				emp.setSalary(scan.nextDouble());
				String output = employeeService.updateEmployee(emp);
				if (Constants.SUCCESS.equalsIgnoreCase(output)) {
					System.out.println("Employee " + emp.getId() + " has been updated successfully..");
				} else {
					System.out.println("Employee " + emp.getId() + " updation has been failed..");
				}
			} else {
				System.out.println("Employee Not found..");
			}
		}
	}

	public static void deleteEmployee(IEmployeeService employeeService) throws SQLException, Exception {
		if (employeeService != null) {
			Scanner scan = new Scanner(System.in);
			System.out.print("Enter employee id to delete :: ");
			Long id = scan.nextLong();
			String output = employeeService.deleteEmployee(id);
			if(Constants.SUCCESS.equalsIgnoreCase(output)) {
				System.out.println("Successfully deleted employee..");
			}else {
				System.out.println("Deletion of employee failed..");
			}
			scan.close();
		}
	}
}
