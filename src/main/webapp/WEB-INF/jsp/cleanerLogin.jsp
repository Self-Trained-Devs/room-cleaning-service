<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<title>Cleaner Login</title>
</head>
<body>
	<h2>Cleaner Login Form</h2>
	<hr>
	<c:if test="${isUserCreated}">
		<p style="color: green;">${userCreatedMessage}</p>
	</c:if>

	<form:form action="/cleaner-login-validate" method="post"
		modelAttribute="loginModel">
		<table>
		<tr>
			<th><label>User ID : </label></th>
			<td><form:input path="userId" placeholder="Enter user Id"/></td>
		</tr>
		<tr>
			<th><label>Password : </label></th>
			<td><form:password path="password" placeholder="Enter password"/></td>
		</tr>
		<tr>
			<th></th>
			<td><input type="submit" value="Login"></td>
		</tr>
		</table>
	</form:form>
	<c:if test="${inValidUser}">
		<p style="color: red;">${userName} ${invalidUser}</p>
	</c:if>
</body>
</html>