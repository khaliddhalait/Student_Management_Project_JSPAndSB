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
<div> <%@include file="navbar.jsp" %></div>

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
							<form  action="/teacher/updatemark" method="post">
								<div class="form-row">
									<div class="form-group col-md-4">
										Mark :<input type="number" class="form-control"
											name="mark" min="0" max="100" value="${requestScope.marks.mark}" required>
									</div>
									<input type="hidden" name="id" value="${requestScope.marks.id}"><input type="hidden" name="sid" value="${requestScope.marks.sid}">
									<input type="hidden" name="semester" value="${requestScope.marks.semestar}"></div>
								<button class="btn btn-success col-2">Update</button>
								</div>
							</form>

						</div>
					</div>




				</div>
			</div>

		</div>
	</div>
</body>
</html>