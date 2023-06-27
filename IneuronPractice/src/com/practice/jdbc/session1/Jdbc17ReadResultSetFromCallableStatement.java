package com.practice.jdbc.session1;

import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.io.IOException;

import java.util.Scanner;


/**
 * @author JaiKumar
 * 
 * 	DELIMITER $$
	USE `localhost`$$
	DROP PROCEDURE IF EXISTS `GET_STUDENT_BY_LAST_NAME`$$
	CREATE DEFINER=`root`@`localhost` PROCEDURE `localhost`.`GET_STUDENT_BY_LAST_NAME`(IN name1 VARCHAR(255))
		BEGIN
			SELECT roll_number,first_name,middle_name,last_name,age,city FROM student WHERE last_name= name1;
		END$$
	DELIMITER ;

//calling stored procedure
	CALL `GET_STUDENT_BY_LAST_NAME`('reddy');
 *
 */
public class Jdbc17ReadResultSetFromCallableStatement {
	public static final String storedProcedure = "{CALL `GET_STUDENT_BY_LAST_NAME`(?)}";
	public static void main(String[] args) {
		Connection connection = null;
		CallableStatement cstmt = null;
		ResultSet resultSet = null;
		Scanner scan = new Scanner(System.in);
		
		try {
			connection = JdbcUtil.getConnection();
			if (connection != null) {
				cstmt = connection.prepareCall(storedProcedure);
				if (cstmt != null) {
					System.out.println("Enter last name to search :: ");
					String lastName = scan.next();

					if (lastName != null) {
						cstmt.setString(1, lastName);
					}
					cstmt.execute();
					resultSet = cstmt.getResultSet();
					System.out.println("ID\tFName\tMName\tLName\tAge\tCity");
					boolean isDataPresent = false;
					Integer noOfRecords = 0;
					while (resultSet.next()) {
						// roll_number,first_name,middle_name,last_name,age,city
						System.out.println(resultSet.getLong(1) + "\t" + resultSet.getString(2) + "\t"
								+ resultSet.getString(3) + "\t" + resultSet.getString(4) + "\t" + resultSet.getLong(5)
								+ "\t" + resultSet.getString(6));
						isDataPresent = true;
						noOfRecords++;
					}
					if(isDataPresent) {
						System.out.println(noOfRecords+" number of records present..");
					}else {
						System.out.println("No records found..");
					}
				}
			}
		}catch(SQLException| IOException e) {
			System.out.println("Exception occured :: "+e);
		}
		finally {
			try {
				JdbcUtil.cleanUp(connection,cstmt,resultSet);
				scan.close();
			}catch(SQLException e) {
				System.out.println("Exception occured while closing the resource :: "+e);
			}
		}
	}
	
}

/* 
 * Enter last name to search :: 
reddy
ID	FName	MName	LName	Age	City
1061	jai	kumar	reddy	21	HYD
1062	dhanush	null	reddy	18	CTR
1065	Eswar	null	reddy	28	HYD
1067	venkatesh	kumar	reddy	30	CHE
1068	shyam	kumar	reddy	27	CHE
1068	sathish	kumar	reddy	20	HYD
6 number of records present..
Connections has been closed successfully.
 * 
 */
