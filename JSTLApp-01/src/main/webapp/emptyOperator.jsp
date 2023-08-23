<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1 style='color:red;text-align:center'>
	<%
		int[] arr = new int[1];
		arr[0]= 1;
	%>
	${empty jai}<br/>
	${empty 10}<br/>
	${empty null}<br/>
	${empty ""}<br/>
	${empty arr}<br/>
</h1>
