package com.practice.jdbc.session1;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Jdbc27ReadDataFromCSVFile {
	public static void main(String[] args) {
		final String url = "jdbc:Text:///D:\\Technical Learning\\Notes";
		String query = "select * from testCSV.csv";
		try (Connection connection = DriverManager.getConnection(url);
				PreparedStatement pstmt = connection.prepareStatement(query);
				ResultSet resultSet = pstmt.executeQuery()) {
			if(resultSet != null) {
				System.out.println("Age\tName\tCity");
				while(resultSet.next()) {
					System.out.println(resultSet.getInt(1)+"\t"+resultSet.getString(2)+"\t"+resultSet.getString(3));
				}
			}
		} catch (SQLException se) {
			System.out.println("Exception occurred while reading csv data :: " + se);
		}
	}
}

/*
 * Getting below Error while executing, need to check for solution
Exception in thread "main" java.lang.NoSuchMethodError: 'com.caigen.c.b3 com.hxtt.sql.em.a(int, java.lang.String, java.util.Properties)'
	at com.hxtt.sql.text.EmbeddedDriver.connect(Unknown Source)
	at com.caigen.sql.b.a(Unknown Source)
	at com.hxtt.sql.HxttDriver.if(Unknown Source)
	at com.hxtt.sql.HxttDriver.connect(Unknown Source)
	at java.sql/java.sql.DriverManager.getConnection(DriverManager.java:677)
	at java.sql/java.sql.DriverManager.getConnection(DriverManager.java:251)
	at com.practice.jdbc.session1.Jdbc27ReadDataFromCSVFile.main(Jdbc27ReadDataFromCSVFile.java:29)
*/

