package com.inf.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import com.inf.customizedRequests.CustomizedServletRequestWrapper;

@WebFilter("/test")
public class RequestChangeFilter implements Filter {

	public RequestChangeFilter() {
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		CustomizedServletRequestWrapper customizedRequest = new CustomizedServletRequestWrapper(
				(HttpServletRequest) request);
		chain.doFilter(customizedRequest, response);
	}

	public void destroy() {
	}
}
