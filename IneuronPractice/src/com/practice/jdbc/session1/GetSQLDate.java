package com.practice.jdbc.session1;

import java.util.Date;

public class GetSQLDate {

	public static void main(String[] args) {
		
		Date date = new Date();
		System.out.println(date);
		long time = date.getTime();
		
		java.sql.Date date1 = new java.sql.Date(time);
		System.out.println(date1);
		
	}
	
}
