package com.practice.jdbc.session1;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;
import java.io.IOException;
import java.sql.CallableStatement;

/**
 * @author JaiKumar
 * 
 * 
 * DELIMITER $$
   USE `localhost`$$
   DROP PROCEDURE IF EXISTS `GET_USER_BY_ID`$$
   CREATE DEFINER=`root`@`localhost` PROCEDURE `GET_USER_BY_ID`(IN id INT , OUT `name` VARCHAR(255),OUT `email` VARCHAR(255),OUT `dob` DATETIME)
	BEGIN
		SELECT user_name,email,dob INTO `name`,email,dob FROM `user` WHERE pk_user_id = id;
	END$$
   DELIMITER ;
 *
 */
public class Jdbc15CallableStatementTest {

	private static final String storedProcedureCall = "{CALL GET_USER_BY_ID(?,?,?,?)}";

	public static void main(String[] args) {
		// Resource
		Connection connection = null;
		CallableStatement cstmt = null;
		Scanner scan = new Scanner(System.in);
		try {
			connection = JdbcUtil.getConnection();
			if (connection != null) {
				cstmt = connection.prepareCall(storedProcedureCall);
				if (cstmt != null) {
					System.out.println("Enter id to fetch user :: ");
					Long id = scan.nextLong();

					// setting the input values to callable statement
					if (cstmt != null) {
						cstmt.setLong(1, id);
					}

					// Setting the Datetype of output values
					if (cstmt != null) {
						cstmt.registerOutParameter(2, Types.VARCHAR);
						cstmt.registerOutParameter(3, Types.VARCHAR);
						cstmt.registerOutParameter(4, Types.DATE);
					}

					// run the stored procedure
					if (cstmt != null) {
						cstmt.execute();
					}

					// retreive the result
					if (cstmt != null) {
						System.out.println("User Name is :: " + cstmt.getString(2));
						System.out.println("User email is :: " + cstmt.getString(3));
						System.out.println("User dob  is :: " + cstmt.getDate(4));
					}
				}
			}
		} catch (SQLException | IOException e) {

		} finally {
			try {
				scan.close();
				JdbcUtil.cleanUp(connection, cstmt, null);
			} catch (SQLException e) {

			}
		}
	}

}
