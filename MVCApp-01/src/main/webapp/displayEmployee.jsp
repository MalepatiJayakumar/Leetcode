<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Control came to Display employee</h1>
	<h1>
		<c:choose>
			<c:when test="${empty employee}">
				<h1>Sorry employee is not present with provided Employee Id</h1>
			</c:when>
			<c:otherwise>
				<h1 style="text-align: center">Employee has found with below Details</h1>
				<center><table border="1" style="color: blue;text-align: center">
					<tr>
						<th>Employee Name</th>
						<th>Employee Age</th>
						<th>Employee Address</th>
					</tr>
					<tr>
						<td>${employee.empName}</td>
						<td>${employee.age}</td>
						<td>${employee.address}</td>
					</tr>
				</table></center>
			</c:otherwise>
		</c:choose>
	</h1>
</body>
</html>