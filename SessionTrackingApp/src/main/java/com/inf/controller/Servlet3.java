package com.inf.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/servlet3")
public class Servlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String mobileNo = request.getParameter("mobile");
		
		HttpSession session = request.getSession(false);
		session.setAttribute("email", email);
		session.setAttribute("mobile", mobileNo);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html><html lang=\"en\"><head><title>User Data</title></head><body><form><center><table border=1>");
		Enumeration<String> names = session.getAttributeNames();
		while (names.hasMoreElements()) {
			String name = names.nextElement();
			Object value = session.getAttribute(name);
			System.out.println(value);
			out.println("<tr><td>"+name+"</td><td>"+value+"</td></tr>");
		}
		out.println("<tr><td>HttpSessionRequestId</td><td>"+request.getRequestedSessionId()+"</td></tr>");
		out.println("</table></center></form></body></html>");
		
	}

}
