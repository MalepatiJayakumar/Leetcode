package in.practice.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestApp
 */
/*
 * Here to make an connection with sql we need to upload jar in Build path for
 * JDK, But to get that jar for Tomcat server we need to add same jar in
 * Deployment Assembly as well
 */
/* 
 * Also to use web.xml we created these project in servlet 2.5 version
 */
public class TestApp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection connection = null;
	PreparedStatement pstmt = null;
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded successfully...");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void init() throws ServletException {
		String url = getInitParameter("url");
		String username = getInitParameter("username");
		String password = getInitParameter("password");
		try {
			connection = DriverManager.getConnection(url, username, password);
			System.out.println("Connection has been created successfully...");
		} catch (SQLException e) {
			System.out.println("Exception occurred while creating an connection...");
		}
	}
	/* http://localhost:9999/JDBCServletApp/test */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		try {
			PrintWriter out = response.getWriter();
			if (connection != null) {
				String query = "SELECT * FROM employee WHERE is_deleted = 0";
				Statement stmt = connection.createStatement();
				ResultSet resultSet = stmt.executeQuery(query);
				out.println("<h1 align=\"center\">Employees in Finance Product</h1>");
				out.println("<table align=\"center\" border=1px>");
				out.println("<center>");
				out.println("<tr><td>Id</td><td>name</td><td>Age</td><td>Address</td><td>Salary</td></tr>");
				while (resultSet.next()) {
					out.println("<tr>");
					out.println("<td>" + resultSet.getLong(1) + "</td><td>" + resultSet.getString(2) + "</td><td>"
							+ resultSet.getInt(3) + "</td><td>" + resultSet.getString(4) + "</td><td>"
							+ resultSet.getDouble(5) + "</td>");
					out.println("</tr>");
				}
				out.println("</center>");
				out.println("</table>");
			}
		} catch (SQLException e) {
			System.out.println("Exception occurred while processing the request..");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/* Need to write an logic to save user post user fills form for adding an user */
		response.setContentType("text/html");
		
		response.getWriter();
		
		System.out.println("Entered into Post method from registration form successfully....");
		String username = request.getParameter("name");
		Integer age = Integer.parseInt(request.getParameter("age"));
		String address = request.getParameter("address");
		Double salary = Double.parseDouble(request.getParameter("salary"));
		System.out.println("Name :: "+username+" >> age :: "+age+" >> address :: "+address+" >> salary :: "+salary);
		try {
			if(connection != null) {
				String query = "INSERT INTO employee(`name`,age,address,salary) VALUES(?,?,?,?)";
				pstmt = connection.prepareStatement(query);
				pstmt.setString(1,username);
				pstmt.setInt(2,age);
				pstmt.setString(3,address);
				pstmt.setDouble(4,salary);
				Integer rowsAffected = pstmt.executeUpdate();
				if(rowsAffected != null && rowsAffected > 0) {
					System.out.println("Employee details has been saved successfully....");
				}
			}
		}catch(SQLException e) {
			System.out.println("Inside doPost method in TestApp >> exception :: "+e);
		}
	}

}
