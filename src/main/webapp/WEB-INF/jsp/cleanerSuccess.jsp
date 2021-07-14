<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
	<c:if test="${isValidUser}">
		<p style="color: green;">${userName} ${validUser}</p>
	</c:if>
</body>
</html>