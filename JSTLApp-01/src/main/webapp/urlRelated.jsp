<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1 style='color:blue;text-align:center'>

	<!-- Defining the url in an variable to use -->
	<c:url var="amazonURL" value="https://www.amazon.in/ref=nav_logo" scope="request"></c:url>
	
	<!-- Redirecting to an specific url provided for amazonURL -->
	<c:redirect url="${amazonURL}"/>
		
	
	<!-- Accepting an created subjects in conditional.jsp to import those using import -->
	<h1>Available courses are :: ${sub1} , ${sub2} & ${sub3}</h1>
</h1>