<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Main Page</title>

<style type="text/css">
#content {
	text-align: center;
}
table, th, td {
	margin: 0 auto;
	border: 1px solid black;
	width: 500px;
	border-collapse: collapse;
}
</style>

</head>
<body>
	<div id="content">
		<h1>Welcome to Travel Agency</h1>
		<table>
			<tr>
				<th>Id</th>
				<th>Country</th>
				<th>Hotel Stars</th>
				<th>Total coast</th>
				<th>Action</th>
			</tr>
			<c:forEach var="tour" items="${tours}">
				<c:url value="TravelAgencyController?command=go_to_order_page" var="make_an_order">
					<c:param name="tourId" value="${tour.id}" />
				</c:url>
				<tr>
					<td>${tour.id}</td>
					<td>${tour.country.name}</td>
					<td>${tour.hotel.stars}</td>
					<td>${tour.totalCoast}</td>
					<td><a href="${make_an_order}">make an order</a></td>
				</tr>
			</c:forEach>
		</table>
		<c:if test="${report != null}">
			<c:out value="${report}"/>
		</c:if>
	</div>
</body>
</html>