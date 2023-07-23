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
public class ThirdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String depName = request.getParameter("depName");
		String depAmount = request.getParameter("depAmount");

		HttpSession session = request.getSession();
		session.setAttribute("Depositor Name",depName);
		session.setAttribute("Deposit Amount",depAmount);
		
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Deposit Form</title></head><body><center><h1> Deposit Form Details</h1><form><table border='1'>");
		Enumeration<String> names = session.getAttributeNames();
		while (names.hasMoreElements()) {
			String name = names.nextElement();
			Object value = session.getAttribute(name);
			out.println("<tr><th>" + name + " </th><td>" + value + "</td></tr>");
		}
		out.println("</table></form></center></body></html>");
		out.close();
	}

}
