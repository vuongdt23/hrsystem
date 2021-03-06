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




	<div class="container">
		<div class="row">
			<h2>New Employee</h2>
		</div>
		<div class="row">
			<div class="container-fluid px-1 py-5 mx-auto">
				<div class="row d-flex justify-content-center">
					<div class="col-xl-7 col-lg-8 col-md-9 col-11 text-center">
						<h3>Add New Employee</h3>
						<p class="blue-text">Fill in the form to create a new Employee
							Record</p>
						<div class="card">
							<h5 class="text-center mb-4">Powering world-class companies</h5>
							<form:form cssClass="container" method="POST"
								action="/hr-system/employees/saveEmployee"
								modelAttribute="employee" class="form-card">

								<div class="form-group row form-inline">

									<form:label for="nameInput" class="form-label col-2"
										path="employeeName"> Name: </form:label>
									<form:input id="nameInput" path="employeeName"
										class="form-control col-8" />
									<form:errors path="employeeName" cssClass="text-danger col-2">
									</form:errors>
								</div>


								<div class="form-group row form-inline">
									<form:label for="codeInput" path="employeeCode"
										class="form-label col-2"> Code:  </form:label>
									<form:input id="codeInput" path="employeeCode"
										class="form-control col-8" />

								</div>
								<div class="form-group row form-inline">
									<form:label for="emailInput" path="employeeEmail"
										class="form-label col-2">Email:  </form:label>
									<form:input id="emailInput" path="employeeEmail"
										class="form-control col-8" />
									<form:errors path="employeeEmail" cssClass="text-danger col-2">
									</form:errors>
								</div>
								<div class="form-group row form-inline">
									<form:label for="phoneInput" path="employeePhone"
										class="form-label col-2">Phone: </form:label>
									<form:input id="phoneInput" path="employeePhone"
										class="form-control col-8" />
									<form:errors path="employeePhone" cssClass="text-danger col-2">
									</form:errors>
								</div>
								<div class="form-group row form-inline">
									<form:label for="addressInput" path="employeeAddress"
										class="form-label col-2"> Address</form:label>
									<form:input id="addressInput" path="employeeAddress"
										class="form-control col-8" />
									<form:errors path="employeeAddress"
										cssClass="text-danger col-2">
									</form:errors>
								</div>
								<div class="form-group row form-inline">
									<form:label for="dateInput" path="employeeStartDate"
										class="form-label col-2"> Start Date:</form:label>
									<form:input type="text" cssClass="form-control col-8"
										path="employeeStartDate" id="datepicker" />
										<form:errors path="employeeStartDate"
										cssClass="text-danger col-2">
									</form:errors>
								</div>


								<button type="submit" class="btn-block btn-primary">Add
									New Employee</button>
							</form:form>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>

</body>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.0/jquery-ui.js"></script>
<script>
	$(function() {
		$("#datepicker").datepicker();
	});
</script>
</html>









