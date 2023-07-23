package com.inf.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/servlet1")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accName = request.getParameter("accName");
		String accNumber = request.getParameter("accNumber");

		HttpSession session = request.getSession();
		session.setAttribute("Account Name", accName);
		session.setAttribute("Account Number", accNumber);

		PrintWriter out = response.getWriter();

		out.println(
				"<html><head><title>Deposit Form</title></head><body><center><h1> Deposit Form Page - 02</h1><form method='POST' action='"
						+ response.encodeURL("./servlet2") + "'><table>");
		out.println("<tr><th>Account Type: </th><td><input type='text' value='accType' name='accType'/></td></tr>");
		out.println(
				"<tr><th>Account Branch : </th><td><input type='text' value='accBranch' name='accBranch'/></td></tr>");
		out.println(" </table><br/><input type='submit' value='submit'/></form></center></body></html>");
		out.close();
	}

}
