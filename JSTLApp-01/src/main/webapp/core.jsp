<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h1 style='color:blue; text-align:center'>
	<!-- Everything in EL is an number so where we use for any operator then will get below error
		java.lang.NumberFormatException: For input string: "jai"
		at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
		at java.lang.Long.parseLong(Long.java:589)
	 -->	
	<c:set var='x' value='10'/>
	<c:set var='y' value='20'/>
	Sum of values are  :: <c:out value="${x+y}" default = '1000'/><br/>
	<!-- output :: Sum of values are :: 30 -->
	
	<c:remove var='x'/>
	Sum of values post Removing one variable :: <c:out value='${x+y}'/><br/>
	<!-- output :: Sum of values post Removing one variable :: 20 -->
	
	<c:remove var='y'/>
	Sum of values post Removing both the variables :: <c:out value='${x+y}'/><br/>
	<!-- output :: Sum of values post Removing both the variables :: 0 -->
	
	
	<c:catch var='e'>
		<c:out value="${'jai'+1}" />
	</c:catch>
	Exception occurred while adding an string & Number  :: <c:out value="${e}"/>
	<!-- Exception occurred while adding an string & Number :: java.lang.NumberFormatException: For input string: "jai"-->
	
</h1>