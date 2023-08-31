package com.practice.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.practice.dto.Employee;
import com.practice.service.IEmployeeService;
import com.pratice.serviceFactory.EmployeeServiceFactory;

@WebServlet("/EmployeeController/*")
public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		doProcess(request, response);
	}

	public void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		IEmployeeService employeeService = EmployeeServiceFactory.getEmployeeService();
		String pathInfo = request.getPathInfo();
		System.out.println("Path info :: "+pathInfo);
		if(pathInfo.endsWith("search")) {
			Employee employee = employeeService.getEmployee(Long.parseLong(request.getParameter("empId")));
			request.setAttribute("employee",employee);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("../displayEmployee.jsp");
			requestDispatcher.forward(request,response);
		}
	}
}