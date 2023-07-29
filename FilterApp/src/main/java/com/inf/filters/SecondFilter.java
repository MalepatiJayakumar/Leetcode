package com.inf.filters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public class SecondFilter implements Filter {

	static {
		System.out.println("SecondFilter has been loaded");
	}
	
    public SecondFilter() {
    	System.out.println("SecondFilter object has been instantiated");
    }
    
    public void init(FilterConfig fConfig) throws ServletException {
    	System.out.println("Inside SecondFilter in init method");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    	PrintWriter out = response.getWriter();
    	out.println("Inside SecondFilter in doFilter method >> before calling servlet through filter chain");
    	// pass the request along the filter chain
    	chain.doFilter(request, response);
    }

    public void destroy() {
    	System.out.println("Filter object has been destroyed");
	}

}

/* console output before triggering request
 * ========================================
 * FirstFilter has been loaded
 * FirstFilter object has been instantiated
 * Inside FirstFilter in init method
 * 
 * No need to write load-on-startup for Filters to load without request, Filters will load at the time of container loading
 */
