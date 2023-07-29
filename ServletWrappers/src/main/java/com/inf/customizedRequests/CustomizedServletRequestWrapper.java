package com.inf.customizedRequests;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
public class CustomizedServletRequestWrapper extends HttpServletRequestWrapper {
	
	private static List<String> validCourses =new ArrayList<>();
	
	static {
		validCourses.add("java");
		validCourses.add("jee");
		validCourses.add("hibernate");
		validCourses.add("spring");
		validCourses.add("springboot");
	}
	
	public CustomizedServletRequestWrapper(HttpServletRequest request) {
		super(request);
	}
	
	@Override
	public String getParameter(String name) {
		String value = super.getParameter(name);
		if (validCourses.contains(value)) {
			return "INTRESTED";
		}
		return "NOT INTRESTED";
	}

}
