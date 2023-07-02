package com.practice.jdbc.session1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Jdbc25ReadExcepUsingJDBC {
	public static void main(String[] args) {
		final String url = "jdbc:Excel:///D:\\Technical Learning\\Notes";
		// select * from workbook.worksheet_name
		String query = "select * from data.student";
		try (Connection connection = DriverManager.getConnection(url);
				PreparedStatement pstmt = connection.prepareStatement(query);
				ResultSet resultSet = pstmt.executeQuery()) {
			if (resultSet != null) {
				System.out.println("Age\tName\tCity");
				while (resultSet.next()) {
					System.out.println(
							resultSet.getLong(1) + "\t" + resultSet.getString(2) + "\t" + resultSet.getString(3));
				}
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}
}