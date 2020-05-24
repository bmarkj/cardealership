<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport"
			content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<meta name="generator" content="Jekyll v3.8.6">
		<title>Mid-City Automotive</title>
		<link rel="stylesheet"
			href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
			integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
			crossorigin="anonymous">
		
		<link rel="canonical"
			href="https://getbootstrap.com/docs/4.4/examples/album/">
		
		<!-- Favicons -->
		<link rel="apple-touch-icon"
			href="/docs/4.4/assets/img/favicons/apple-touch-icon.png"
			sizes="180x180">
		<link rel="icon" href="/docs/4.4/assets/img/favicons/favicon-32x32.png"
			sizes="32x32" type="image/png">
		<link rel="icon" href="/docs/4.4/assets/img/favicons/favicon-16x16.png"
			sizes="16x16" type="image/png">
		<link rel="manifest" href="/docs/4.4/assets/img/favicons/manifest.json">
		<link rel="mask-icon"
			href="/docs/4.4/assets/img/favicons/safari-pinned-tab.svg"
			style="color: #563d7c">
		<link rel="icon" href="/docs/4.4/assets/img/favicons/favicon.ico">
		<meta name="msapplication-config"
			content="/docs/4.4/assets/img/favicons/browserconfig.xml">
		<meta name="theme-color" content="#563d7c">
		
		<style>
		.bd-placeholder-img {
			font-size: 1.125rem;
			text-anchor: middle;
			-webkit-user-select: none;
			-moz-user-select: none;
			-ms-user-select: none;
			user-select: none;
		}
		
		@media ( min-width : 768px) {
			.bd-placeholder-img-lg {
				font-size: 3.5rem;
			}
		}
		</style>
		
		<!-- Custom styles for this template -->
		<link href=".\css\style.css" rel="stylesheet" type="text/css">
	</head>

	<body>
		<header>
			<div class="collapse bg-dark" id="navbarHeader">
				<div class="container">
					<div class="row">
						<div class="col-sm-8 col-md-7 py-4">
							<h4 class="text-white">About</h4>
							<p class="text-muted">Mid-City Automotive has been serving the greater metropolitan area 
									for over 70 years. Visit our showroom today to see the finest new and used vehicles 
									available anywhere!</p>
						</div>
						<div class="col-sm-4 offset-md-1 py-4">
							<h4 class="text-white">Links</h4>
							<ul class="list-unstyled">
								<li><a href="vehicle.jsp" class="text-white"><button class="btn btn-primary">Add A Car To Inventory</button></a></li>
								<li><a href="#" class="text-white">Sales Reports</a></li>
								<li><a href="#" class="text-white">Contact Us</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
			<div class="navbar navbar-dark bg-dark shadow-sm">
				<div class="container d-flex justify-content-between">
					<a href="index.jsp" class="navbar-brand d-flex align-items-center">
						<strong>Mid-City Automotive</strong>
					</a>
					<button class="navbar-toggler" type="button" data-toggle="collapse"
						data-target="#navbarHeader" aria-controls="navbarHeader"
						aria-expanded="false" aria-label="Toggle navigation">
						<span class="navbar-toggler-icon"></span>
					</button>
				</div>
			</div>
		</header>
	
		<main role="main">
			<section class="jumbotron text-center">
				<div class="container">
					<h1>Mid-City Automotive</h1>
					<p class="lead text-muted">Mid-city's finest collection of
						quality new, used and classic automobiles for a discriminating clientele.</p>
					
				</div>
			</section>
			<div class="spacer bg-dark">
				<div class="filter">
					<form action="FilterByMakeServlet" style="display: inline-block;" method="Get">
						<label for="make">Make: </label>
						<select class="my-1" name="make" id="make">
							<option value="All">All</option>
							<c:forEach var="make" items="${vehMakes}"> 
								<option value="${make}">${make}</option>
							</c:forEach>
						</select>
						<button type="submit">Filter</button>
					</form>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<form action="FilterByConditionServlet" style="display: inline-block;" method="Get">
							<label for="make">Condition: </label>
							<select class="my-1" name="condition" id="condition">
								<option value="All">All</option>
								<c:forEach var="condition" items="${vehConditions}"> 
									<option value="${condition}">${condition}</option>
								</c:forEach>
							</select>
							<button type="submit">Filter</button>
						</form>
					</div>
			</div><!-- end div "spacer" -->			
			<div class="album py-5 bg-light">
				<div class="container">
					<div class="row">
						<c:forEach var="vehicle" items="${vehicles}">
							<div class="col-md-4">
								<div class="card mb-4 shadow-sm">
									<img src = "${vehicle.imgSrc}" height="225" width="100%">
									<svg class="bd-placeholder-img card-img-top" width="100%"
										height="0" xmlns="http://www.w3.org/2000/svg"
										preserveAspectRatio="xMidYMid slice" focusable="false"
										role="img" aria-label="Placeholder: Thumbnail">
									</svg>
									<div class="card-body">
										<div class="d-flex justify-content-between align-items-center">
											<form action="DisplayDetailsServlet">
												<input type="hidden" id="vehId" name="vehId" value="${vehicle.vehId}">
												<div class="btn-group">
													<button type="submit" class="bn"><b><c:out value="${vehicle.year}"/><span>&nbsp;</span><c:out value="${vehicle.make}"/><span>&nbsp;</span><c:out value="${vehicle.model}"/></b></button>
												</div>
											</form>
										</div>
									</div>
								</div><!-- end div card -->
							</div><!-- end div col-md-4 -->
						</c:forEach>
					</div><!-- end div class="row" -->
				</div><!-- end div class="container" -->		
			</div><!-- end div class="album py-5 bg-light" -->
		</main>
	
		<footer class="text-muted">
			<div class="container">
				<p class="float-right">
					<a href="#">Back to top</a>
				</p>
			</div>
		</footer>
	
		<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
			integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
			crossorigin="anonymous"></script>
		<script
			src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
			integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
			crossorigin="anonymous"></script>
		<script
			src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
			integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
			crossorigin="anonymous"></script>
	</body>
</html>