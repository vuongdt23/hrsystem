<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ page isELIgnored="false"%>

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
<title>List of Employees</title>

<!-- reference our style sheet -->



</head>

<body>
	<div>
		<div class="container rounded bg-white mt-5 mb-5">
			<div class="row">
				<div class="col-md-3 border-right">
					<div
						class="d-flex flex-column align-items-center text-center p-3 py-5">
						<img class="rounded-circle mt-5" width="150px"
							src="https://st3.depositphotos.com/15648834/17930/v/600/depositphotos_179308454-stock-illustration-unknown-person-silhouette-glasses-profile.jpg"><span
							class="font-weight-bold">${employee.employeeName}</span><span
							class="text-black-50">${employee.employeeEmail}</span><span>
						</span>
					</div>
				</div>
				<div class="col-md-5 border-right">
					<div class="p-3 py-5">
						<div
							class="d-flex justify-content-between align-items-center mb-3">
							<h4 class="text-right">Profile Settings</h4>
						</div>

						<form:form modelAttribute="employee" action="saveEmployee">


							<div class="col-md-12">
								<form:label path="employeeName" class="labels">Name</form:label>

								<form:input path="employeeName" type="text" class="form-control"></form:input>
							</div>
							<div class="col-md-12">
								<form:label path="employeeCode" class="labels">Code</form:label>

								<form:input path="employeeCode" type="text" class="form-control"></form:input>
							</div>
							<div class="col-md-12">
								<form:label path="employeePhone" class="labels">Mobile Number</form:label>

								<form:input path="employeePhone" type="text"
									class="form-control"></form:input>
							</div>

							<div class="col-md-12">
								<form:label path="employeeAddress" class="labels">Address</form:label>

								<form:input path="employeeAddress" type="text"
									class="form-control"></form:input>
							</div>
							<div class="col-md-12">
								<form:label path="employeePosition" class="labels">Position</form:label>

								<form:select  path="employeePosition" class="form-control">
									<c:forEach items="${positionList}" var="position">
										<form:option value="${position}">${position.employeePositionName}</form:option>
									</c:forEach>
								</form:select>


							</div>


							<div class="mt-5 text-center">
								<button class="btn btn-primary profile-button" type="submit">Save
									Profile</button>
							</div>
						</form:form>

					</div>
				</div>

			</div>
		</div>
	</div>
	</div>
	</div>






</body>

</html>









