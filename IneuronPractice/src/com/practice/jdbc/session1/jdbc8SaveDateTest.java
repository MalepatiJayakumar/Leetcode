package com.practice.jdbc.session1;

import java.util.Date;
import java.util.Scanner;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.io.IOException;

/**
 * @author JaiKumar
 * 
 */
public class jdbc8SaveDateTest {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement pstmt = null;

		try {
			connection = JdbcUtil.getConnection();
			if (connection != null) {
				String query = "INSERT INTO `user`(user_name,email,dob) VALUES(?,?,?)";
				pstmt = connection.prepareStatement(query);
				User user = getUser();
				if (user != null) {
					int rowsAffected = saveUser(pstmt, user);
					System.out.println(rowsAffected + " number of rows Affected");
				}
			}
		} catch (SQLException | IOException | ParseException e) {
			System.out.println("Exception occured while saving user");
		} finally {
			try {
				scan.close();
				JdbcUtil.cleanUp(connection, pstmt, null);
			} catch (SQLException e) {

			}
		}
	}

	public static User getUser() throws ParseException {
		System.out.println("Enter user name :: ");
		String name = scan.next();
		System.out.println("Enter user email :: ");
		String email = scan.next();
		System.out.println("Enter Date of Birth(dd-MM-yyyy) in provided format");
		java.sql.Date date = getDate(scan.next());
		return new User(name, email, date);
	}

	public static java.sql.Date getDate(String date) throws ParseException {
		DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		Date utilDate = format.parse(date);
		return new java.sql.Date(utilDate.getTime());
	}

	public static int saveUser(PreparedStatement pstmt, User user) throws SQLException {
		pstmt.setString(1, user.getUserName());
		pstmt.setString(2, user.getEmail());
		pstmt.setDate(3, user.getDate());
		int rowsAffected = pstmt.executeUpdate();
		return rowsAffected;
	}
}
