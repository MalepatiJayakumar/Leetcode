package com.practice.RequestResponseThreads;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test")
public class TestServletObject extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		PrintWriter out = response.getWriter();
		LocalDateTime date = LocalDateTime.now();
		int hour = date.getHour();
		String msg = "";
		if(hour < 11) {
			msg = "Good Morning";
		}else if(hour < 16) {
			msg = "Good Afternoon";
		}else if(hour < 20) {
			msg = "Good Evening";
		}else {
			msg = "Good Night";
		}
		out.println("<h1>"+msg+"</h1>");
		out.println("<p>sevlet request object address :: "+request.hashCode()+" </p>");
		out.println("<p>sevlet response object address :: "+response.hashCode()+" </p>");
		out.println("<p>Current Servlet object address :: "+this.hashCode()+" </p>");
		out.println("<p>Current Thread object address :: "+Thread.currentThread().hashCode()+" </p>");
		try{
			Thread.sleep(50000);
		}catch(Exception e) {
			
		}
		out.close();
	}
}


/*
Uses the same servlet object 
(Browser :- FireFox)
Good Evening
sevlet request object address :: 575537233
sevlet response object address :: 463024409
Current Servlet object address :: 1764032844
Current Thread object address :: 119218617 

(Browser :- Chrome)
Good Evening
sevlet request object address :: 1104943809
sevlet response object address :: 1327234186
Current Servlet object address :: 1764032844
Current Thread object address :: 1260679601
*/