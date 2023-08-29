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
	<table border="1" style="align-content: center;align-items: center; ">
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


</body>