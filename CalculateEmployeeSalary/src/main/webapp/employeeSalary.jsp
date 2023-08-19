<%@page import="com.practice.bean.Employee"%>
<%@ page language="java"%>

<jsp:useBean id="employee" class="com.practice.bean.Employee"/>
<jsp:useBean id="employeeService" class="com.practice.service.EmployeeServiceImpl"></jsp:useBean>

<jsp:setProperty property="*" name="employee"/>

<% 
	employee = employeeService.calculateSalary(employee);
%>
<h1 style="color:blue">Calculated Employee salary details</h1>
<center>
	<table border=1 style="color:green;font-size: 25px">
		<tr><td>Employee Number</td><td>Employee Name</td><td>Employee Basic Salary</td><td>Employee Net Salary</td><td>Employee Gross salary</td><td></td><tr>	
        <tr><td><%= employee.getEmpId() %></td><td><%= employee.getEmpName()%></td><td><%= employee.getEmpBasicSalary()%></td><td><%= employee.getEmpNetSalary()%></td><td><%= employee.getEmpGrossSalary()%></td></tr>
	<table>
</center>
