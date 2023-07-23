package com.inf.controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/servlet3")
public class Servlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String sname = request.getParameter("sname");
//		String sId   = request.getParameter("sid");
//		String sAddr = request.getParameter("sAddr");
//		String sAge  = request.getParameter("sAge");
//		String course= request.getParameter("course");
//		String section= request.getParameter("section");
//		
		Enumeration<String> names = request.getParameterNames();
		while(names.hasMoreElements()) {
			String name = names.nextElement();
			String value = request.getParameter(name);
			System.out.println(name+" :: "+value);
		}
		
	}

}
