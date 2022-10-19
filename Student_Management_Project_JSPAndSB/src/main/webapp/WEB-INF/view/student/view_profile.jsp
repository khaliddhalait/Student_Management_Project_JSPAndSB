
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>blank</title>
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
					<div>
						<c:if test="${smsg!=null}">
								<p class='text-center alert alert-success'><c:out value="${requestScope.smsg}"></c:out></p>
							</c:if>
							<c:if test="${fmsg!=null}">
								<p class='text-center alert alert-danger'><c:out value="${requestScope.fmsg}"></c:out></p>
							</c:if>
					</div>
					<br><center>
					<h3>Profile</h3></center>
				</div>

				<div class="card">
					<div class="card-body">
						<table class="table table-bordered text-center">
								<thead class="bg-light">
									<tr>
										<th colspan="2">Profile of ${sessionScope.sobj.name}</th>
									</tr>
								</thead>
								<tbody>

									<tr>
										<td>Name</td>
										<td>${sessionScope.sobj.name}</td>
									</tr>
									<tr>
										<td>PRN</td>
										<td>${sessionScope.sobj.roll}</td>
									</tr>
									<tr>
										<td>Gender</td>
										<td>${sessionScope.sobj.gender}</td>
									</tr>
									<tr>
										<td>Birth date</td>
										<td>${sessionScope.sobj.dob}</td>
									</tr>
									<tr>
										<td>Course</td>
										<td>${sessionScope.sobj.course}</td>
									</tr>
									<tr>
										<td>Semestar</td>
										<td>${sessionScope.sobj.semestar}</td>
									</tr>
									<tr>
										<td>Email</td>
										<td>${sessionScope.sobj.email}</td>
									</tr>
									<tr>
										<td>Address</td>
										<td>${sessionScope.sobj.address}</td>
									</tr>
								</tbody>
							</table>

						<!--**************************************  card body started *************************** -->


							
						</div>

						<!--**************************************  card body ended *************************** -->

					</div>
				</div>


			</div>
		</div>
	</div>

</body>
</html>