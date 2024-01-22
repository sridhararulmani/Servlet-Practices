<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
		<!-- Directive Tag -->
		<%@include file="index.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<!-- Declarative Tag -->
	<%!int a = 18;
	String name = "virat";
	String[] names = { "Rohit", "Dhoni", "Jadu" };%>

	<!-- Expression Tag -->
	<h2><%=a%></h2>
	<h2><%=name%></h2>

	<!-- Script Tag -->
	<%
	for (String n : names) {
	%>
	<h3><%=n%></h3>
	<%
	}
	%>
</body>
</html>