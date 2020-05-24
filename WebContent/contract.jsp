<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Sales Invoice</title>
		<link rel="stylesheet"
			href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
			integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
			crossorigin="anonymous">
		<link rel="stylesheet" href="./css/style.css" type="text/css">
	</head>

	<body>
		<div class="container addVehicle">
			<h4 class="center">Sales Invoice</h4>
			<hr style="margin-top: 0px;">
			
			<div>
				<form class="container" action="SalesContractServlet" method="post">
					<div class="form-group">
						<label for="dateSold"><b>Date of Sale:</b></label>&nbsp;
						<input type="date" name="dateSold" id="datepicker">
						<br>
						<label for="buyer"><b>Buyer:</b></label>&nbsp;
						<input type="text" name="buyer" placeholder="Firstname Lastname"/>
						<br>
						<label for="vehId"><b>Stock#:</b></label><span>&nbsp; ${thisVehicle.vehId}</span>
						<br>
						<label for="year"><b>Year:</b></label><span>&nbsp; ${thisVehicle.year}</span>
						<br>
						<label for="make"><b>Make:</b></label><span>&nbsp; ${thisVehicle.make}</span>
						<br>
						<label for="model"><b>Model:</b></label><span>&nbsp; ${thisVehicle.model}</span>
						<br>
						<label for="bodyStyle"><b>Body Style:</b></label><span>&nbsp; ${thisVehicle.bodyStyle}</span>
						<br>
						<label for="color"><b>Color:</b></label><span>&nbsp; ${thisVehicle.color}</span>
						<br>
						<label for="miles"><b>Miles:</b></label><span>&nbsp; ${thisVehicle.miles}</span>
						<br>
						<label for="condition"><b>Condition:</b></label><span>&nbsp; ${thisVehicle.condition}</span>
						<br>
						<label for="priceSticker"><b>Sticker Price:</b>&nbsp; $</label><span>${thisVehicle.priceSticker}</span>
						<br>
						<br>
						<label for="priceOffered"><b>Buyer's Offer:</b></label> <input type="text"
							class="form-control" name="priceOffered" id="priceOffered">
					</div>
					<span class="message"><c:out value="${message}" /></span>
					<br>
					<br>
					<div id="outer">
					<input type="hidden" name="vehId" value="${thisVehicle.vehId }" />
					<div class="inner"><button type="submit" class="btn btn-info">Submit</button></div>
					<div class="inner"><a href="index.jsp" class="text-white"><button type="button" class="btn btn-info">Cancel</button></a></div>
				</div>
				</form>
			</div>
		</div>
	</body>
</html>