package com.practice.jdbc.session1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.io.IOException;

/**
 * @author JaiKumar
 *
 */
public class Jdbc18BarchUpdateUsingPreparedStatement {
	public static void main(String[] args) {
		Connection connection 	= null;
		PreparedStatement pstmt 	= null;
		Scanner scan = new Scanner(System.in);
		try {
			connection = JdbcUtil.getConnection();
			if(connection != null) {
				String query = "INSERT INTO `user`(user_name,email,dob) VALUES(?,?,?)";
				pstmt = connection.prepareStatement(query);
				
				while(true) {
					System.out.println("Enter user Name ");
					String userName = scan.next();
					System.out.println("Enter email address");
					String email = scan.next();
					System.out.println("Enter date in dd-mm-yyyy format");
					String date = scan.next();
					
					pstmt.setString(1,userName);
					pstmt.setString(2,email);
					pstmt.setDate(3,getDate(date));
					
					
					pstmt.addBatch();
					
					System.out.println("Do you want to insert one more record [Yes/No]");
					String continueFlag = scan.next();
					if("no".equalsIgnoreCase(continueFlag)) {
						break;
					}
				}
				
				//execute the query
				pstmt.executeBatch();
				
				
			}
		}catch(SQLException|IOException|ParseException e) {
			System.out.println("Exception occured :: "+e);
		}finally {
			try {
				JdbcUtil.cleanUp(connection,pstmt,null);
				scan.close();
			}catch(SQLException e) {
				System.out.println("Exception occured while closing the resource :: "+e);
			}
		}
	}
	public static java.sql.Date getDate(String strDate) throws ParseException{
		DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		Date utilDate = format.parse(strDate);
		java.sql.Date sqlDate =  new java.sql.Date(utilDate.getTime());
		return sqlDate;
	}
}
