package com.practice.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServletContext extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static {
		System.out.println("TestServletContext is loading..");
	}
  
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println(
				"<!DOCTYPE html><html lang=\"en\"><head><title>HTTP Requset Headers</title></head><body><center><h1>Servlet Context Variables</h1><table style=\"border: 1px solid black\">");
		ServletContext context = getServletContext();
		Enumeration<String> headers = context.getInitParameterNames();
		while (headers.hasMoreElements()) {
			String parameterName = (String) headers.nextElement();
			String parameterValue = context.getInitParameter(parameterName);
			out.println("<tr style= \"border: 1px solid black\"><td style= \"border: 1px solid black\">" + parameterName
					+ "</td><td style= \"border: 1px solid black\">" + parameterValue + "</td></tr>");
		}
		out.println("</table></center></body></html>");
		out.close();
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
