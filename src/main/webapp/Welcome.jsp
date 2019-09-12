<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
</head>
<style>
marquee {
	width: 100%;
	padding: 10px 0;
	background-color: lightblue;
}
</style>
<body align="center" bgcolor="D3D3D3">
	<form align="center" action="UserController" method="post">
		<table
			style="border: 1px solid black; margin-left: auto; margin-right: auto;">
			<thead align="center">
				<tr>
					<th><marquee behavior="scroll" direction="left">
							<h3>Welcome To Online Bus Reservation</h3>
						</marquee></th>
				</tr>
			</thead>
			<tr>
				<td><input type="submit" name="operation" value="ReserveTicket">
					<input type="submit" name="operation" value="CancelTicket">
					<input type="submit" name="operation" value="viewticket"> 
					<a href="STARTFROMHERE.jsp"><input type="button" value="Back"></a>
					
				</td>
			</tr>
		</table>

	</form>
</body>
</html>

