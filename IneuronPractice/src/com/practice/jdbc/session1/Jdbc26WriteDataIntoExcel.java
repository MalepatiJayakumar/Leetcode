package com.practice.jdbc.session1;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Jdbc26WriteDataIntoExcel {
	public static void main(String[] args) {
		// written as Excel as we are working on Excel.
		final String url = "jdbc:Excel:///D:\\Technical Learning\\Notes";
		String query = "insert into data.student values(?,?,?)";
		Integer age = null;
		String name = null, city = null;
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter age :: ");
		age = scan.nextInt();
		System.out.print("Enter name :: ");
		name = scan.next();
		System.out.print("Enter city :: ");
		city = scan.next();
		
		try (Connection connection = DriverManager.getConnection(url);
				PreparedStatement pstmt = connection.prepareStatement(query)) {
			pstmt.setInt(1,age);
			pstmt.setString(2,name);
			pstmt.setString(3,city);
			int result = pstmt.executeUpdate();
			if(result >= 1) {
				System.out.println("Data inserted successfully....");
			}
			else {
				System.out.println("Data insertion failed");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(scan != null) {
				scan.close();
			}
		}
	}
}
