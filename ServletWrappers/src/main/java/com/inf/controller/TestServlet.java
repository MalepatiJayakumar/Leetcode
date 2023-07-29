package com.inf.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/*
	 * When we are getting value from getPrameter method , JDK will first check
	 * within folders if it is overrided then it will be executed. As per these
	 * request.getParameter() method will be execute in
	 * CustomizedServletRequestWrapper class , so there we are doing validations and
	 * changing the request
	 */
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String value = request.getParameter("name");
		PrintWriter out = response.getWriter();
		out.println("Entered Name is  :: "+value);
		out.close();
	}

}
