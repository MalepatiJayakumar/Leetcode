package com.practice.jdbc.session1;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConvertDate {
	
	public static void main(String[] args) throws ParseException {
		DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		Date utilDate = format.parse("03-08-2001");
		System.out.println(utilDate);
		java.sql.Date sqlDate =  new java.sql.Date(utilDate.getTime());
		System.out.println(sqlDate);
	}
}