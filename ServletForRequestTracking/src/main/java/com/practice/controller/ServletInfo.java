package com.practice.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servletInfo/test/*")
public class ServletInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		/*
		 * 1. getRequestURI()
		   2. getQueryString()
		   3. getServletPath()
		   4. getPathInfo()
           5. getContextPath()
		 */
		out.println("<h1>Url of the Servlet  ::  "+request.getRequestURI()+"</h1>");
		out.println("<h1>Query Strings       ::  "+request.getQueryString()+"</h1>");
		out.println("<h1>Servlet path        ::  "+request.getServletPath()+"</h1>");
		out.println("<h1>Servlet path info   ::  "+request.getPathInfo()+"</h1>");
		out.println("<h1>Servlet context path::  "+request.getContextPath()+"</h1>");
		out.close();
	}
}
