<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>${headr}</h1>
<h1>${desc}</h1>

	<h1>Your data is successfully saved.</h1>
	<h2>
		Name : ${user.name }</h2>
	<h2>
		Email :${user.email }</h2>
	<h2>
		Password : ${user.pwd }</h2>

</body>
</html>