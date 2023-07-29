package com.inf.customizedResponse;

import java.io.PrintWriter;

public class Writer extends PrintWriter {

	PrintWriter out;

	public Writer(PrintWriter out) {
		super(out);
		this.out = out;
	}

	@Override
	public void println(String data) {
		if (!data.startsWith("<")) {
			System.out.println(data);
			StringBuffer sb = new StringBuffer(data);
			out.println(sb.reverse());
		} else {
			out.println(data);
		}
	}
}