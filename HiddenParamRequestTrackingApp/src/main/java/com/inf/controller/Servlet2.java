package com.inf.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/servlet2")
public class Servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sname = request.getParameter("sname");
		String sId   = request.getParameter("sid");
		String sAddr = request.getParameter("sAddr");
		String sAge  = request.getParameter("sAge");
		/*
		 * out.println("<tr><td>Address</td><td><input type='text' name='sAddr' value='sAddr'/></td></tr>");
		out.println("<tr><td>Age</td><td><input type='text' name='sAge' value='sAge'/></td></tr>");
		 */
		
		PrintWriter out = response.getWriter();
		out.println(
				"<head><title>Browser</title></head><body><h1 style='text-align:center;color:green'>Please enter Student Creds to LOGIN</h1><form method='POST' action='./servlet3' style='text-align:center'> <center>");
		//passing current servlet params as hidden params to next level
		out.println("<input type='hidden' name='sname' value='"+sname+"'>");
		out.println("<input type='hidden' name='sId' value='"+sId+"'>");
		out.println("<input type='hidden' name='sAddr' value='"+sAddr+"'>");
		out.println("<input type='hidden' name='sAge' value='"+sAge+"'>");
		out.println("<table >");
		out.println("<tr><td>Course</td><td><input type='text' name='course' value='course'/></td></tr>");
		out.println("<tr><td>Section</td><td><input type='text' name='section' value='section'/></td></tr>");
		out.println("</table>");
		out.println("</table><br/><button type=\"submit\" value=\"Submit\">Submit</button></tr></center></form></body></html>");
		out.close();
		
	}

}
