<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Ticket</title>
</head>
<body>
	<%@include file="Welcome.jsp" %>
	<br>
	<br>
	<br>
		<form action="ViewTicket" align="center" method="post"  name="form">
			<table align="center">
				<tr>
					<td>Enter the PNR No:</td>
					<td><input type="number" name="pnr" required></td>
					<p id="enter">
				</tr>
				<tr>
					<td><input type="submit" value="submit"></td>
				</tr>
			</table>
		</form>

</body>
</html>