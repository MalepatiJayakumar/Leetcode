<%@ page language="java" %>

<jsp:useBean id="student" class="com.practice.bean.Student" scope="session"/>
<jsp:setProperty name="student" property="id" value="1"/>
<jsp:setProperty name="student" property="name" value="JaiKumar"/>
<jsp:setProperty name="student" property="address" value="HYD"/>
<jsp:setProperty name="student" property="age" value="22"/>
	<h1><%= student %></h1><br/>
<!-- Setting request param values to the Bean or DTO -->
<jsp:setProperty name="student" property="id" param="id"/>
<jsp:setProperty name="student" property="name" param="name"/>
<jsp:setProperty name="student" property="address" param="address"/>
<jsp:setProperty name="student" property="age" param="age"/>
	<h1><%= student %></h1><br/>
	
<!-- If request param & property name is same then it will map automatically with explicit field mapping with below config -->
<jsp:setProperty property="*" name="student"/>
	<h1><%= student %></h1>