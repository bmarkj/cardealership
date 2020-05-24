<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>


<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Vehicle Details</title>
		<link rel="stylesheet" href="./css/style.css" type="text/css">
		
	</head>
	
	<body>
		<div class="detailpage">
			<h2 class="detailHeader">Vehicle Specifications</h2> 
			<a href="index.jsp"><button class="return"><h2>X</h2></button></a>
			<br>
			<img src="${thisVehicle.imgSrc}" height="300px" width="500px">
			<ul class="details">
				<li><b>Vehicle: </b><c:out value="${thisVehicle.year}" />
					<span>&nbsp;</span><c:out value="${thisVehicle.make}" /> 
					<span>&nbsp;</span><c:out value="${thisVehicle.model}" />
				</li>
				<li><b>Stock#: </b><c:out value="${thisVehicle.vehId}" /></li>
				<li><b>Color: </b><c:out value="${thisVehicle.color}" /></li>
				<li><b>Style: </b><c:out value="${thisVehicle.bodyStyle}" /></li>
				<li><b>Status: </b><c:out value="${thisVehicle.condition}" /></li>
				<c:if test="${thisVehicle.condition == 'Used' || thisVehicle.condition == 'Classic'}">
					<li><b>Miles: </b><c:out value="${thisVehicle.miles}" /></li>
				</c:if>
				<br>
				<li><c:out value="${thisVehicle.description }" /></li>
				<br>
				<li><b>Price: $</b><c:out value="${thisVehicle.priceSticker}" /></li>
			</ul>
			<hr>
			<ul>
				<c:if test="${!test120}">
					<li>
						<li><a href="contract.jsp"><button class="btn-buy">Buy Now!</button></a></li>
					<li>
				</c:if>
				<c:if test="${test120}">
					<li>
					<li><p>This vehicle is eligible for a discount! Click to place a bid.
						<li><a href="contract.jsp"><button class="btn-buy">Place A Bid</button></a></li>
					<li>
				</c:if>
			</ul>
		</div>
	</body>
</html>