package com.practice.jdbc.session1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.IOException;

public class Jdbc23InsertRowUsingResultSet {
	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		try {
			connection = JdbcUtil.getConnection();
			if(connection != null) {
				String query = "SELECT * FROM employee WHERE is_deleted = 0";
				pstmt = connection.prepareStatement(query,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
				resultSet = pstmt.executeQuery();
				if (resultSet != null) {
					System.out.println("Data before inserting");
					System.out.println("id\tname\tage\taddress\tsalary");
					while (resultSet.next()) {
						System.out.println(resultSet.getLong(1) + "\t" + resultSet.getString(2) + "\t"
								+ resultSet.getInt(3) + "\t" + resultSet.getString(4) + "\t" + resultSet.getLong(5));
					}
					
					//Inserting an data using ResultSet
					resultSet.moveToInsertRow();
					resultSet.updateString(2,"hari");
					resultSet.updateInt(3,37);
					resultSet.updateString(4,"BLR");
					resultSet.updateLong(5,100000L);
					resultSet.insertRow();
					
					resultSet.beforeFirst();
					System.out.println("Data posting inserting");
					System.out.println("id\tname\tage\taddress\tsalary");
					while (resultSet.next()) {
						System.out.println(resultSet.getLong(1) + "\t" + resultSet.getString(2) + "\t"
								+ resultSet.getInt(3) + "\t" + resultSet.getString(4) + "\t" + resultSet.getLong(5));
					}
				}
			}
		}catch(SQLException | IOException e) {
			System.out.println("Exception occured while performing operations :: "+e);
		}finally{
			try {
				JdbcUtil.cleanUp(connection,pstmt,resultSet);
			}catch(SQLException e) {
				System.out.println("Exception occurred while closing the resourcess");
			}
		}
	}
}
