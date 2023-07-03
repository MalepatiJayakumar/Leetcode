package com.practice.jdbc.session1;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class Jdbc31GetDataAfterDisconnectedUsingCachedRowSet {
	public static void main(String[] args) throws SQLException {
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		try {
			connection = JdbcUtil.getConnection();
			if (connection != null) {
				String query = "SELECT * FROM employee WHERE is_deleted = 0";
				pstmt = connection.prepareStatement(query);
				resultSet = pstmt.executeQuery();

				/*
				 * If we close the connection in before accessing data then we cannot access the
				 * data, so below commented won't give expected result
				 */

//				connection.close();
//				System.out.println("id\tname\tage\taddress\tsalary");
//				while (resultSet.next()) {
//					System.out.println(resultSet.getLong(1) + "\t" + resultSet.getString(2) + "\t"
//							+ resultSet.getInt(3) + "\t" + resultSet.getString(4) + "\t" + resultSet.getDouble(5));
//				}
				/*java.sql.SQLException: Operation not allowed after ResultSet closed
					at com.mysql.cj.jdbc.exceptions.SQLError.createSQLException(SQLError.java:130)
					at com.mysql.cj.jdbc.exceptions.SQLError.createSQLException(SQLError.java:98)
					at com.mysql.cj.jdbc.exceptions.SQLError.createSQLException(SQLError.java:90)
					at com.mysql.cj.jdbc.exceptions.SQLError.createSQLException(SQLError.java:64)
					at com.mysql.cj.jdbc.result.ResultSetImpl.checkClosed(ResultSetImpl.java:485)
					at com.mysql.cj.jdbc.result.ResultSetImpl.next(ResultSetImpl.java:1802)
					at com.practice.jdbc.session1.Jdbc31GetDataAfterDisconnectedUsingCachedRowSet.main(Jdbc31GetDataAfterDisconnectedUsingCachedRowSet.java:32)
				 */

				/*
				 * To work even after connection got disconnected we have CachedRowSet , where
				 * we pass resultSet to cachedRowSet for storing so that we use post that.
				 */
				RowSetFactory rsf = RowSetProvider.newFactory();
				CachedRowSet crs = rsf.createCachedRowSet();
				crs.populate(resultSet);
				connection.close();
				System.out.println("id\tname\tage\taddress\tsalary");
				while (crs.next()) {
					System.out.println(crs.getLong(1) + "\t" + crs.getString(2) + "\t"
							+ crs.getInt(3) + "\t" + crs.getString(4) + "\t" + crs.getDouble(5));
				}
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		} finally {
			try {
				JdbcUtil.cleanUp(connection, pstmt, resultSet);
			} catch (SQLException e) {

			}
		}
	}
}
