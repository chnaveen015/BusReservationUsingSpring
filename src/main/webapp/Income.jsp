<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<%@ include file="Admin.jsp"%>
	<br>
	<br>
	<br>
		<form action="IncomeController" align="center" method="POST">
			<table align="center">
				<tr>
					<td>Enter The Date:</td>
					<td><input type="date"  name="date" required></td>
					<td><input type="submit" value="submit"></td>
				</tr>
			</table>
		</form>

</body>
</html>