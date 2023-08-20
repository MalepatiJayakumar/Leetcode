package com.practice.custom.action;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.IterationTag;
import javax.servlet.jsp.tagext.Tag;

public class HelloHandler implements IterationTag {

	private PageContext pageContext;
	private Integer count;
	private JspWriter out;
	
	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	@Override
	public int doEndTag() throws JspException {
		System.out.println("HelloHandler.doEndTag()");
		if(count > 0) {
			return EVAL_PAGE;
		}
		return SKIP_PAGE;
	}
	
	@Override
	public int doStartTag() throws JspException {
		System.out.println("HelloHandler.doStartTag()");
		try {
			out.println("Inside doStartTag() in HelloHandler ");
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (count > 0) {
			return EVAL_BODY_INCLUDE;
		}
		return SKIP_BODY;
	}

	@Override
	public Tag getParent() {
		System.out.println("HelloHandler.getParent()");
		return null;
	}

	@Override
	public void release() {
		System.out.println("HelloHandler.release()");

	}

	@Override
	public void setPageContext(PageContext pageContext) {
		this.pageContext = pageContext;
		out = pageContext.getOut();
		System.out.println("HelloHandler.setPageContext()");
	}

	@Override
	public void setParent(Tag arg0) {
		System.out.println("HelloHandler.setParent()");
	}

	@Override
	public int doAfterBody() throws JspException {
		System.out.println("HelloHandler.doAfterBody()");
		if(--count > 0) {
			return EVAL_BODY_AGAIN;
		}
		return 0;
	}

}
