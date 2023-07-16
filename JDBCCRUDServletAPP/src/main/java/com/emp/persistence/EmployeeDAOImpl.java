package com.emp.persistence;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.emp.Util.Constants;
import com.emp.Util.JdbcUtil;
import com.emp.dto.Employee;

public class EmployeeDAOImpl implements IEmployeeDAO {

	Connection connection = null;
	PreparedStatement pstmt = null;
	ResultSet resultSet = null;

	@Override
	public String addEmployee(Employee employee) throws SQLException {
		try {
			connection = JdbcUtil.getConnection();
			if (connection != null) {
				String query = "INSERT INTO employee(`name`,age,address,salary) VALUES(?,?,?,?)";
				pstmt = connection.prepareStatement(query);
				pstmt.setString(1,employee.getName());
				pstmt.setInt(2,employee.getAge());
				pstmt.setString(3,employee.getAddress());
				pstmt.setDouble(4,employee.getSalary());
				Integer rowsAffected = pstmt.executeUpdate();
				if(rowsAffected > 0) {
					return Constants.SUCCESS;
				}
			}
		} catch (SQLException | IOException e) {
			System.out.println("Inside addEmployee in EmployeeDAOImpl >> exception :: "+e);
		} finally {
			try {
				JdbcUtil.cleanUp(connection, pstmt, resultSet);
			} catch (SQLException e) {
				System.out.println("Inside addEmployee in EmployeeDAOImpl >> exception while closing resource :: "+e);
				throw e;
			}
		}
		return Constants.FAILED;
	}

	@Override
	public Employee searchEmployee(Long id) throws IOException {
		Employee emp =null;
		try {
			connection = JdbcUtil.getConnection();
			if(connection != null) {
				String query = "select * from employee where pk_id =? and is_deleted=0";
				pstmt = connection.prepareStatement(query);
				pstmt.setLong(1,id);
				resultSet = pstmt.executeQuery();
				while(resultSet.next()) {
					String name = resultSet.getString(2);
					Integer age = resultSet.getInt(3);
					String address = resultSet.getString(4);
					Double salary = resultSet.getDouble(5);
					emp = new Employee(name,age,address,salary);
				}
			}
		}catch(SQLException e) {
			System.out.println("Inside searchEmployee in EmployeeDAOImpl >> exception occurred while searching for employee :: "+e);
		}finally {
			try {
				JdbcUtil.cleanUp(connection,pstmt,resultSet);
			}catch(SQLException e) {
				System.out.println("Inside searchEmployee in EmployeeDAOImpl >> exeception while closing resource :: "+e);
			}
		}
		return emp;
	}

	@Override
	public String updateEmployee(Employee employee) {
		return null;
	}

	@Override
	public String deleteEmployee(Long id) {
		return null;
	}
}