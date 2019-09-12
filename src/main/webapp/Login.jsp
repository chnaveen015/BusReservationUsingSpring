<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Login</title>
</head>

<body>
	<%@include file="STARTFROMHERE.jsp"%>
	<% String message=(String)request.getAttribute("message");
	%>
	<form  action="LoginValidator" method="post" name="form">
		<p>
			Username: <input type="text" name="username" required>
		</p>

		<p>
			Password: <input type="password" name="password" required>
		</p>
	
		<input class="login" type="submit" value="Enter Details" />
		<% if(message!=null) {%>
		<h3 align="center"><%=message %></h3>
		<%} %>
	</form>
</body>
</html>