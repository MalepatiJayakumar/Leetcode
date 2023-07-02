package in.fplanner.persistence;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.fplanner.Util.Constants;
import in.fplanner.Util.JdbcUtil;
import in.fplanner.dto.Employee;

//Persistence logic
public class EmployeeDAOImpl implements IEmployeeDAO {

	private Connection connection = null;
	private PreparedStatement pstmt = null;
	private ResultSet resultSet = null;

	@Override
	public String addEmployee(String name, Long age, String address) {
		String insertQuery = "INSERT INTO employee(name,age,address) VALUES(?,?,?)";
		try {
			connection = JdbcUtil.getConnection();
			if (connection != null) {
				pstmt = connection.prepareStatement(insertQuery);
				pstmt.setString(1, name);
				pstmt.setLong(2, age);
				pstmt.setString(3, address);

				int rowsAffected = pstmt.executeUpdate();
				if (rowsAffected > 0) {
					return Constants.SUCCESS;
				}
				return Constants.FAILED;
			}
		} catch (SQLException | IOException e) {
			System.out.println("Exception occured in addStudent in StudentDAOImpl >> e :: " + e);
		} finally {
			try {
				JdbcUtil.cleanUp(connection, pstmt, resultSet);
			} catch (SQLException e) {
				System.out.println("Exception occured in addStudent in StudentDAOImpl >> while closing resources :: " + e);
			}
		}
		return null;
	}

	@Override
	public Employee searchEmployee(Long id) {
		String query = "SELECT * FROM employee WHERE pk_id = ? and is_deleted=0";
		Employee emp = null;
		try {
			connection = JdbcUtil.getConnection();
			if (connection != null) {
				pstmt = connection.prepareStatement(query);
				pstmt.setLong(1, id);
				resultSet = pstmt.executeQuery();
				if (resultSet != null) {
					while (resultSet.next()) {
						emp = new Employee(resultSet.getLong(1), resultSet.getString(2), resultSet.getInt(3),
								resultSet.getString(4), resultSet.getLong(5));
					}
				}
			}
		}catch(SQLException | IOException e) {
			
		}finally {
			try {
				JdbcUtil.cleanUp(connection, pstmt, resultSet);
			} catch (SQLException e) {
				System.out.println("Exception occured in addStudent in StudentDAOImpl >> while closing resources :: " + e);
			}
		}
		return emp;
	}

	@Override
	public String updateEmployee(Long uid, String name, Long age, String address) {
		return null;
	}

	@Override
	public String deleteEmployee(Long id) {
		String query = "UPDATE employee SET is_deleted = 1 WHERE pk_id = ?";
		try {
			connection = JdbcUtil.getConnection();
			if (connection != null) {
				pstmt = connection.prepareStatement(query);
				pstmt.setLong(1, id);
				int rowsAffected = pstmt.executeUpdate();
				if (rowsAffected > 0) {
					return Constants.SUCCESS;
				}
			}
		} catch (SQLException | IOException e) {
			System.out.println("Exception occured in deleteStudent in StudentDAOImpl >> while deleting employee");
		} finally {
			try {
				JdbcUtil.cleanUp(connection, pstmt, resultSet);
			} catch (SQLException e) {
				System.out.println(
						"Exception occured in deleteStudent in StudentDAOImpl >> while closing resources :: " + e);
			}
		}
		return Constants.FAILED;
	}

	@Override
	public List<Employee> getAllEmployees() {
		String query = "select * from employee where is_deleted = 0";
		List<Employee> employees = new ArrayList<>();
		try {
			connection = JdbcUtil.getConnection();
			if(connection != null) {
				pstmt = connection.prepareStatement(query);
				resultSet = pstmt.executeQuery();
				if(resultSet != null) {
					while(resultSet.next()) {
						Employee tempEmp = new Employee(resultSet.getLong(1),resultSet.getString(2),resultSet.getInt(3),resultSet.getString(4),resultSet.getLong(5));
						employees.add(tempEmp);
					}
				}
			}
		}catch(SQLException | IOException e) {
			
		}finally {
			try {
				JdbcUtil.cleanUp(connection, pstmt, resultSet);
			} catch (SQLException e) {
				System.out.println(
						"Exception occured in getAllEmployees in StudentDAOImpl >> while closing resources :: " + e);
			}
		}
		return employees;
	}

}
