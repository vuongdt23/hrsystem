<%@ page isELIgnored="false"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>


<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
	integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
	crossorigin="anonymous"></script>
</head>
<body>
	<div class="jumbotron">
		<h1 class="display-4">Welcome to your new Human Resource
			Resolution!</h1>
		<p class="lead">Login with your username and password</p>
		<hr class="my-4">

	</div>
	<div class="container">
		<form:form cssClass="form-group"
			action="${pageContext.request.contextPath}/authenticateUser"
			method="POST">




			<p>
				User name: <input type="text" class="form-control" name="username" />
			</p>

			<p>
				Password: <input type="password" class="form-control"
					name="password" />
			</p>

			<input class="btn btn-primary" type="submit" value="Login" />

		</form:form>
		<c:if test="${param.error!=null}">
		<p class ="text-danger">Invalid credentials</p>
		</c:if>
		
	</div>
</body>
</html>