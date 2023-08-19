<%@ page language="java" %>
<jsp:useBean id="student" class="com.practice.bean.Student" scope="session"></jsp:useBean>

<!-- Getting the property values from Student Bean/DTO -->


<!-- We will get all values as null because we are creating an new student object here ,
 	whereas new object will have empty values. So to access student object data which was 
 	setted within that session scope we add an property of scope="session" in both setting and getting object(set_values, get_values)-->
<center>
	<h1> Student id :: <jsp:getProperty name="student" property="id"/></h1>
	<h1> Student Name :: <jsp:getProperty name="student" property="name"/></h1>
	<h1> Student Address :: <jsp:getProperty name="student" property="address"/></h1>
	<h1> Student Age :: <jsp:getProperty name="student" property="age"/></h1>
</center>

<!-- If we try to access all properties of objects using * we will get below exception
org.apache.jasper.JasperException: Cannot find any information on property [*] in a bean of type [com.practice.bean.Student]
so we can't get properties using * operator
	<jsp:getProperty property="*" name="student"/>
-->