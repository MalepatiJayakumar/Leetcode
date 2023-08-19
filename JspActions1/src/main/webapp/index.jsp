<%@ page language="java"%>

<jsp:useBean id="calculator" class="com.practice.beans.Calculator"></jsp:useBean>

<h1>
	The square of 5 is :: <%= calculator.square(5) %><br/>
	The square of 6 is :: <%= calculator.square(6) %>
</h1>