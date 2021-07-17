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
<link rel="stylesheet" href="./resources/styles/cleanerSuccess.css">
<title>Cleaner Success</title>
</head>
<body>
	<div class="header">
		<div class="main">
			<h2>Cleaner Home</h2>
		</div>
		<div class="logout">
			<a class="btn btn-outline-secondary" href="/cleaner-logout">Logout</a>
		</div>

	</div>
	<hr>
	<div class="header2">
		<div class="allCleaner">
			<a class="btn btn-outline-secondary" href="/cleaner-service-list">allCleaners</a>
		</div>
	</div>
	<c:if test="${isValidUser}">
		<p style="color: green;">${userName}${validUser}</p>
	</c:if>
	<c:if test="${isCleanerServiceList}">
		<h5>Assignments...</h5>
		<table>
			<c:forEach items="${cleanerServiceList}" var="service">
				<tr>
					<td><a class="bookingStatus"
						href="/booking-service-in-detailed-cleaner?serviceId=${service.serviceId}">
							serviceId : ${service.serviceId} roomCount : ${service.roomCount}
							address :${service.address} </a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>

	<c:if test="${isBookingDetailedStatus}">

		<c:if test="${isCleanerAssigned}">
			<p style="color: green;">Cleaner Assigned Successfully</p>
		</c:if>
		<table>
			<form:form action="/update-cleaning-status?serviceId=${serviceId}"
				method="post" modelAttribute="assignCleaner">
				<tr>
					<th><label>User : </label></th>
					<td><form:input path="userName" class="input-group-text"
							value="${bookService.userName}" readonly="true" /></td>
					<th><label>Room Count : </label></th>
					<td><form:input path="roomCount" class="input-group-text"
							value="${bookService.roomCount}" readonly="true" /></td>
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
					<td><form:input path="address" class="address"
							value="${bookService.address}" readonly="true" /></td>
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
					<td><form:input path="pinCode" class="input-group-text"
							value="${bookService.pinCode}" readonly="true" /></td>
					<th><label>Contact Number : </label></th>
					<td><form:input path="contactNumber" class="input-group-text"
							readonly="true" value="${bookService.contactNumber}" /></td>
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
					<td><form:input path="fromTime" class="input-group-text"
							type="datetime-local" value="${bookService.fromTime}"
							readonly="true" /></td>
					<th><label>To Time : </label></th>
					<td><form:input path="toTime" class="input-group-text"
							type="datetime-local" value="${bookService.toTime}"
							readonly="true" /></td>
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
					<th><label>Assigned Cleaner : </label></th>
					<c:if test="${isAssigned}">
						<td><form:input path="cleanerId" type="cleanerId"
								value="${bookService.cleanerId}" selected="true" readonly="true" /></td>
					</c:if>
				</tr>
				<tr>
					<form:form action="/update-cleaning-status?serviceId=${serviceId}" modelAttribute="cleanStatus">
						<table>
						<tr>
							<th><label>Update Status : </label></th>
							<td><form:input path="cleaningStatus" value="${bookService.cleaningStatus}"/></td>
						</tr>
						<tr>
							<th></th>
							<td><input type="submit" value="Update" /></td>
						</tr>
						</table>
					</form:form>
				</tr>
			</form:form>
		</table>
	</c:if>
</body>
</html>