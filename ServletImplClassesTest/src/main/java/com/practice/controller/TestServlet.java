package com.practice.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/test")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletConfig config = getServletConfig();
		ServletContext context = getServletContext();
		PrintWriter out = response.getWriter();
		
		System.out.println("Implementation classes for Abstract classes in Tomcat Server");
		out.println("Implementation classes for Abstract classes in Tomcat Server\n\n");
		
		System.out.println("Implementation class of Servlet config :: "+config.getClass().getName());
		System.out.println("Implementation class of Servlet context :: "+context.getClass().getName());
		System.out.println("Implementation class of Servlet request :: "+request.getClass().getName());
		System.out.println("Implementation class of Servlet response :: "+response.getClass().getName());
		
		out.println("Implementation class of Servlet config :: "+config.getClass().getName());
		out.println("Implementation class of Servlet context :: "+context.getClass().getName());
		out.println("Implementation class of Servlet request :: "+request.getClass().getName());
		out.println("Implementation class of Servlet response :: "+response.getClass().getName());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Set<String>> data = new ArrayList<>(Arrays.asList(new HashSet<>(),new HashSet<>()));
	}
}