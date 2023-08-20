package com.practice.custom.action;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

public class HelloHandler implements Tag {
	
	private PageContext pageContext;
	private String name;
	
	static {
		System.out.println("HelloHandler.static block");
	}
	
	public HelloHandler() {
		System.out.println("HelloHandler.HelloHandler()");
	}
	
	@Override
	public int doEndTag() throws JspException {
		System.out.println("HelloHandler.doEndTag()");
		/*
		 * public static final int SKIP_PAGE = 5;
		 * public static final int EVAL_PAGE = 6;
		 * 
		 * if we return SKIP_PAGE then body post these custom tag will be ignored and not included in output , 
		 * if we return EVAL_PAGE then JSP will be evaluated after custom tag completion also
		 */
		return EVAL_PAGE;
	}

	@Override
	public int doStartTag() throws JspException {
		System.out.println("HelloHandler.doStartTag()");
		/*
		 * Getting writer object from page context so we have setPageContext method in HelloHandler(Tag(I))
		 */
		try {
			JspWriter out = pageContext.getOut();
			out.println("<h1>Inside HelloHandler in doStartTag() method</h1>");
			if(name == null) {
				out.println("<h1>Hello Guest ..... Good evening</h1>");
			}else {
				out.println("<h1>Hello "+name+" ... Good evening</h1>");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		 * These are from TAG interface
		 * public static final int SKIP_BODY = 0;
		 * public static final int EVAL_BODY_INCLUDE = 1;
		 * 
		 * Based on the return type of above variables only body will be included or excluded, if we retuen SKIP_BODY then body inside custom tags will be excluded.
		 * If we return EVAL_BODY_INCLUDE then body inside custom tags will be included for output
		 */
		return EVAL_BODY_INCLUDE;
	}

	public Tag getParent() {
		System.out.println("HelloHandler.getParent()");
		return null;
	}

	@Override
	public void release() {
		/*
		 * Just like an destroy method to clear whole things post custom action execution
		 */
		System.out.println("HelloHandler.release()");
	}

	@Override
	public void setPageContext(PageContext pageContext) {
		/*
		 * Setting pageContext to instant variable so that we can extract info or writer object in any method
		 */
		this.pageContext = pageContext;
		System.out.println("HelloHandler.setPageContext()");
	}

	@Override
	public void setParent(Tag arg0) {
		System.out.println("HelloHandler.setParent()");
	}
	
	public void setName(String name) {
		System.out.println("HelloHandler.setName()");
		this.name = name;
	}
	public String getName() {
		System.out.println("HelloHandler.getName()");
		return this.name;
	}
}