<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>No of Buses</title>
</head>
<body>
		<%@ include file="STARTFROMHERE.jsp"%>
	<hr>
	<br>
	<br>
	<%
	ArrayList<String> sources = (ArrayList<String>) session.getAttribute("sources");
	ArrayList<String> destinations = (ArrayList<String>) session.getAttribute("destinations");

	%>



	<form action="GetNoOfBuses" method="post" name="form">
		<table align="center">
			<tr>
				<td>select the source:</td>
				<td><select name="source">

						<%
							for (String s : sources) {
						%>
						<option>
							<%=s%>
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
							for (String d : destinations) {
						%>
						<option>
							<%=d%>
						</option>
						<%
							}
						%>
				</select></td>

			</tr>
			<tr>
				<td>StartingDate</td>
				<td><input type="date"  name="startDate" required></td>
			</tr>
			<tr>
				<td>EndingDate:</td>
				<td><input type="date" name="endDate"
					required></td>
			</tr>
			<tr>


			<td><input type="submit" name="submit"></td>
			</tr>
		</table>
	</form>
</body>
</html>