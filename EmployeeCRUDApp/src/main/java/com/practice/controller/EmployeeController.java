package com.practice.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.practice.entity.Employee;
import com.practice.service.IEmployeeService;
import com.practice.serviceFactory.EmployeeServiceFactory;
import com.practice.utils.Constants;

/**
 * Servlet implementation class EmployeeController
 */
@WebServlet("/controller/*")
public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			doProcess(request,response);
		} catch (NumberFormatException | SQLException | IOException | ServletException e) {
			e.printStackTrace();
		}
	}

	public void doProcess(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, NumberFormatException, ServletException {
		IEmployeeService employeeService = EmployeeServiceFactory.getEmployeeService();
		String pathInfo = request.getPathInfo();
		if (pathInfo.endsWith(Constants.add)) {
			Employee emp = new Employee(request.getParameter("name"), Integer.parseInt(request.getParameter("age")),
					request.getParameter("address"), Double.parseDouble(request.getParameter("salary")));
			addEmployee(emp,employeeService,response);
		}
	}
	
	public void addEmployee(Employee emp , IEmployeeService employeeService, HttpServletResponse response) throws SQLException, IOException {
		String output = employeeService.addEmployee(emp);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		if(Constants.SUCCESS.equalsIgnoreCase(output)) {			
			out.println("<form style='color:green' align='center'><h1 >Successfully Added Employee</h1></form>");
		}else {
			out.println("<form style='color:red' align='center'><h1 >Adding Employee as been failed,please try Again</h1></form>");
		}
		out.close();
	}
	
	
}
