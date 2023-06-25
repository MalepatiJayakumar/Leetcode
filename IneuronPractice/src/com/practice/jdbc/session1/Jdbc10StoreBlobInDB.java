package com.practice.jdbc.session1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * @author JaiKumar Get an image and insert into BD as blob
 *
 */
public class Jdbc10StoreBlobInDB {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		try {
			connection = JdbcUtil.getConnection();
			if (connection == null) {
				System.exit(0);
			}
			String query = "UPDATE student SET `photo` = ? WHERE roll_number = ?";
			pstmt = connection.prepareStatement(query);
			int rowsAffected = insertResume(pstmt);
			System.out.println(rowsAffected + " number of rows affected");
		} catch (SQLException | FileNotFoundException e) {
			System.out.println("exception :: " + e);
		} catch (Exception e) {
			System.out.println("exception :: " + e);
		} finally {
			try {
				JdbcUtil.cleanUp(connection, pstmt, null);
			} catch (SQLException e) {

			}
		}
	}

	public static int insertResume(PreparedStatement pstmt) throws FileNotFoundException, SQLException {
		System.out.println("Enter roll number of an person that you need to update Resume");
		Long rollNumber = scan.nextLong();

		System.out.println("Enter fully qualified path of resume to upload");
		String location = scan.next();

		FileInputStream fis = new FileInputStream(location);

		pstmt.setBinaryStream(1, fis);
		pstmt.setLong(2, rollNumber);

		int rowsAffected = pstmt.executeUpdate();
		return rowsAffected;
	}
}
