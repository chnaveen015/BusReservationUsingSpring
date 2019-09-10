<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>No of Passengers</title>
</head>
<body>
	<%@ include file="Admin.jsp"%>
	<br>
	<br>
	<br>
	<hr>
		<form action="NoPassengers" align="center"  name="form" method="post">
			<table align="center">
				<tr>
					<td>Enter the Bus ID:</td>
					<td><input type="number" name="bus_id" rquired></td>
					<p id='enter'>
				</tr>
				<tr>
					<td>Enter The Date:</td>
					<td><input type="date" name="date" required></td>
					<p id='enter1'>
				</tr>
				<tr>
					<td><input type="submit" value="submit"></td>
				</tr>
			</table>
		</form>

</body>
</html>