<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
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
<link rel="stylesheet" href="./resources/styles/adminSuccess.css">
<title>Admin Success</title>
</head>
<body>
	<div class="header">
		<div class="main">
			<h2>Admin Home</h2>
		</div>
		<div class="logout">
			<a class="btn btn-outline-secondary" href="/admin-logout">Logout</a>
		</div>

	</div>
	<hr>
	<div class="header2">
		<div class="allCleaner">
			<a class="btn btn-outline-secondary" href="/all-cleaners-list">allCleaners</a>
		</div>
		<div class="pendingCleaner">
			<a class="btn btn-outline-secondary" href="/pending-cleaners-list">pendingCleaners</a>
		</div>
		<div class="bookedServices">
			<a class="btn btn-outline-secondary" href="/booked-services">bookedServices</a>
		</div>
	</div>
	<div>
		<c:if test="${allCleaner}">

			<table class="table">
				<%
					int count = 0;
				%>
				<thead class="thead-light">
					<tr style="height: 50px">
						<th>S.No</th>
						<th>Cleaner Id</th>
						<th>Cleaner Name</th>
						<th>Mobile</th>
						<th>Registration Status</th>
					</tr>
				</thead>
				<c:forEach items="${allCleanerRegistrationList}" var="cleaner">
					<tbody>
						<tr>
							<td>
								<%
									count++;
											out.print(count);
								%>
							</td>
							<td>${cleaner.cleanerId}</td>
							<td>${cleaner.firstName}${cleaner.lastName}</td>
							<td>${cleaner.phoneNumber}</td>
							<td>${cleaner.cleanerRegistrationStatus}</td>
						</tr>
					</tbody>
				</c:forEach>
			</table>
		</c:if>
		<c:if test="${isListEmpty}">
			${emptyList}
		</c:if>

		<c:if test="${pendingCleaner}">
			<table class="table">
				<%
					int count = 0;
				%>
				<thead class="thead-light">
					<tr style="height: 50px">
						<th>S.No</th>
						<th>Cleaner Id</th>
						<th>Cleaner Name</th>
						<th>Mobile</th>
						<th>Registration Status</th>
						<th>Approve Action</th>
						<th>Deny Action</th>
					</tr>
				</thead>
				<c:forEach items="${pendinCleanerRegistrationList}" var="cleaner">
					<tbody>
						<tr>
							<td>
								<%
									count++;
											out.print(count);
								%>
							</td>
							<td>${cleaner.cleanerId}</td>
							<td>${cleaner.firstName}${cleaner.lastName}</td>
							<td>${cleaner.phoneNumber}</td>
							<td>${cleaner.cleanerRegistrationStatus}</td>
							<td><a
								href="/approve-cleaner?cleanerId=${cleaner.cleanerId}">Approve</a></td>
							<td><a href="/deny-cleaner?cleanerId=${cleaner.cleanerId}">Deny</a></td>
						</tr>
					</tbody>
				</c:forEach>
			</table>
		</c:if>
		<c:if test="${isAllServiceList}">
			<h6>All Bookings</h6>
			<table class="table">
				<tbody>
					<c:forEach items="${allBookServiceList}" var="bookService">
						<tr>
							<td><a class="bookingStatus"
								href="/booking-service-in-detailed-admin?serviceId=${bookService.serviceId}">
									serviceId : ${bookService.serviceId} roomCount :
									${bookService.roomCount} address :${bookService.address} </a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
		<c:if test="${allServiceList}">
			Booking List is Empty...
		</c:if>
		<c:if test="${isBookingDetailedStatus}">

			<c:if test="${isCleanerAssigned}">
			<p style="color:green;">Cleaner Assigned Successfully</p>
		</c:if>
			<table>
				<form:form action="/assignCleaner?serviceId=${serviceId}"
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
									value="${bookService.cleanerId}" selected="true"
									readonly="true" /></td>
						</c:if>
						<th><label>Cleaning Status msg : </label></th>
						<c:if test="${isAssigned}">
							<td><form:input path="cleaningStatus" value="${bookService.cleaningStatus}"/></td>
						</c:if>
						<th><label>Payment Status : </label></th>
						<c:if test="${isAssigned}">
							<td><form:input path="paymentStatus" value="${bookService.paymentStatus}"/></td>
						</c:if>
						<c:if test="${notAssigned}">
							<td><form:select path="cleanerId">
									<form:option value="" label="Select" />
									<form:options items="${cleanerList}" />
								</form:select></td>
						</c:if>
						<form:errors path="cleanerId" />
					</tr>
					<c:if test="${notAssigned}">
						<tr>
							<th></th>
							<td><input type="submit" value="Assign"></td>
						</tr>
					</c:if>
				</form:form>
			</table>
		</c:if>
	</div>

</body>
</html>