<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix='fn' %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c' %>

<body>
	<c:set var="x" value="Hello Audience , please practice JSTL properly"/>
	
	<h1 style='color:red;text-align: center'>
		Checking weather practice is present or not in provided string :: ${fn:contains(x,"practice")} <br/>
		Length of the string :: ${fn:length(x)}<br/>
		Converting string to UPPER CASE :: ${fn:toUpperCase(x)}<br/>	
		Converting string to LOWER CASE :: ${fn:toLowerCase(x)}<br/>
		SubString :: ${fn:substring(x,5,15)}<br/>
		Starts with check in string  :: ${fn:startsWith(x,"Hello")}<br/>
	</h1>
	
	<h1 style='color:green;text-align: center'>
		<c:set var="data" value="jai,dhanush,mahesh,sai,sathish"/>
		<c:set var="names" value='${fn:split(data,",")}' />
			Result of slipted data
			<c:forEach var="name" items="${names}">
				${name} <br/>
			</c:forEach>
	</h1>
	
	
	<h1>
		String after joining all the names ${fn:join(names,"-")}
	</h1>	
		
</body>
</html>