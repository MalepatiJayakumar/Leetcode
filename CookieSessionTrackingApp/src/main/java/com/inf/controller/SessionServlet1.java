package com.inf.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet1")
public class SessionServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");

		Cookie c1 = new Cookie("userName", userName);
		Cookie c2 = new Cookie("password", password);

		response.addCookie(c1);
		response.addCookie(c2);

		RequestDispatcher reqDis = request.getRequestDispatcher("./form2.html");
		reqDis.forward(request, response);
	}
}