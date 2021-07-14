<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<title>Cleaner Registration</title>
</head>
<body>
	<h2>Cleaner Registration Form</h2>
	<hr>
	<form:form action="/cleaner-register" method="post" modelAttribute="registration">
		<table>
			<tr>
				<th><label>First Name</label></th>
				<td><form:input path="firstName" placeholder="First Name" /></td>
				<td><form:errors path="firstName"/></td>
			</tr>
			<tr>
				<th><label>Last Name</label></th>
				<td><form:input path="lastName" placeholder="First Name" /></td>
				<td><form:errors path="lastName"/></td>
			</tr>
			<tr>
				<th><label>Date of Birth</label></th>
				<td><form:input type="date" path="dateOfBirth" /></td>
				<td><form:errors path="dateOfBirth"></form:errors></td>
			</tr>
			<tr>
				<th><label>Gender</label></th>
				<td><form:radiobutton path="gender" value="Male" /> Male 
				<form:radiobutton path="gender" value="Female" /> Female</td>
				<td><form:errors path="gender"/></td>
			</tr>
			<tr>
				<th><label>Phone Number</label></th>
				<td><form:input type="text" path="phoneNumber" /></td>
				<td><form:errors path="phoneNumber"></form:errors></td>
			</tr>
			<tr>
				<th><label>Cleaner ID</label></th>
				<td><form:input path="cleanerId" placeholder="cleaner Id" /></td>
				<td><form:errors path="cleanerId"></form:errors></td>
			</tr>
			<tr>
				<th><label>Password</label></th>
				<td><form:password path="password" placeholder="password" /></td>
				<td><form:errors path="password"/></td>
			</tr>
			<tr>
				<th><label>Confirm Password</label></th>
				<td><form:password path="verifyPassword" placeholder="Re-Enter password"/></td>
				<td><form:errors path="verifyPassword"/></td>
			</tr>
			<tr>
			<td></td>
			<td><input type="submit" value="Register"></td>
			</tr>
		</table>
	</form:form>
</body>
</html>