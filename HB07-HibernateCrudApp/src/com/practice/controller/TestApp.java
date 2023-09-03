package com.practice.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.practice.dto.EmployeeDTO;
import com.practice.service.IEmployeeService;
import com.practice.serviceFactory.EmployeeServiceFactory;

public class TestApp {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) {
		try {
			flow : {
				System.out.println("Enter 1 to add employee");
				System.out.println("Enter 2 to search employee");
				System.out.println("Enter 3 to update employee");
				System.out.println("Enter 4 to delete employee");
				System.out.println("Enter 5 to exit");
				while(true) {
					System.out.println("Please enter your choice :: ");
					String choice = br.readLine();
					switch(choice) {
					case "1" : addEmployee();
							break;
					case "2" : searchEmployee();
							break;
					case "3" : updateEmployee();
						break;
					case "4" : deleteEmployee();
						break;
					case "5" :
						System.out.println("Thanks for using application");
						break flow;
					default : 
						System.out.println("Invalid input");
						break flow;
					}
				}
			}
		}catch(Exception e) {
			System.out.println("Exception occurred :: "+e);
		}
	}

	private static void deleteEmployee() throws NumberFormatException, IOException {
		System.out.println("Inside deleteEmployee");
		System.out.println("Please enter employee id to delete an employee :: ");
		IEmployeeService employeeService = EmployeeServiceFactory.getEmployeeService();
		Long id = Long.parseLong(br.readLine());
		Boolean status = employeeService.deleteEmployee(id);
		if (status) {
			System.out.println(id + " employee has been deleted successfully.");
		} else {
			System.out.println("Employee deletion has been failed , please try again");
		}
	}
	
	private static void updateEmployee() {
		System.out.println("Inside updateEmployee");
	}

	private static void searchEmployee() throws NumberFormatException, IOException {
		System.out.println("Inside searchEmployee() in TestApp");
		System.out.println("Please enter employee id to search for an employee :: ");
		IEmployeeService employeeService = EmployeeServiceFactory.getEmployeeService();
		Long id = Long.parseLong(br.readLine());
		EmployeeDTO emp = employeeService.searchEmployee(id);
		if (emp != null) {
			System.out.println("Employee :: " + emp);
		} else {
			System.out.println("Employee not found with id :: " + id);
		}
	}

	private static void addEmployee() {
		System.out.println("Inside addEmployee");
	}
}