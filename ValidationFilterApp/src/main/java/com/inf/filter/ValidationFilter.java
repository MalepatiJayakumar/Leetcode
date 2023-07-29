package com.inf.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/test")
public class ValidationFilter implements Filter {
	private String err_emp_name 	= "";
	private String err_emp_id 		= "";
	private String err_emp_address 	= "";
	private String err_emp_mobile	= "";
	private String err_emp_mail  	= "";
	private String err_emp_age		= "";
	
    public ValidationFilter() {
    	
    }


	public void destroy() {
		
	}
	
	/*
	 * Validate employee details in filter if all validation are passed then moving
	 * to servlet to save employee details in Database. If not send an message to
	 * user.
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		Boolean validationError = Boolean.FALSE;
		
		String empName	  = request.getParameter("empName");
		String empId  	  = request.getParameter("empId");
		String empAddress = request.getParameter("empAddress");
		String empMobile  = request.getParameter("empMobile");
		String empMail    = request.getParameter("empMail");
		String empAge     = request.getParameter("empAge");
		
		if (empName == null || empName.isEmpty()) {
			err_emp_name = "Employee Name is mandatory";
			validationError = Boolean.TRUE;
		}
		
		if (empAge == null || empAge.isEmpty()) {
			err_emp_age = "Employee Age is mandatory";
			validationError = Boolean.TRUE;
		}else if(!(Long.parseLong(empAge) >= 20 && Long.parseLong(empAge) <= 30)) {
			err_emp_age = "Employee Age should be with in 20-30";
			validationError = Boolean.TRUE;
		}
		
		if (empId == null || empId.isEmpty()) {
			err_emp_id = "Employee Id is mandatory";
			validationError = Boolean.TRUE;
		}else if(!empId.startsWith("HRC-")){
			err_emp_id = "Employee Id should start with HRC-";
			validationError = Boolean.TRUE;
		}
		
		
		if (empAddress == null || empAddress.isEmpty()) {
			err_emp_address = "Employee Address is mandatory";
			validationError = Boolean.TRUE;
		}
		
		if (empMobile == null || empMobile.isEmpty()) {
			err_emp_mobile = "Employee Mobile Number is mandatory";
			validationError = Boolean.TRUE;
		}else if(!empMobile.startsWith("+91-")){
			err_emp_mobile = "Employee Mobile should start with 91+";
			validationError = Boolean.TRUE;
		}
		
		if (empMail == null || empMail.isEmpty()) {
			err_emp_mail = "Employee Email is mandatory";
			validationError = Boolean.TRUE;
		}else if(!empMail.endsWith("@hrc.com")){
			err_emp_mail = "Employee Email should end with @hrc.com";
			validationError = Boolean.TRUE;
		}
		
		if(validationError) {	
			PrintWriter out = response.getWriter();
			out.println("<head><title>Servlelt</title></head>");
			out.println("<body><form method ='GET' action='./test'><center><table style='text-align: center'>");
			out.println("<tr><th>Name </th><td><input name='empName' type='text' value='"+empName+"'/></td><td>"+err_emp_name+"</td></tr>");
			out.println("<tr><th>Id </th><td><input name='empId' type='text' value='1'/></td><td>"+err_emp_id+"</td></tr>");
			out.println("<tr><th>Address </th><td><input name='empAddress' type='text' value='"+empAddress+"'/></td><td>"+err_emp_address+"</td></tr>");
			out.println("<tr><th>Mobile Number </th><td><input name='empMobile' type='text' value='"+empMobile+"'/></td><td>"+err_emp_mobile+"</td></tr>");
			out.println("<tr><th>Age </th><td><input name='empAge' type='text' value='"+empAge+"'/></td><td>"+err_emp_age+"</td></tr>");
			out.println("<tr><th>Mail </th><td><input name='empMail' type='text' value='"+empMail+"'/></td><td>"+err_emp_mail+"</td></tr>");
			out.println("</table><br/><tr><button type=\"submit\" value=\"Submit\">Submit</button></tr></center></form></body>");
		}else {
			chain.doFilter(request, response);
		}
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
