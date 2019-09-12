<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
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
	<%ArrayList<Integer>busesId=(ArrayList<Integer>)session.getAttribute("busesId"); %>
		<form action="NumberOfPassengers" align="center"  name="form" method="post">
			<table align="center">
				<tr>
					<td>Chosse the Bus :</td>
					<td><select name="bus_id">

						<%
							for (Integer buseId: busesId) {
						%>
						<option>
							<%=buseId%>      
						</option>
						<%} %>
				</select></td>
				</tr>
				<tr>
					<td>Enter The Date:</td>
					<td><input type="date" name="date" required></td>
					
				</tr>
				<tr>
					<td><input type="submit" value="submit"></td>
				</tr>
			</table>
		</form>

</body>
</html>