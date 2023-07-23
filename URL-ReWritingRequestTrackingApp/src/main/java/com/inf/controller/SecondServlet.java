package com.inf.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/servlet2")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accType = request.getParameter("accType");
		String accBranch = request.getParameter("accBranch");
		
		HttpSession session = request.getSession(false);
		session.setAttribute("Account Type",accType);
		session.setAttribute("Account Branch",accBranch);
		
		PrintWriter out = response.getWriter();
		out.println(
				"<html><head><title>Deposit Form</title></head><body><center><h1> Deposit Form Page - 03</h1><form method='POST' action='"
						+ response.encodeURL("./servlet3") + "'><table>");
		out.println("<tr><th>Deposter Name: </th><td><input type='text' value='jai' name='depName'/></td></tr>");
		out.println(
				"<tr><th>Deposit Amount : </th><td><input type='number' value='1000' name='depAmount'/></td></tr>");
		out.println(" </table><br/><input type='submit' value='submit'/></form></center></body></html>");
		out.close();
	}

}
