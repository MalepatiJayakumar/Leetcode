<%@page import="java.util.ArrayList,java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1 style='color:blue;text-align: center'>
	<c:set var="x" value="10" />
	<c:if test="${x eq 10}" var="y" scope="request"/>
	
	<c:if test="${x eq 10}" var="z" scope="request">
		X value is 10<br/>
	</c:if>
	
	Value of x is :: ${x}<br/>
	Test result is:: ${y}<br/>

	<!-- Check weather user is passing an value or not on userName parameter value , if he is passing then say hello to user otherwise say to guest -->
	<c:if test="${! empty param.userName}">
		<!-- Passed validation for empty check of userName from request object -->
		Hello ${param.userName}, how are you.<br/>
	</c:if >
	<c:if test="${empty param.userName}">
		<!-- Didn't received an UserName object from request object -->
		Hello Guest, how are you , please send userName in request param.<br/>
	</c:if>


	<!-- Switch statement in JSP  -->
	<c:if test="${! empty param.num}">
		<c:choose>
		<c:when test="${param.num< 0}">
			Entered Number is an Negative Number
		</c:when>
		<c:when test="${param.num> 0}">
			Entered number is an Postive Number
		</c:when>
		<c:otherwise>
			Number you entered is zero
		</c:otherwise>
	</c:choose>
	</c:if>
	
	
	<br/><br/>
	<!-- Printing an tables using for loop -->
	<table border='1' style='color: blue; text-align: center;align-content: center'>
		<c:forEach var="i" begin="1" end="10">
			<tr>
				<td>2*${i}</td>
				<td>${2*i}</td>
			</tr>
		</c:forEach>
	</table>


	<%
		String[] names = {"rohit","kohli","dhoni","sachin"};
		request.setAttribute("names", names);
		List<String> teams = new ArrayList<>();
		teams.add("MI");
		teams.add("DC");
		teams.add("RR");
		teams.add("KKR");
		teams.add("CSK");
		request.setAttribute("teams", teams);
	%>
	
	
	<c:forEach var="n" items="${names}" >
		<h1 style='color:green;text-align: center'>Name is :: ${n}<br/></h1>
	</c:forEach>
	
	<br/><br/>
	<c:forEach var="t" items="${teams}">
		<h2 style='color:cyan;text-align:center'>Team Name is :: ${t}</h2>
	</c:forEach>
	
	
	<!-- Getting all the Param with key value pair -->
	<table border='1' style='color:cyan; text-align:center' >
		<tr>
			<td>KEY</td>
			<td>VALUE</td>
		</tr>
		<c:forEach var="p" items="${param}">
			<tr>
				<td>${p.key}</td>
				<td>${p.value}</td>
			</tr>
		</c:forEach>
	</table>
	
	<br/><br/>
	<!-- Splitting and Iterating through for -->
	<c:forTokens items="dhoni,sachin,kohli,rohit" delims="," var="name">
		<h1 style='color:green;text-align: center'>Name is :: ${name}</h1>
	</c:forTokens>
	
	
	
	<!-- We are setting values in params to use in URLRelated jsp page , These values will be stored in param object , so that we can use in urlRelated JSP file -->
	<c:import url="urlRelated.jsp" >
		<c:param name="sub1" value="java" />
		<c:param name="sub2" value="ReactJS"/>
		<c:param name="sub3" value="DeveOps"/>
	</c:import>
</h1>