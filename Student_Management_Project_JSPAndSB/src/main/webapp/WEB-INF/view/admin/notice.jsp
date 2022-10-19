<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="ISO-8859-1">
	<title>Admin : View Notice</title>
	<%@include file="all_css.jsp" %>
</head>

<body class="bg-card-color">

	<%@include file="navbar.jsp" %>

		<div class="container-fluid" style="margin: 0%; padding: 0px;">
			<div class="row">
				<div class="col-md-2">
					<%@include file="left-navbar.jsp" %>
				</div>


				<div class="col-md-10">
					<div>
						<c:if test="${smsg!=null}">
							<p class='text-center alert alert-success'>
								<c:out value="${requestScope.smsg}"></c:out>
							</p>
						</c:if>
						<c:if test="${fmsg!=null}">
							<p class='text-center alert alert-danger'>
								<c:out value="${requestScope.fmsg}"></c:out>
							</p>
						</c:if>
					</div>
					<div class="container-fluid m-3">
						<div class="card mt-2">
							<div class="card-body">
								<div class="text-center text-danger">
									<i class="far fa-clipboard fa-2x"></i>
								</div>
								<div class="col-md-6 offset-md-3">
									<form action="/admin/addnotice" modelAttribute="notice" method="post">
										<input type="hidden" name="name" value="Admin">
										<div class="form-group">
											<label>Enter Notice</label>
											<textarea rows="5" cols="" class="form-control" name="message"
												required></textarea>
										</div>
										<br>
										<center><button class="btn btn-success">Publish</button></center>
									</form>
									<div><br>
										<center>
											<a class="btn btn-success" href="viewnotice" role="button">View All</a>
										</center>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
</body>

</html>