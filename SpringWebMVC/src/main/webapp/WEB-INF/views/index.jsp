<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Welcome to Spring MCV Project Practice</h1>

	<%
	String name = (String) request.getAttribute("name");
	Integer id = (Integer) request.getAttribute("id");
	List<String> friends = (List<String>) request.getAttribute("friends");
	%>
	
	<h1>My Name is <%= name%> and Id is <%= id %></h1>
	<h1>My friends are : </h1>
	<%
	for(String f:friends){
		
		%>
		<h2><%=f %></h2>
		<% 
	}
	%>
<h1>Using Model</h1>
</body>
</html>