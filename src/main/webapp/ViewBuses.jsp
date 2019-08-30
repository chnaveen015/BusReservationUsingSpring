<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.busreservation.bean.BusDetails,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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