<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="com.busreservation.bean.Journey,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>IncomeDetails</title>
</head>
<body>
	<%@ include file="Income.jsp"%>
	<br>
	<br>
	<br>
	<%
		ArrayList<Journey> incomeDetails = (ArrayList<Journey>) request.getAttribute("incomeDetails");
	%>
	<form align="center" action="reservation.jsp"
		onsubmit="return display();" name="form" method="post">
		<table border="1" align="center">
			<thead>
				<tr>
					<th>BUS_ID</th>
					<th>INCOME</th>
					<th>Date</th>
				</tr>
			</thead>



				<%
					if (incomeDetails != null) {
						for (Journey income : incomeDetails) {
				%>
			<tr>
				<td><%=income.getBus().getBus_id()%></td>
				<td><%=income.getCost()%></td>
				<td><%=income.getJourney_date()%></td>
			</tr>
			<%
				}
				} else {
					out.println("no buses available");
				}
			%>
		</table>
	</form>

</body>
</html>