package com.emp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.emp.Util.Constants;
import com.emp.dto.Employee;
import com.emp.service.IEmployeeService;
import com.emp.servicefactory.EmployeeServiceFactory;

@WebServlet("/controller/*")
public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			doProcess(request,response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			doProcess(request,response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void doProcess(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		IEmployeeService employeeService = EmployeeServiceFactory.getEmployeeService();
		String pathInfo = request.getPathInfo();
		if (pathInfo.endsWith(Constants.add)) {
			Employee emp = new Employee(request.getParameter("name"), Integer.parseInt(request.getParameter("age")),
					request.getParameter("address"), Double.parseDouble(request.getParameter("salary")));
			addEmployee(emp,employeeService,response);
		} else if (pathInfo.endsWith(Constants.search)) {
			searchEmployee(Long.parseLong(request.getParameter("empId")),employeeService,response);
		} else if (pathInfo.endsWith(Constants.update)) {
			updateEmployee(null,employeeService);
		} else if (pathInfo.endsWith(Constants.delete)) {
			deleteEmployee(null,employeeService);
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
	
	public void searchEmployee(Long id , IEmployeeService employeeService,HttpServletResponse response) throws IOException {
		Employee emp = employeeService.searchEmployee(id);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		if(Objects.nonNull(emp)) {
			out.println("<center>");
			out.println("<h1>Employee Details</h1>");
			out.println("<table border=5px>");
			out.println("<tr><th>Name</th><td>"+emp.getName()+"</td></tr>");
			out.println("<tr><th>Age</th><td>"+emp.getAge()+"</td></tr>");
			out.println("<tr><th>Address</th><td>"+emp.getAddress()+"</td></tr>");
			out.println("<tr><th>Salary</th><td>"+emp.getSalary()+"</td></tr>");
			out.println("</table>");
			out.println("</center>");
		}else {
			out.println("<center><h1 style='color:red'>Sorry did not found Employee with provided Id, please try again</h1></center>");
		}
		out.close();
	}
	
	public void updateEmployee(Employee emp , IEmployeeService employeeService) {
		
	}
	
	public void deleteEmployee(Long id , IEmployeeService employeeService) {
		
	}
}
