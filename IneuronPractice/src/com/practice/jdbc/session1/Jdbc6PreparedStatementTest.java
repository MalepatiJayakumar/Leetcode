package com.practice.jdbc.session1;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Jdbc6PreparedStatementTest {
	
	public static void main(String[] args) {
		Connection connection   = null;
		PreparedStatement pstmt = null;
		try {
			connection = JdbcUtil.getConnection();
			String query = "INSERT INTO student(roll_number,first_name,middle_name,last_name,age,city) VALUES(?,?,?,?,?,?)";
			pstmt = connection.prepareStatement(query);
			pstmt.setLong(1,1068);
			pstmt.setString(2,"sathish");
			pstmt.setString(3,"kumar");
			pstmt.setString(4,"reddy");
			pstmt.setLong(5,20);
			pstmt.setString(6,"HYD");
			
			int rowsAffected = pstmt.executeUpdate();
			System.out.println(rowsAffected+" number of rows affected");
		}catch(SQLException|IOException e) {
			System.out.println("Exception occured :: "+e);
		}
		finally {
			try {
				JdbcUtil.cleanUp(connection,pstmt,null);
			}catch(SQLException e) {
				System.out.println("Exception occured while closing resource :: "+e);
			}
		}
	}

}
