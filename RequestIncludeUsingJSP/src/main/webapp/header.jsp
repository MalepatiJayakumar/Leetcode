<%@ page language="java" %>
<h1>
	Inside Header JSP page<br/>
	<!-- We will get these params from index.jsp where these are passed by request object as request object is shared accross the pages -->
	Name  :: <%= request.getParameter("name") %><br/>
	Surname  :: <%= request.getParameter("surname") %>
</h1>