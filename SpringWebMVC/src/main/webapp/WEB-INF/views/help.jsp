<%@page import="java.time.LocalDateTime"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Help</title>
</head>
<body>
	<h1>Help page</h1>
	<%
	String name = (String) request.getAttribute("name");
	Integer id = (Integer) request.getAttribute("id");
	LocalDateTime time = (LocalDateTime) request.getAttribute("time");
	%>
	<h1>
		My Name is
		<%=name%>
		and Id is
		<%=id%></h1>
<h2> Time is : <%=time %></h2>

		<h1>Using ModelAndView</h1>
</body>
</html>