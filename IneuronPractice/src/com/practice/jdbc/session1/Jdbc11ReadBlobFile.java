package com.practice.jdbc.session1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Jdbc11ReadBlobFile {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		try {
			connection = JdbcUtil.getConnection();
			if (connection == null) {
				System.out.println("no connection");
				System.exit(0);
			}
			String query = "SELECT first_name,photo FROM `student` WHERE roll_number =?";
			pstmt = connection.prepareStatement(query);
			readAndSaveFile(pstmt, resultSet);
		} catch (SQLException | IOException e) {
			System.out.println("Exception :: " + e);
		} finally {
			try {
				JdbcUtil.cleanUp(connection, pstmt, resultSet);
			} catch (SQLException e) {
				System.out.println("Exception occured while closing resources");
			}
		}
	}

	public static void readAndSaveFile(PreparedStatement pstmt, ResultSet resultSet) throws SQLException, IOException {
		System.out.println("Enter uid for fetching Image");
		Long rollNumber = scan.nextLong();
		pstmt.setLong(1, rollNumber);
		resultSet = pstmt.executeQuery();
		while (resultSet.next())
		{
			String firstName = resultSet.getString(1);
			InputStream in = resultSet.getBinaryStream(2);
			FileOutputStream fos = new FileOutputStream(new File(firstName+".jpg"));
			int data = in.read();
			while (data != -1) {
				fos.write(data);
				data = in.read();
			}
			fos.close();
			in.close();
		}
	}
}
