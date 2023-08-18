<%@page import="java.sql.SQLException"%>
<%@ page
	import="java.sql.PreparedStatement,java.sql.Connection,java.sql.DriverManager,java.sql.ResultSet"%>

<%!PreparedStatement pstmt1 = null;
	PreparedStatement pstmt2 = null;
	Connection connection = null;
	ResultSet resultSet = null;
	public void jspInit() {
		System.out.println("Connection has been created");
		ServletConfig config = getServletConfig();
		String url = config.getInitParameter("jdbcUrl");
		String userName = config.getInitParameter("userName");
		String password = config.getInitParameter("password");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, userName, password);
			if (connection != null) {
				pstmt1 = connection.prepareStatement("select * from employee");
				pstmt2 = connection.prepareStatement("INSERT INTO employee(`name`,age,address,salary) VALUES(?,?,?,?)");
				System.out.println("Connection has been created");
			}
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}%>
	
<%
	String action = request.getParameter("s1");
	if(action.equalsIgnoreCase("link") && pstmt1 != null){
		//Fetch data from DB
		resultSet = pstmt1.executeQuery();
		out.println("<html><head><title>All Employees</title></head><body><center><table border='1' style='border-collapse:collapse'>");
		out.println("<tr><th>Employee Name</th><th>Employee Address</th><th>Employee Salary</th></tr>");
		while(resultSet.next()){
			String name = resultSet.getString("name");
			Integer salary = resultSet.getInt("salary");
			String address = resultSet.getString("address");
			out.println("<tr><td>"+name+"</td><td>"+address+"</td><td>"+salary+"</td></tr>");
		}
		out.println("</table></center></body></html>");
	}else{
		//Save date from DB
		String empName = request.getParameter("empName");
		String empAddress = request.getParameter("empAddress");
		Long empSalary = Long.parseLong(request.getParameter("empSalary"));
		pstmt2.setString(1, empName);
		pstmt2.setInt(2,25);
		pstmt2.setString(3,empAddress);
		pstmt2.setLong(4,empSalary);
		Integer rowCount = pstmt2.executeUpdate();
		if(rowCount > 0){
			//success
			out.println("<center><h1 style='color:green'>Registration successful</h1></center>");
		}else{
			//failed
			out.println("<center><h1 style='color:red'>Registration Failed</h1></center>");
		}
	}
		out.println("<center><a href='./index.html'>HOMEPAGE</a></center>");
%>


<%!public void jspDestroy() {
		try {
			if (connection != null) {
				connection.close();
			}
			if (pstmt1 != null) {
				pstmt1.close();
			}
			if (pstmt2 != null) {
				pstmt2.close();
			}
		} catch (SQLException e) {

		}
	}%>
