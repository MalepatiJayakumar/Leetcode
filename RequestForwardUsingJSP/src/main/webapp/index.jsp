<%@ page language="java"%>
<h1> 
	Control is in index.jsp file in JSP file , 
	as these is an forward request response object will be flushed here itself so these msg won't be visible.
	<jsp:forward page="output.jsp"></jsp:forward>
	
</h1>