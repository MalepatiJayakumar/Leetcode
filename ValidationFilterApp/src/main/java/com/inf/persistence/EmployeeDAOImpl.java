package com.inf.persistence;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.inf.dto.Employee;
import com.inf.util.JdbcUtil;

public class EmployeeDAOImpl implements IEmployeeDAO {

	private Connection connection = null;
	private PreparedStatement pstmt = null;
	private ResultSet resultSet = null;
	
	@Override
	public Integer saveEmployee(Employee emp) {
		Integer rowCount = null;
		try {
			connection = JdbcUtil.getConnection();
			if (connection != null) {
				String insertQuery = "INSERT INTO employee(`name`,age,address,salary) VALUES(?,?,?,?)";
				pstmt = connection.prepareStatement(insertQuery);
				pstmt.setString(1, emp.getName());
				pstmt.setInt(2, emp.getAge());
				pstmt.setString(3, emp.getAddress());
				pstmt.setDouble(4, emp.getSalary());
				rowCount = pstmt.executeUpdate();
			}
		} catch (SQLException | IOException e) {
			System.out.println("Exception occurred while saving employee data into database");
		} finally {
			try {
				JdbcUtil.cleanUp(connection, pstmt, resultSet);
			} catch (SQLException e) {
				System.out.println("Exception occurred while closing the resource");
			}
		}
		return rowCount;
	}

}
