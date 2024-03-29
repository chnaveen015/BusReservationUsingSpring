<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.busreservation.bean.BasicDetailsBean,com.busreservation.bean.BusDetails"%>
<!DOCTYPE html>
<html>
<head>

<script type="text/javascript">
	function validate() {
		var name = document.forms["form"]["name"].value;


		document.getElementById('enter').innerHTML = "";

		document.getElementById('enter1').innerHTML = "";
		
		var numericExpression = /^[0-9]{12}$/;
		var idproofno = document.forms["form"]["id_proof_no"].value;

		
		if (idproofno.match(numericExpression)) {
			return true;
		} else {
			alert("adhar number must be filled with 12 digit number only");
			return false;
		}

		return true;

	}
</script>
<meta charset="UTF-8">
<title>Reservation</title>
</head>
<body bgcolor="D3D3D3">
	<%
		BasicDetailsBean details = (BasicDetailsBean) session.getAttribute("details");
		BusDetails busDetails=(BusDetails)request.getAttribute("busDetails");
	%>
	<form action="Reservation" name="form"
		onsubmit="return validate();" method="POST">
		<table align="center" border="2">
			<tr>
				<td>Name:</td>
				<td><input type="text" name="name" required></td>
				<p id="enter">
			</tr>
			<tr>
				<td><input type="hidden" name="journey_id"
					value=<%=busDetails.getJourney_id()%> readonly></td>
			</tr>
			<tr>
			<td>Bus_Id:</td>
				<td><input type="text" name="bus_id"
					value=<%=request.getParameter("bus_id")%> readonly></td>
			</tr>
			<tr>
				<td>Source:</td>
				<td><input type="text" name="source"
					value=<%=details.getSource()%> readonly></td>
			</tr>
			<tr>
				<td>Destination:</td>
				<td><input type="text" name="destination"
					value=<%=details.getDestination()%> readonly></td>
			</tr>
			<tr>
				<td>No of Seats:</td>
				<td><input type="text" name="no_of_seats"
					value=<%=details.getNoOfSeats()%> readonly></td>
			</tr>
			<tr>
				
				<td><input type="hidden" name="stopno1"
					value=<%=busDetails.getRouteno1()%> readonly></td>
			</tr>
			<tr>
				
				<td><input type="hidden" name="stopno2"
					value=<%=busDetails.getRouteno2()%> readonly></td>
			</tr>
			<tr>
				<td>Fare(<%=details.getNoOfSeats()%>*<%=busDetails.getFare() %>)</td>
				<td><input type="text" name="fare" value=<%=details.getNoOfSeats()*busDetails.getFare()%> readonly></td>
			</tr>
			<tr>
				<td>Date:</td>
				<td><input type="date" name="dateOfJourney"
					value=<%=details.getDateOfJourney()%> readonly></td>
			</tr>
			<tr>
				<td>Adhar No:</td>
				<td><input type="text" name="id_proof_no" required></td>
				<p id="enter1">
			</tr>
			<tr align="center">
				<td><input type="submit" name="submit"></td>
			</tr>
		</table>
	</form>
</body>
</html>