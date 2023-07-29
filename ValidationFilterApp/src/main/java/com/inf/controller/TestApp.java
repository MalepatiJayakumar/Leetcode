package com.inf.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inf.dto.Employee;
import com.inf.service.IEmployeeService;
import com.inf.serviceFactory.EmployeeServiceFactory;

@WebServlet("/test")
public class TestApp extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private IEmployeeService employeeService;

	/*
	 * Save employee details to db through singleton project structure
	 */
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String empName = request.getParameter("empName");
		String empId = request.getParameter("empId");
		String empAddress = request.getParameter("empAddress");
		String empMobile = request.getParameter("empMobile");
		String empMail = request.getParameter("empMail");
		String empAge = request.getParameter("empAge");

		Employee emp = new Employee(empName, Integer.parseInt(empAge), empAddress, 10000d);
		if (employeeService == null) {
			employeeService = EmployeeServiceFactory.getEmployeeService();
		}
		Integer rowsAffected = employeeService.saveEmployee(emp);
		PrintWriter out = response.getWriter();
		if (rowsAffected > 0) {
			out.println("<head><title>Response</title></head>");
			out.println("<body><center><h1>Employee Details has been saved successfully</h1><table border='1' style='text-align: center'>");
			out.println("<tr><td>Name </td><td>" + empName + "</td></tr>");
			out.println("<tr><td>Id </td><td>" + empId + "</td></tr>");
			out.println("<tr><td>Address </td><td>" + empAddress + "</td></tr>");
			out.println("<tr><td>Mobile </td><td>" + empMobile + "</td></tr>");
			out.println("<tr><td>Mail </td><td>" + empMail + "</td></tr>");
			out.println("<tr><td>Age </td><td>" + empAge + "</td></tr>");
			out.println("</table></center></body>");
			out.close();
		} else {
			out.println("<center><h1>Something went wrong</h1></center>");
		}
	}
}