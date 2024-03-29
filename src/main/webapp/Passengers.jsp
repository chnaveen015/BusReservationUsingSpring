<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.busreservation.bean.Reservation,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Passengers</title>
</head>
<body>
		<%@include file="NoOfPassengers.jsp" %>
		<br>
		<br>
		<%
		ArrayList<Reservation> passengersList= (ArrayList<Reservation>) request.getAttribute("passengers");
	%>
	<form align="center">
		<table border="1" align="center" width="100%">
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


				<%
					if(passengersList!=null)
					{
						
					for(Reservation passenger:passengersList)
					{%>
					<tr>
				<td><%=passenger.getPnr()%></td>
				<td><%=passenger.getBus_id()%></td>
				<td><%=passenger.getName()%></td>
				<td><%=passenger.getId_proof_no()%></td>
				<td><%=passenger.getNo_of_seats()%></td>
				<td><%=passenger.getSource()%></td>
				<td><%=passenger.getDestination()%></td>
				<td><%=passenger.getDateOfJourney()%></td>
				<td><%=passenger.getJourney().getBus().getBus_type()%></td>
				<td><%=passenger.getFare()%></td>
			</tr>
					<%
						}
					}
					else
					{%>
					<tr><td>no passengers available!</td></tr>
				<%	}
				%>
		</table>
		

</body>
</html>