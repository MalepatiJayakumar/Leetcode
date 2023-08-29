<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<body>
	<sql:setDataSource driver="com.mysql.cj.jdbc.Driver"
		url="jdbc:mysql://localhost:3306/localhost" user="root"
		password="Reddy@3816" var="dataSource" />
	<sql:query var="results" dataSource="${dataSource}">
		SELECT * FROM employee
	</sql:query>

	<h1 style="color:green;text-align: center">EMPLOYEE DATA</h1>
	<table border="1" style="text-align: center">
		<tr>
			<th>Employee Name</th>
			<th>Employee Age</th>
			<th>Employee Address</th>
			<th>Employee Salary</th>
		</tr>
		<c:forEach var="result" items="${results.rows}">
			<tr>
				<td>${result.name}</td>
				<td>${result.age}</td>
				<td>${result.address}</td>
				<td>${result.salary}</td>
			</tr>
		</c:forEach>
	</table>
	
	
	
	
	<!-- JSTL approach to insert entry in Database using sql statement object -->
	<sql:update dataSource="${dataSource}" sql="INSERT INTO employee(`name`,age,address,salary) VALUES('saravana',23,'STVD',15000)"/>
	<h1 style="text-align: center" >Number of rows inserted using statement :: ${count}</h1>
	
	
	<!-- JSTL approach to insert entry into Database using sql PreparedStatement object -->
	<sql:update dataSource="${dataSource}">
		INSERT INTO employee(`name`,age,address,salary) VALUES(?,?,?,?)
		<sql:param value="jai" />
		<sql:param value="22"/>
		<sql:param value="HYD"/>
		<sql:param value="5500"/>
	</sql:update>
	<h1 style="text-align: center" >Number of rows inserted using Prepared statement :: ${count}</h1>
	
	<sql:transaction dataSource="${dataSource}" >
		<sql:update>
			UPDATE employee SET salary=salary+100 WHERE `name`= 'Hari'
		</sql:update>
		<sql:update>
			UPDATE employee SET salary=salary+100 WHERE `name`= 'dhanush'
		</sql:update>
	</sql:transaction>
	
</body>