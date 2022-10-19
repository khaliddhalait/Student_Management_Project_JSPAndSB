
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin: Student-Details</title>
<%@include file="all_css.jsp"%>
<link href="admin/style.css" rel="stylesheet">
</head>
<body class="bg-card-color">
	<div>
		<%@include file="navbar.jsp"%></div>

	<div class="container-fluid" style="margin: 0%; padding: 0px;">
		<div class="row">
			<div class="col-md-2">
				<%@include file="left-navbar.jsp"%>
			</div>
			<div class="col-md-10">
				<div class="container-fluid">
					<h3 class="text-center text-success">Student Details</h3>

					<div class="card">
						<div class="card-body">
							<form id="myform" onsubmit="return validate()"
								class="form-inline" action="/teacher/getstudent"
								method="post">
								<div class="form-group col-md-5 mt-1">
									<h5>Course</h5>
								</div>

								<div class="form-group col-md-4 mt-1">

									<h5>Semestar</h5>
								</div>


								<div class="form-group col-md-4">
									<select name="course" class="custom-select "
										id="inlineFormCustomSelectPref">
										<option selected>Choose...</option>
										<c:forEach var="p" items="${requestScope.allCourse}">
									<option value="${p.course}">${p.course}</option>
								</c:forEach>
									</select>
								</div>

								<div class="form-group col-md-4 mt-1">
									<select class="custom-select " id="inlineFormCustomSelectPref"
										name="semestar">
										<option selected>Semestar</option>
										<option value="1st Sem">1st Sem</option>
										<option value="2nd Sem">2nd Sem</option>
										<option value="3rd Sem">3rd Sem</option>
										<option value="4th Sem">4th Sem</option>
										<option value="5th Sem">5th Sem</option>
										<option value="6th Sem">6th Sem</option>
										<option value="7th Sem">7th Sem</option>
										<option value="8th Sem">8th Sem</option>
									</select>

								</div>

								<input type="hidden" name="viewtype" value="view">

								<button class="btn btn-success">View</button>
							</form>

						</div>
					</div>




				</div>
			</div>

		</div>
	</div>

	<script type="text/javascript">
		function validate() {
			var course = document.forms["myform"]["course"].value;
			if (course == "Choose...") {
				alert("Please select valid course");
				return false;
			}

			var Semestar = document.forms["myform"]["semestar"].value;
			if (Semestar == "Semestar") {
				alert("Please select valid semestar");
				return false;
			}
		}
	</script>
</body>
</html>