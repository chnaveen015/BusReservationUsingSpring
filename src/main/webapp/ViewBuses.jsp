<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.busreservation.bean.BusDetails,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Available Buses</title>
</head>

<body bgcolor="D3D3D3">
			<%
		ArrayList<BusDetails> viewBuses = (ArrayList<BusDetails>) session.getAttribute("viewBuses");
		
			
	%>	
		
			<form align="center" action="BeginReservation" method="POST"  name="form">
		<table border="1" align="center">
		<thead>
		<tr>
		<th>BUS_ID</th>
		<th>BUS_TYPE</th>
		<th>AVAILABLE SEATS</th>
		<th>FARE</th>
		</tr>
		</thead>
		<tr>	<%
			for (BusDetails viewBus : viewBuses) {
				out.print("<tr><td>"+viewBus.getBus_id()+"</td>"+"<td>"+viewBus.getBus_type()+"</td>"+"<td>"+viewBus.getAvailable_seats()+"</td>"+"<td>"+viewBus.getFare()+"</td>");
			}
			%>
			</tr>
		</table>
		<br><br>
		Choose  the Bus :<td><select name="bus_id">

						<%
							for (BusDetails viewBus: viewBuses) {
						%>
						<option>
							<%=viewBus.getBus_id()%>      
						</option>
						<%} %>
				</select></td><input type="submit">
	
		
			
		</form>
		

</body>
</html>