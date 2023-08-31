package com.practice.util;

public class JdbcHelper {

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			
		}
	}

}
