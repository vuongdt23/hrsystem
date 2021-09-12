<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<%@page pageEncoding="UTF-8" %>
<!DOCTYPE html>

<html>

<head>
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
<title>List Customers</title>

<!-- reference our style sheet -->



</head>

<body>

	<div class="container">



		<div id="container">
			<div class="row">
				<h2>Employee List</h2>
			</div>
			<div class="row">



				<table class="table table-dark">
					<tr>
						<th>Name</th>
						<th>Email</th>
						<th>Address</th>
						<th>Phone</th>

					</tr>

					<!-- loop over and print our customers -->

					<c:forEach var="e" items="${employeeList}">
						<c:url var="detail" value="/employees/${e.employeeCode}">
							
						</c:url>
						<tr>
							<td>${e.employeeName}</td>
							<td>${e.employeeEmail}</td>
							<td>${e.employeeAddress}</td>
							<td>${e.employeePhone}</td>

							<td><a href="${detail}"> Detail </a></td>
						</tr>

					</c:forEach>

				</table>

			</div>
			<div class="row">
				<button type="button" class="btn btn-primary"
					onClick="window.location.href='employees/newEmployee'">Add
					Employee</button>
			</div>
		</div>
	</div>

</body>

</html>









