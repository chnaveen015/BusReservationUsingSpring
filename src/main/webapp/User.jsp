<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Enter Journey Details</title>
</head>
<body bgcolor="D3D3D3">
			<%@ include file="Welcome.jsp"%>
			<hr>
	<br>
	<br>
	<%
		ArrayList<String> sources = (ArrayList<String>) session.getAttribute("sources");
	ArrayList<String> destinations = (ArrayList<String>) session.getAttribute("destinations");
	String msg=(String)request.getAttribute("msg");
	%>
	<%/*
			It will Redirect to Avaiable Buses Controller
			*/
	%>
				


	<form action="GetAvailableBuses" method="post"  name="form">
		<table align="center">
			<tr>
				<td>select the source:</td>
				<td><select name="source">

						<%
							for (String source: sources) {
						%>
						<option>
							<%=source%>
						</option>
						<%
							}
						%>
				</select></td>
			</tr>
			<tr>
				<td>Enter the destination:</td>
				<td><select name="destination">

						<%
							for (String destination: destinations) {
						%>
						<option>
							<%=destination%>
						</option>
						<%
							}
						%>
				</select></td>

			</tr>


			<tr>
				<td>No of seats(min 1 and max 4)</td>
				<td><input type="number" min="1" and max="4" name="noOfSeats" required></td>
				
			</tr>
			<tr>
				<td>Date of journey:</td>
				<td><input type="date" name="dateOfJourney"
					 required></td>
				
			</tr>
			<tr>
				<td><input type="submit"></td>
			</tr>
		</table>
		<% if(msg!=null){ %>
		<h3 align="center"><%=msg %></h3>
		<%} %>
	</form>
			

</body>
</html>