<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<title>JSTL Practice</title>
	</head>
	<body>
		<c:set var='data' value='10'/> <%-- int data = 10--%>
		<c:out value='${data}'/>       <%-- out.println(data) --%>
		
		<%-- Adding two variables and printing output in UI --%>
		<c:set var='x' value='10'/>
		<c:set var='y' value='20'/>
		<h1 style='color:blue;text-align: center'>Sum of provided values are :: <c:out value="${x+y}" default="50"/></h1>
		
		<%-- Accepting an request param of Application name, if Application name is not coming then set default value as Investment Platform --%>
		<h1 style='color:blue;text-align: center'>The Application Name is :: <c:out value='${param.applicationName}' default="Investment Platform"/></h1>
	</body>
</html>