package in.practice.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * Generate InitParams using Annotation for Servlets
 */
@WebServlet(urlPatterns="test1",initParams= {
		@WebInitParam(name="url",value="jdbc:mysql:///localhost"),
		@WebInitParam(name="username",value="root"),
		@WebInitParam(name="password",value="Reddy@3816")
},loadOnStartup=10)
public class TestApp1 extends HttpServlet{
	
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
	
	@Override
	public void doPost(HttpServletRequest request , HttpServletResponse response) {
		
	}

}
