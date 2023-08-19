<%@ page language="java" %>
<h1>
	<jsp:include page="header.jsp">
	<!-- These params will be passed to header.jsp in request params, 
	so we can access both these params in header.jsp page by using request.getParameter("name") -->
		<jsp:param name='name' value='jaikumar'/>
		<jsp:param name='surname' value='reddy'/>
	</jsp:include>
	<h1>Inside Main Page</h1>
	<jsp:include page="footer.jsp"></jsp:include>
</h1>