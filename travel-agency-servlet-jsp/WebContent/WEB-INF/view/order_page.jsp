<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Order Page</title>

<style type="text/css">
.content {
	text-align: center;
	border: 1px solid black;
	padding-bottom: 20px;
	width: 400px;
	margin: 0 auto;
}
h1 {
	text-align: center;
}
</style>
</head>
<body>
	<h1>Welcome to the Order page</h1>
	
	<div class="content">
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
			<br/>
		<form action="TravelAgencyController">
			<input type="hidden" name="command" value="go_to_main_page" />
			<input type="submit" value="back to main" />
		</form>
	</div>
</body>
</html>