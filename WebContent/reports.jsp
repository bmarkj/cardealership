<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>


<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Reports Menu</title>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
		<link rel="stylesheet" href="./css/style.css" type="text/css">
		<style>
			.reportpage {
				margin-top: 25px;
				margin-left: 40%;
			}
		</style>
	</head>

	<body>	
		<div class="reportpage">
			<h4>Reports Menu</h4>
			<form action="GenerateReportServlet" method="get">
				<input type="radio" name="report" value="vehSales">
				<label for="vehSales">Vehicle Sales</label>
				<br>
				<input type="radio" name="report" value="discVeh">
				<label for="discVeh">Discounted Vehicles</label>
				<br>
				<span class="message center"><c:out value="${message}" /></span>
				<br>
				<input type="submit" class="btn btn-info" value="Get Report">
				<a href="index.jsp"><input type="button" class="btn btn-info" value="Cancel"></a>
			</form>
		</div>
		
		<br>
		<br>
		<div id="outer">
			<div class="table-responsive-xl inner" style="width: 80%;">
				<table class="table">
					<c:if test="${report != ''}">
						<c:if test="${soldVehicles != ''}">
							<tr>
								<th>Date Sold</th>
								<th>Vehicle ID</th>
								<th>Year</th>
								<th>Make</th>
								<th>Model</th>
								<th>Sticker Price</th>
								<th>Sale Amount</th>
								<th>Buyer</th>
							</tr>
							<c:forEach var="vehicle" items="${soldVehicles}">
								<tr>
									<td><c:out value="${vehicle.dateSold}" /></td>
									<td><c:out value="${vehicle.vehId}" /></td>
									<td><c:out value="${vehicle.year}" /></td>
									<td><c:out value="${vehicle.make}" /></td>
									<td><c:out value="${vehicle.model}" /></td>
									<td><c:out value="$${vehicle.priceSticker}" /></td>
									<td><c:out value="$${vehicle.priceSold}" /></td>
									<td><c:out value="${vehicle.buyer}" /></td>
								</tr>
							</c:forEach>
						</c:if>
						<c:if test="${discountedVehicles != ''}">
							<tr>
								<th>Date Acquired</th>
								<th>Vehicle ID</th>
								<th>Year</th>
								<th>Make</th>
								<th>Model</th>
								<th>Sticker Price</th>
							</tr>
							<c:forEach var="vehicle" items="${discountedVehicles}">
								<tr>
									<td><c:out value="${vehicle.dateAdded}" /></td>
									<td><c:out value="${vehicle.vehId}" /></td>
									<td><c:out value="${vehicle.year}" /></td>
									<td><c:out value="${vehicle.make}" /></td>
									<td><c:out value="${vehicle.model}" /></td>
									<td><c:out value="${vehicle.priceSticker}" /></td>
								</tr>
							</c:forEach>
						</c:if>
					</c:if>
				</table>
			</div>
		</div>
	</body>
</html>