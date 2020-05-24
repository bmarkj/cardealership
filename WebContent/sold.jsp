<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Sold!</title>
		<link rel="stylesheet"
			href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
			integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
			crossorigin="anonymous">
		<link rel="stylesheet" href="./css/style.css" type="text/css">
	</head>
		<body class="detailpage">
			<h3>Thank you!</h3>
			<span class="message" ><c:out value="${message}" /></span>
			<br>
			<br>
			<a href="index.jsp" ><button class="btn btn-info" >Exit</button></a>
		
		</body>
</html>