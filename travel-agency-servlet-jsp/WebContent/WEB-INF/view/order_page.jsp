<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Order Page</title>
</head>
<body>
	<h1>Welcome to the Order page</h1>
	
	<form action="TravelAgencyController" method="post">
		<p>First Name:<br/>
		<input type="text" name="fname" /></p>
		<p>Last Name:<br/>
		<input type="text" name="lname" /></p>
		<p>Passport:<br/>
		<input type="text" name="passport" /></p>
		<input type="hidden" name="command" value="make_an_order">
		<input type="hidden" name="t_id" value="${tour_id}">
		<input type="submit" value="confirm">
	</form>

</body>
</html>