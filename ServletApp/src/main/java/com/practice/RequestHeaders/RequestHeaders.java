package com.practice.RequestHeaders;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @author JaiKumar
 *
 */
@WebServlet("/request/test")
public class RequestHeaders extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Enumeration<String> headers = request.getHeaderNames();
		PrintWriter out = response.getWriter();
		out.println(
				"<!DOCTYPE html><html lang=\"en\"><head><title>HTTP Requset Headers</title></head><body><h1>HTTP Request Headers</h1><center><table style=\"border: 1px solid black\">");
		while (headers.hasMoreElements()) {
			String header = headers.nextElement();
			String value = request.getHeader(header);
			out.println("<tr style= \"border: 1px solid black\"><td style= \"border: 1px solid black\">" + header
					+ "</td><td style= \"border: 1px solid black\">" + value + "</td></tr>");
		}
		out.println("</table></center></body></html>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
