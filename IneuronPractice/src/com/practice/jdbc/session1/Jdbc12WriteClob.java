package com.practice.jdbc.session1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;

import java.util.Scanner;

public class Jdbc12WriteClob {
	
	public static void main(String[] args) {
		Connection connection   = null;
		PreparedStatement pstmt = null;
		Scanner scan = new Scanner(System.in);
		try {
			connection = JdbcUtil.getConnection();
			if(connection != null) {
				String query = "UPDATE student SET `file` = ? WHERE roll_number = ?";
				pstmt = connection.prepareStatement(query);
				
				System.out.println("Enter student UID to upload file");
				Long id = scan.nextLong();
				System.out.println("please enter file path to upload");
				String filePath = scan.next();
				
				pstmt.setLong(2,id);
				pstmt.setCharacterStream(1,new FileReader(new File(filePath)));
				
				int rowsAffected = pstmt.executeUpdate();
				System.out.println(rowsAffected+" number of rows Affected");
			}
		}catch(SQLException|IOException e) {
			System.out.println("Exception occured while saving CLOB file in DB :: "+e);
		}finally {
			try {
				JdbcUtil.cleanUp(connection,pstmt,null);
				scan.close();
			}catch(SQLException e) {
				
			}
		}
	}

}
