<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin: Teacher-Details</title>
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

				<div class="container-fluid">
					
					<div class="card">
						<div>
							<c:if test="${smsg!=null}">
								<p class='text-center alert alert-success'><c:out value="${requestScope.smsg}"></c:out></p>
							</c:if>
							<c:if test="${fmsg!=null}">
								<p class='text-center alert alert-danger'><c:out value="${requestScope.fmsg}"></c:out></p>
							</c:if>
						</div>
						<h3 class="text-center text-success">Staff Details</h3>
						<div class="card-header">Staff Details</div>

						<div class="card-body">

							<table class="table table-bordered mt-2 table-striped">
								<thead class="bg-primary text-white">
									<tr>
										<th scope="col">Name</th>
										<th scope="col">Email</th>
										<th scope="col">DOB</th>
										<th scope="col">Gender</th>
										<th scope="col">Qualification</th>
										<th scope="col">Action</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="p" items="${requestScope.tlist}">
								
									<tr>
										<td>${p.name}</td>
										<td>${p.email}</td>
										<td>${p.dob}</td>
										<td>${p.gender}</td>
										<td>${p.qualification}</td>
										<td class="text-center"><a
											href="editteacher/${p.id}"
											class="btn btn-sm btn-success text-white"><i
												class="fas fa-edit"></i> Edit</a> <a
											href="deleteteacher/${p.id}"
											class="btn btn-sm btn-danger text-white"><i
												class="fas fa-trash-alt"></i> Delete</a></td>
									</tr>
								</c:forEach>
									
								</tbody>
							</table>
						</div>
					</div>


				</div>
			</div>
		</div>

	</div>
</body>
</html>