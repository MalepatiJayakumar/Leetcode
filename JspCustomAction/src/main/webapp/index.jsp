<%@ taglib prefix='myTag' uri='/WEB-INF/hello.tld'%>

<h1>Inside index.jsp page before calling custom tags</h1>

<myTag:hello name='jaikumar'>
	<h1>Inside index.jsp page in custom tag for jaikumar execution</h1>
</myTag:hello>

<myTag:hello >
	<h1>Inside index.jsp page in custom tag for guest execution</h1>
</myTag:hello>

<h1>Inside index.jsp page after calling custom tags</h1>