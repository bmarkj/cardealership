<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Add A Vehicle To Inventory</title>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
		<link rel="stylesheet" href="./css/style.css" type="text/css">
	
	</head>

	<body>
		<div class="container addVehicle">
			<h4>Add Vehicle To Inventory</h4>
			<form class="container" action="AddVehServlet" method="post">
				<div class="form-group">
					<label for="imgSrc">Image URL: </label>
					<input type="text" class="form-control" name="imgSrc" id="imgSrc" >
				</div>
				<div class="form-group">
					<label for="year">Year: </label>
					<input type="text" class="form-control" name="year" id="year" >
				</div>
				<div class="form-group">
					<label for="make">Make: </label>
					<input type="text" class="form-control" name="make" id="make" >
				</div>
				<div class="form-group">
					<label for="model">Model: </label>
					<input type="text" class="form-control" name="model" id="model" >
				</div>
				<div class="form-group">
					<label for="bodyStyle">Body Style:</label>
					<select class="form-control" name="bodyStyle" id="bodyStyle">
								<option value="Sedan">Sedan</option>
								<option value="Pickup Truck">Pickup Truck</option>
								<option value="SUV">SUV</option>
								<option value="Convertible">Convertible</option>
					</select>
				</div>
				<div class="form-group">
					<label for="color">Color: </label>
					<input type="text" class="form-control" name="color" id="color" >
				</div>
				<div class="form-group">
					<label for="miles">Miles: </label>
					<input type="text" class="form-control" name="miles" id="miles" >
				</div>
				<div class="form-group">
					<label for="condition">Condition: </label>
					<select class="form-control" name="condition" id="condition">
								<option value="New">New</option>
								<option value="Used">Used</option>
								<option value="Classic">Classic</option>
					</select>
				</div>
				<div>
				<br>
					<label for="dateAdded">Date Added: </label>
					<br>
					<input type="date" name="dateAdded" value="dateAdded" id="datepicker" >
				</div>
				<div class="form-group">
				</div>
				<div class="form-group">
					<label for="priceSticker">Sticker Price:</label>
					<input type="text" class="form-control" name="priceSticker" id="priceSticker" >
				</div>
				<div class="form-group">
					<label for="description">Description: </label>
					<input type="text" class="form-control" name="description" id="description" >
				</div>
				
				<div id="outer">
					<div class="inner"><button type="submit" class="btn btn-info">Submit</button></div>
					<div class="inner"><a href="index.jsp" class="text-white"><button type="button" class="btn btn-info">Cancel</button></a></div>
				</div>
				
				
			</form>
		</div>
	</body>
</html>