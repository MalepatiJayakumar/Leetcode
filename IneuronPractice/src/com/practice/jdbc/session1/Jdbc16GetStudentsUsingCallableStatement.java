package com.practice.jdbc.session1;


import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;
import java.io.IOException;

/**
 * @author jaiKumar
 * 
 * 	DELIMITER $$
	USE `localhost`$$
	DROP PROCEDURE IF EXISTS `GET_STUDENT_BY_UID`$$
	CREATE DEFINER=`root`@`localhost` PROCEDURE `GET_STUDENT_BY_UID`(IN rl INT , OUT fName VARCHAR(255),mName VARCHAR(255), OUT lName VARCHAR(255),OUT age INT , OUT city VARCHAR(255))
		BEGIN
			SELECT first_name,middle_name,last_name,age,city INTO fName,mName,lName,age,city FROM student WHERE roll_number = rl;
		END$$
	DELIMITER ;
	
	
	
	CALL `GET_STUDENT_BY_UID`(1061,@fName,@mName,@lName,@age,@city);
 *
 */
public class Jdbc16GetStudentsUsingCallableStatement {

	public static final String studentCallableStmt = "{CALL `GET_STUDENT_BY_UID`(?,?,?,?,?,?)}";

	public static void main(String[] args) {
		Connection connection = null;
		CallableStatement cstmt = null;
		Scanner scan = new Scanner(System.in);
		try {
			connection  = JdbcUtil.getConnection();
			if (connection != null) {
				cstmt = connection.prepareCall(studentCallableStmt);
				if (cstmt != null) {
					System.out.println("Please enter UID for getting details");
					Long uid = scan.nextLong();
					cstmt.setLong(1, uid);

					// set dataTypes
					cstmt.registerOutParameter(2, Types.VARCHAR);
					cstmt.registerOutParameter(3, Types.VARCHAR);
					cstmt.registerOutParameter(4, Types.VARCHAR);
					cstmt.registerOutParameter(5, Types.BIGINT);
					cstmt.registerOutParameter(6, Types.VARCHAR);
					//execute stored procedure
					cstmt.execute();
					
					//get the details
					System.out.println("first Name :: "+cstmt.getString(2));
					System.out.println("middle Name :: "+cstmt.getString(3));
					System.out.println("last Name :: "+cstmt.getString(4));
					System.out.println("Age :: "+cstmt.getString(5));
					System.out.println("city :: "+cstmt.getString(6));
				}
			}
		}catch(SQLException|IOException e) {
			System.out.println("Exception occurred :: "+e);
		}finally {
			try {
				scan.close();
				JdbcUtil.cleanUp(connection,cstmt,null);
			}catch(SQLException e) {
				
			}
		}
	}

}