<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="D3D3D3">
			<% String status=(String)request.getAttribute("status"); %>
			<form action="CancelTicket" align="center" method="post"  name="form">
		<table align="center">
			<tr>
				<td>Enter the PNR number:</td>
				<td><input type="number" name="pnr" required></td>
				<td><input type="submit" name="cancel" value="Submit"></td>
			</tr>
		</table>
		<%if(status !=null && status.equals("yes")){ %>
			<h3 align="center"> Cancellation Successfull!</h3>
			<<br><br>
			<a href="Welcome.jsp" align="center"><input type="button" value="Back"></a>
			<%} %>
	</form>
</body>
</html>