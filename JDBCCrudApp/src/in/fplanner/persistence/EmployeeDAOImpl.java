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

public class EmployeeDAOImpl implements IEmployeeDAO {
	
	Connection connection = null;
	PreparedStatement pstmt = null;
	ResultSet resultSet = null;
	
	@Override
	public Employee getEmployee(Long id) throws IOException, SQLException {
		Employee emp = null;
		try {
			connection = JdbcUtil.getConnection();
			if (connection != null) {
				String query = "SELECT * FROM employee WHERE is_deleted = 0 and pk_id = ?";
				pstmt = connection.prepareStatement(query);
				pstmt.setLong(1, id);
				resultSet = pstmt.executeQuery();
				while (resultSet.next()) {
					emp = new Employee(resultSet.getString(2), resultSet.getInt(3), resultSet.getString(4),
							resultSet.getDouble(5));
					emp.setId(resultSet.getLong(1));
				}
			}
		} catch (SQLException e) {
			System.out.println("Exception occurred while fetching employee from database :: " + e);
			throw e;
		} finally {
			try {
				JdbcUtil.cleanUp(connection, pstmt, resultSet);
			} catch (SQLException e) {
				System.out.println("Exception occurred while closing the resource :: " + e);
				throw e;
			}
		}
		return emp;
	}

	@Override
	public String addEmployee(Employee emp) throws Exception {
		if (emp != null) {
			try {
				connection = JdbcUtil.getConnection();
				if (connection != null) {
					String query = "INSERT INTO employee(`name`,age,address,salary) VALUES(?,?,?,?)";
					pstmt = connection.prepareStatement(query);
					pstmt.setString(1, emp.getName());
					pstmt.setInt(2, emp.getAge());
					pstmt.setString(3, emp.getAddress());
					pstmt.setDouble(4, emp.getSalary());
					Integer rowsAffected = pstmt.executeUpdate();
					if (rowsAffected != null && rowsAffected > 0) {
						return Constants.SUCCESS;
					}
				}
			} catch (SQLException | IOException e) {
				System.out.println("Exception occurred while adding employee :: " + e);
				throw e;
			} finally {
				try {
					JdbcUtil.cleanUp(connection, pstmt, resultSet);
				} catch (SQLException e) {
					System.out.println("Exception occurred while closing the resource :: " + e);
					throw e;
				}
			}
		}
		return Constants.FAILED;
	}

	@Override
	public List<Employee> getAllEmployees() throws Exception {
		List<Employee> employees = new ArrayList<>();
		try {
			connection = JdbcUtil.getConnection();
			if (connection != null) {
				String query = "SELECT * FROM employee WHERE is_deleted = 0";
				pstmt = connection.prepareStatement(query);
				resultSet = pstmt.executeQuery();
				if (resultSet != null) {
					while (resultSet.next()) {
						Employee emp = new Employee(resultSet.getString(2), resultSet.getInt(3), resultSet.getString(4),
								resultSet.getDouble(5));
						emp.setId(resultSet.getLong(1));
						employees.add(emp);
					}
				}
			}
		} catch (SQLException | IOException e) {
			System.out.println("Exception occurred while fetching employees :: " + e);
			throw e;
		}finally {
			try {
				JdbcUtil.cleanUp(connection,pstmt,resultSet);
			}catch(SQLException e) {
				System.out.println("Exception occurred while closing the resource :: " + e);
				throw e;
			}
		}
		return employees;
	}

	@Override
	public String deleteEmployee(Long id) throws Exception {
		try {
			connection = JdbcUtil.getConnection();
			if (connection != null) {
				String query = "UPDATE employee SET is_deleted = 1 WHERE pk_id =?";
				pstmt = connection.prepareStatement(query);
				pstmt.setLong(1, id);
				Integer rowsAffected = pstmt.executeUpdate();
				if(rowsAffected != null && rowsAffected > 0) {
					return Constants.SUCCESS;
				}
			}
		} catch (SQLException | IOException e) {
			System.out.println("Exception occurred while fetching employees :: " + e);
			throw e;
		} finally {
			try {
				JdbcUtil.cleanUp(connection, pstmt, resultSet);
			} catch (SQLException e) {
				System.out.println("Exception occurred while closing the resource :: " + e);
				throw e;
			}
		}
		return Constants.FAILED;
	}

	@Override
	public String updateEmployee(Employee emp) throws Exception {
		try {
			connection = JdbcUtil.getConnection();
			if (connection != null) {
				String query = "UPDATE employee SET `name`=?,age=?,address=?,salary=? WHERE pk_id = ?";
				pstmt = connection.prepareStatement(query);
				pstmt.setString(1, emp.getName());
				pstmt.setInt(2, emp.getAge());
				pstmt.setString(3, emp.getAddress());
				pstmt.setDouble(4, emp.getSalary());
				pstmt.setLong(5, emp.getId());
				Integer rowsAffected = pstmt.executeUpdate();
				if (rowsAffected != null && rowsAffected > 0) {
					return Constants.SUCCESS;
				}
			}
		} catch (SQLException | IOException e) {
			System.out.println("Exception occurred while updating employee :: " + e);
			throw e;
		} finally {
			try {
				JdbcUtil.cleanUp(connection, pstmt, resultSet);
			} catch (SQLException e) {
				System.out.println("Exception occurred while closing the resource :: " + e);
				throw e;
			}
		}
		return Constants.FAILED;
	}

}
