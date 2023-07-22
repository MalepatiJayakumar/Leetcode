package com.inf.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet3")
public class SessionServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String mobileNo = request.getParameter("mobile");
		
		Cookie[] cookies = request.getCookies();
		String userName = cookies[0].getValue();
		String password = cookies[1].getValue();
		String qualification = cookies[2].getValue();
		String designation = cookies[3].getValue();
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html><html lang=\"en\"><head><title>User Data</title></head><body><form><center><table border=1>");
		out.println("<tr><td>"+"userName"+"</td><td>"+userName+"</td></tr>");
		out.println("<tr><td>"+"password"+"</td><td>"+password+"</td></tr>");
		out.println("<tr><td>"+"qualification"+"</td><td>"+qualification+"</td></tr>");
		out.println("<tr><td>"+"designation"+"</td><td>"+designation+"</td></tr>");
		out.println("<tr><td>"+"email"+"</td><td>"+email+"</td></tr>");
		out.println("<tr><td>"+"mobileNo"+"</td><td>"+mobileNo+"</td></tr>");
		out.println("</table></center></form></body></html>");
		
	}
}
/*
userName		Sachin
password		sahin@123
qualification	B-COM
designation		Cricketer
email			sachin@outlook.com
mobileNo		9996552454
*/