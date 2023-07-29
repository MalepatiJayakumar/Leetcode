package com.inf.customizedResponse;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class CustomizedResponseWrapper  extends HttpServletResponseWrapper {

	public CustomizedResponseWrapper(HttpServletResponse response) {
		super(response);
	}
	
	/*
	 * Here we are overriding getWriter method of Response object through customized
	 * Response object , where as in Writer Class we overrided println method. To
	 * change data based on the input.
	 */
	@Override
	public PrintWriter getWriter() {
		PrintWriter out;
		Writer writer = null;
		try {
			out = super.getWriter();
			writer = new Writer(out);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return writer;
	}
}
