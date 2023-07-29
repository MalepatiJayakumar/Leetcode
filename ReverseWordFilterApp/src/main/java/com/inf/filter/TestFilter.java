package com.inf.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

import com.inf.customizedResponse.CustomizedResponseWrapper;

@WebFilter("/reverse")
public class TestFilter implements Filter {

    public TestFilter() {
    }

	public void destroy() {
	}
	/*
	 * Getting an overrided response method to customize println method in Response object.
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		CustomizedResponseWrapper customizedResponse = new CustomizedResponseWrapper((HttpServletResponse)response);
		chain.doFilter(request, customizedResponse);
	}
	
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
