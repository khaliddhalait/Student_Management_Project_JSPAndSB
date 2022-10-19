<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Teacher: Add Mark</title>

<%@include file="all_css.jsp"%>
</head>
<body class="bg-card-color">
	<div><%@include file="navbar.jsp"%></div>

	<div class="container-fluid" style="margin: 0%; padding: 0px;">
		<div class="row">
			<div class="col-md-2">
				<%@include file="left-navbar.jsp"%>
			</div>

			<div class="col-md-10">
				<div class="container-fluid">
					<div>
						<c:if test="${smsg!=null}">
							<p class='text-center alert alert-success'><c:out value="${requestScope.smsg}"></c:out></p>
						</c:if>
						<c:if test="${fmsg!=null}">
							<p class='text-center alert alert-danger'><c:out value="${requestScope.fmsg}"></c:out></p>
						</c:if>
					</div>
					<h3 class="text-center">Add Mark</h3>
					<div class="card">
						<div class="card-body">
							<form id="myform" onsubmit="return validate()" action="/teacher/addmark" modelAttribute="mark" method="post">

								<input type="hidden" value="${requestScope.asobj.id}" name="sid">

								<div class="form-row">
									<div class="form-group col-md-3">
										<label>Roll</label> <input type="text" class="form-control"
											readonly value="${requestScope.asobj.roll}" name="roll">
									</div>
									<div class="form-group col-md-3">
										<label>Name</label> <input type="text" class="form-control"
											readonly value="${requestScope.asobj.name}" name="sname">
									</div>


									<div class="form-group col-md-3">
										<label>Course</label> <input type="text" class="form-control"
											readonly value="${requestScope.asobj.course}" name="course">
									</div>

									<div class="form-group col-md-3">
										<label>Semestar</label> <input type="text"
											class="form-control" readonly value="${requestScope.asobj.semestar}"
											name="semestar">
									</div>
								</div>

								<div class="form-row">
									<div class="form-group col-md-5">
										<label>Subject</label> <select name="subject"
											class="custom-select " id="inlineFormCustomSelectPref">
											<option selected>Choose...</option>
											<c:forEach var="p" items="${requestScope.allsub}">
									<option value="${p.subject}">${p.subject}</option>
								</c:forEach>
										</select>
									</div>
									<div class="form-group col-md-5">
										<label>Mark</label> <input type="number" class="form-control"
											min=0 max=100 name="mark" required>
									</div>

								</div>

								<button class="btn btn-success">Submit</button>

							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

<script type="text/javascript">
		function validate() {
			var subject = document.forms["myform"]["subject"].value;
			if (subject == "Choose...") {
				alert("Please select valid subject");
				return false;
			}
		}
	</script>
</body>
</html>