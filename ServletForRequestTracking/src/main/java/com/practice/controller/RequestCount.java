package com.practice.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Get number of request , since start of the application
 * 
 * Servlet implementation class TestServletApp
 * 
 * @author JaiKumar
 */
@WebServlet("/test")
public class RequestCount extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		ServletContext context = getServletContext();
//		Enumeration<String> headers = context.getInitParameterNames();
//		while (headers.hasMoreElements()) {
//			String parameterName = (String) headers.nextElement();
//			if ("requests".equalsIgnoreCase(parameterName)) {
//				Integer parameterValue = Integer.parseInt(context.getAttribute(parameterName).toString());
////				Integer noOfRequests = Integer.parseInt(context.getInitParameter("requests"));
//				parameterValue = parameterValue + 1;
//				context.setAttribute(parameterName, parameterValue);
//				System.out.println("Number of requests for TestServletApp is  :: " + parameterValue);
//			}
//		}
		Integer count = (Integer) context.getAttribute("requests");
		if(count == null) {
			count = 1;
		}else {
			count++;
		}
		context.setAttribute("requests",count);
		out.println(count +" request for the servlet since start");
	}
}