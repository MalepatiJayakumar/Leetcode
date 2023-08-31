package com.practice.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.practice.dto.Employee;
import com.practice.util.JdbcHelper;

public class EmployeeDAOImpl implements IEmployeeDAO {
	
	private Connection connection = null;
	private PreparedStatement pstmt = null;
	private ResultSet resultSet = null;
	
	@Override
	public Employee getEmployee(Long id) {
		Employee emp = new Employee();
		try {
			connection = JdbcHelper.getConnection();
			if(connection != null) {
				pstmt = connection.prepareStatement("SELECT * FROM employee WHERE pk_id=?");
				pstmt.setLong(1,id);
				resultSet = pstmt.executeQuery();
				if(resultSet != null) {
					while(resultSet.next()) {
						emp.setEmpName(resultSet.getString("name"));
						emp.setEmpId(resultSet.getLong("pk_id"));
						emp.setAge(resultSet.getInt("age"));
						emp.setAddress(resultSet.getString("address"));
						emp.setSalary(resultSet.getDouble("salary"));
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emp;
	}
}