package com.inf.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SessionServlet2
 */
@WebServlet("/servlet2")
public class SessionServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String qualification = request.getParameter("qualification");
		String designation   = request.getParameter("designation");
		
		Cookie c3 = new Cookie("qualification",qualification);
		Cookie c4 = new Cookie("designation",designation);
		
		response.addCookie(c3);
		response.addCookie(c4);
		
		RequestDispatcher reqDis = request.getRequestDispatcher("./form3.html");
		reqDis.forward(request, response);
	}

}
