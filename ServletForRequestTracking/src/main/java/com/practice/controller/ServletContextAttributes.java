package com.practice.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletContextAttributes
 * 
 * @author JaiKumar
 *
 */
@WebServlet("/servletAttributes/test")
public class ServletContextAttributes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		ServletContext context = getServletContext();
		context.setAttribute("name","JaiKumar");
		context.setAttribute("Age",22);
		Enumeration<String> attributeNames = context.getAttributeNames();
		out.println("<!DOCTYPE html><html lang=\"en\"><head><title>Context Attributes</title></head>\r\n"
				+ "<body><center><h1>Context Attributes</h1><table border='1'><tr><th>Attribute Name</th><th>Attribute Value</th><tr>");
		while(attributeNames.hasMoreElements()) {
			String attributeName = attributeNames.nextElement();
			Object value = context.getAttribute(attributeName);
			out.println("<tr><td>"+attributeName+"</td><td>"+value+"</td><tr>");
		}
		out.println("</table></center></body></html>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
