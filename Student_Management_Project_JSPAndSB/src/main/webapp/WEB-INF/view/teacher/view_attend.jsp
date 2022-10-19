
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Attendance</title>
<%@include file="all_css.jsp"%>
</head>
<body>
	<div>
		<%@include file="navbar.jsp"%></div>
	<div class="container-fluid" style="margin: 0%; padding: 0px;">
		<div class="row">
			<div class="col-md-2">
				<%@include file="left-navbar.jsp"%>
			</div>

			<div class="col-md-10">
				<div class="container-fluid text-center">
					
					<c:if test="${smsg!=null}">
								<p class='text-center alert alert-success'><c:out value="${requestScope.smsg}"></c:out></p>
							</c:if>
							<c:if test="${fmsg!=null}">
								<p class='text-center alert alert-danger'><c:out value="${requestScope.fmsg}"></c:out></p>
							</c:if>
					<h3>
						Attendance</h3>
				</div>

				<div class="card">
					<div class="card-body">

						<table class="table table-bordered mt-2 bg-light text-center">
							<thead class="bg-primary text-white">
								<tr>
									<th scope="col">Year</th>
									<th scope="col">Month</th>
									<th scope="col">No Of Days</th>
									<th scope="col">Action</th>
								</tr>
							</thead>
							<tbody>

								<c:forEach var="p" items="${requestScope.alist}">
								<tr>
									<td>${p.year}</td>
									<td>${p.month}</td>
									<td>${p.days}</td>
									<td><a href="/teacher/edit_attend/${p.id}"
										class="btn btn-sm btn-success"><i class="fas fa-edit"></i>
											Edit</a> <a
										href="/teacher/deleteattendance/${p.id}/${p.sid}/${p.semestar}"
										class="btn btn-sm btn-danger"><i class="fas fa-trash-alt"></i>
											Delete</a></td>
								</tr>
							</c:forEach>
							</tbody>
						</table>
					</div>
				</div>


			</div>
		</div>
	</div>

</body>
</html>