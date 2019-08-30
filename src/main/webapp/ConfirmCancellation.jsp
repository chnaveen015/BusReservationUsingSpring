<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.busreservation.bean.Reservation"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="D3D3D3">
	<%@ include file="CancelTicket.jsp"%>
	<br>
	<br>
	

	<%
		Reservation ticket = (Reservation) request.getAttribute("ticket");
	%>
	<% if(ticket!=null) { %>
	<h3 align="center">Ticket</h3>
	<form align="center" action="ProceedCancellation" method="POST">
		<table border="1" align="center">
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
				<%
					out.print("<tr><td>" + ticket.getPnr() + "</td>" + "<td>" + ticket.getBus_id() + "</td><td>"
							+ ticket.getName() + "</td><td>" + ticket.getId_proof_no() + "</td><td>" + ticket.getNo_of_seats()
							+ "</td>" + "<td>" + ticket.getSource() + "</td><td>" + ticket.getDestination() + "</td><td>"
							+ ticket.getDateOfJourney() + "</td><<td>" + ticket.getJourney().getBus().getBus_type() + "<td>"
							+ ticket.getFare() + "</td></tr>");
				%>
			</tr>
		</table>
		<input type="hidden" name="pnr" value=<%=ticket.getPnr()%> readonly>
		<br><br>
		<input type="submit" name="submit" value="Proceed To Cancel">
	</form>
	<%} %>
	<% if(ticket==null){%>
	<h3 align="center" bgcolor="D3D3D3">Enter valid Pnr Number</h3>
	<%}%>
</body>
</html>