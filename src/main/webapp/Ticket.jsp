<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.busreservation.bean.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ticket</title>
</head>
<body>
	<%@ include file="Welcome.jsp"%>
	<br>
	<br>


	<%
		Reservation ticket = (Reservation) request.getAttribute("ticket");
	%>
	<%
		if (ticket != null) {
	%>

	<form align=center>




		<table border="1" align="center" width=50
			style="border-collapse: collapse"%>
			<caption>
				<h3>Ticket</h3>
			</caption>
			<thead>
				<tr>
					<th>PNR</th>
					<th>BUS_ID</th>
					<th>NAME</th>
					<th>ID PROOF NO</th>
					<th>NO OF SEATS</th>
					<th>SOURCE</th>
					<th>DESTINATION</th>
					<th>Date</th>
					<th>BUS TYPE</th>
					<th>COST</th>
				</tr>
			</thead>
			<tr>
				<td><%=ticket.getPnr()%></td>
				<td><%=ticket.getBus_id()%></td>
				<td><%=ticket.getName()%></td>
				<td><%=ticket.getId_proof_no()%></td>
				<td><%=ticket.getNo_of_seats()%></td>
				<td><%=ticket.getSource()%></td>
				<td><%=ticket.getDestination()%></td>
				<td><%=ticket.getDateOfJourney()%></td>
				<td><%=ticket.getJourney().getBus().getBus_type()%></td>
				<td><%=ticket.getFare()%></td>
			</tr>
		</table>
	</form>
	<%
		}
	%>
	<%
		if (ticket == null) {
	%>
	<h3 align="center">No Ticket Found</h3>
	<%
		}
	%>
</body>
</html>