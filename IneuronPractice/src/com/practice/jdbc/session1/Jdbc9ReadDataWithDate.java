package com.practice.jdbc.session1;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * @author JaiKumar
 *
 */
public class Jdbc9ReadDataWithDate {
	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;

		try {
			connection = JdbcUtil.getConnection();
			if (connection != null) {
				String query = "SELECT user_name,email,dob FROM `user` WHERE is_deleted =0";
				pstmt = connection.prepareStatement(query);
				resultSet = pstmt.executeQuery();
				if (resultSet != null) {
					readResult(resultSet);
					System.out.println("Data read successfully...");
				}
			}
		} catch (SQLException | IOException e) {
			System.out.println("Exception occured while reading data from Database");
		} catch (Exception e) {

		} finally {
			try {
				JdbcUtil.cleanUp(connection, pstmt, resultSet);
			} catch (Exception e) {

			}
		}
	}

	private static void readResult(ResultSet resultSet) throws SQLException {
		System.out.println("name\temail\t\tdob");
		while (resultSet.next()) {
			String name = resultSet.getString(1);
			String email = resultSet.getString(2);
			java.sql.Date dob = resultSet.getDate(3);
			System.out.println(name + "\t" + email + "\t\t" + dob.toString());
		}
	}
}