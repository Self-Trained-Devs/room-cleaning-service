<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<link rel="stylesheet" href="./resources/styles/common.css">
<link rel="stylesheet" href="./resources/styles/userSuccess.css">
<title>User Success</title>
</head>
<body>
	<div class="header">
		<div class="main">
			<h2>User Home</h2>
		</div>
		<div class="logout">
			<a class="btn btn-outline-secondary" href="/user-logout">Logout</a>
		</div>
	</div>
	<hr>
	<div class="header2">
		<div class="bookService">
			<a class="btn btn-outline-secondary"
				href="/book-service?user=${userName}">bookService</a>
		</div>
		<div class="bookingStatus1">
			<a class="btn btn-outline-secondary" href="/booking-status">bookingStatus</a>
		</div>
	</div>
	<hr>
	<c:if test="${isBooked}">
	${BookedMessage}
	</c:if>
	<c:if test="${isBookService}">
		<h4>Book Service</h4>
		<table>
			<form:form action="/book-service" method="post"
				modelAttribute="bookService">
				<tr>
					<th><label>User : </label></th>
					<td><form:input class="input-group-text" path="userName"
							value="${userName}" readonly="true" /></td>
					<th><label>Room Count : </label></th>
					<td><form:input type="number" path="roomCount" /></td>
				</tr>
				<tr>
					<th></th>
					<td></td>
					<th></th>
					<td></td>
				</tr>
				<tr>
					<th></th>
					<td><form:errors path="userName" /></td>
					<th></th>
					<td><form:errors path="roomCount" /></td>
				</tr>
				<tr>
					<th><label>Address : </label></th>
					<td><form:input class="address" path="address" /></td>
					<th></th>
					<td></td>
				</tr>
				<tr>
					<th></th>
					<td></td>
					<th></th>
					<td></td>
				</tr>
				<tr>
					<th></th>
					<td><form:errors path="address" /></td>
					<th></th>
					<td></td>
				</tr>
				<tr>
					<th><label>Pin Code : </label></th>
					<td><form:input path="pinCode" /></td>
					<th><label>Contact Number : </label></th>
					<td><form:input path="contactNumber" /></td>
				</tr>
				<tr>
				<tr>
					<th></th>
					<td><form:errors path="pinCode" /></td>
					<th></th>
					<td><form:errors path="contactNumber" /></td>
				</tr>
				<tr>
					<th><label>From Time : </label></th>
					<td><form:input type="datetime-local" path="fromTime" /></td>
					<th><label>To Time : </label></th>
					<td><form:input type="datetime-local" path="toTime" /></td>
				</tr>
				<tr>
					<th></th>
					<td></td>
					<th></th>
					<td></td>
				</tr>
				<tr>
					<th></th>
					<td><form:errors path="fromTime" /></td>
					<th></th>
					<td><form:errors path="toTime" /></td>
				</tr>
				<tr>
					<th></th>
					<td></td>
					<th></th>
					<td><input type="submit" value="Book"></td>
				</tr>
			</form:form>
		</table>
	</c:if>
	<c:if test="${isBookingStatus}">
		<h6>${userName}!,YourBookings</h6>
		<table class="table">
			<tbody>
				<c:forEach items="${bookServiceList}" var="bookService">
					<tr>
						<td><a class="bookingStatus" href="/booking-service-in-detailed?serviceId=${bookService.serviceId}">
								serviceId : ${bookService.serviceId} 
								roomCount : ${bookService.roomCount}
								address :${bookService.address} </a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
	<c:if test="${isBookingDetailedStatus}">
		<table>
			<form:form action="/book-service" method="post"
				modelAttribute="bookService">
				<tr>
					<th><label>User : </label></th>
					<td><input class="input-group-text"
							value="${userName}" readonly="true" /></td>
					<th><label>Room Count : </label></th>
					<td><input class="input-group-text" value="${bookService.roomCount}" readonly="true" /></td>
				</tr>
				<tr>
					<th></th>
					<td></td>
					<th></th>
					<td></td>
				</tr>
				<tr>
					<th></th>
					<td></td>
					<th></th>
					<td></td>
				</tr>
				<tr>
					<th><label>Address : </label></th>
					<td><input class="address" value="${bookService.address}" readonly="true" /></td>
					<th></th>
					<td></td>
				</tr>
				<tr>
					<th></th>
					<td></td>
					<th></th>
					<td></td>
				</tr>
				<tr>
					<th></th>
					<td></td>
					<th></th>
					<td></td>
				</tr>
				<tr>
					<th><label>Pin Code : </label></th>
					<td><input class="input-group-text" value="${bookService.pinCode}" readonly="true"  /></td>
					<th><label>Contact Number : </label></th>
					<td><input class="input-group-text" readonly="true" value="${bookService.contactNumber}"/></td>
				</tr>
				<tr>
					<th></th>
					<td></td>
					<th></th>
					<td></td>
				</tr>
				<tr>
					<th></th>
					<td></td>
					<th></th>
					<td></td>
				</tr>
				<tr>
					<th><label>From Time : </label></th>
					<td><input class="input-group-text" type="datetime-local" value="${bookService.fromTime}" readonly="true"  /></td>
					<th><label>To Time : </label></th>
					<td><input class="input-group-text" type="datetime-local" value="${bookService.toTime}" readonly="true" /></td>
				</tr>
				<tr>
					<th></th>
					<td></td>
					<th></th>
					<td></td>
				</tr>
			</form:form>
		</table>
	</c:if>
	<c:if test="${isValidUser}">
		<p style="color: green;">${userName}${validUser}</p>
	</c:if>
</body>
</html>