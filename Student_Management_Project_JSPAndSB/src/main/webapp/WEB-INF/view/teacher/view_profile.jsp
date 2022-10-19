<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit teacher</title>
<%@include file="all_css.jsp"%>
</head>
<body class="bg-card-color">
	<div>
		<%@include file="navbar.jsp"%></div>
	<div class="container-fluid" style="margin: 0%; padding: 0px;">
		<div class="row">
			<div class="col-md-2">
				<%@include file="left-navbar.jsp"%>
			</div>

			<div class="col-md-10  p-5">

				<div class="card">
					<div class="card-body">
						<div>
							<c:if test="${smsg!=null}">
								<p class='text-center alert alert-success'><c:out value="${requestScope.smsg}"></c:out></p>
							</c:if>
							<c:if test="${fmsg!=null}">
								<p class='text-center alert alert-danger'><c:out value="${requestScope.fmsg}"></c:out></p>
							</c:if>
						</div>
						<div class="card-title">
							<h3 class="text-center">Profile</h3>
						</div>
						<hr>
						<div>
							<input type="hidden" value="${sessionScope.obj.id}" name="id">
							<table class="table table-bordered text-center">
								<thead class="bg-light">
									<tr>
										<th colspan="2">Profile of ${sessionScope.tobj.name}</th>
									</tr>
								</thead>
								<tbody>

									<tr>
										<td>Name</td>
										<td>${sessionScope.tobj.name}</td>
									</tr>
									<tr>
										<td>Gender</td>
										<td>${sessionScope.tobj.gender}</td>
									</tr>
									<tr>
										<td>Birth date</td>
										<td>${sessionScope.tobj.dob}</td>
									</tr>
									<tr>
										<td>Qualification</td>
										<td>${sessionScope.tobj.qualification}</td>
									</tr>
									<tr>
										<td>Email</td>
										<td>${sessionScope.tobj.email}</td>
									</tr>

								</tbody>
							</table>

						</div>
						<!-- Button trigger modal -->

						<div>
							<button class="btn btn-success" data-toggle="modal"
								data-target="#updatepassword">Update Password</button>


							<!-- Modal -->
							<div class="modal fade" id="updatepassword" tabindex="-1"
								role="dialog" aria-labelledby="exampleModalLabel"
								aria-hidden="true">
								<div class="modal-dialog" role="document">
									<div class="modal-content">
										<div class="modal-header">
											<h5 class="modal-title" id="exampleModalLabel">Update
												Passsword</h5>
											<button type="button" class="close" data-dismiss="modal"
												aria-label="Close">
												<span aria-hidden="true">&times;</span>
											</button>
										</div>
										<div class="modal-body bg-card-color">
											<div class="card">
												<div class="card-body">
													<form id="cpform" onsubmit="return validatePassword()"
													 action="/teacher/updatepassword" method="post">
														<div class="form-group">
															<label for="">Enter current Password</label> <input
																type="password" name="cpassword" required id=""
																class="form-control"> <label for="">Enter
																new Password</label> <input type="password" name="npassword"
																required id="" class="form-control"> <label
																for="">Enter confirm Password</label> <input
																type="password" name="cnfpassword" required id=""
																class="form-control"> <input type="hidden"
																value="${sessionScope.tobj.email}" name="email"> <br>
															<button class="btn btn-success"
																onClick="validatePassword()">Update password</button>
														</div>
													</form>



												</div>
											</div>
										</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-secondary"
												data-dismiss="modal">Close</button>
										</div>
									</div>
								</div>
							</div>
							<!-- Button trigger modal end -->
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<script type="text/javascript">
	function validatePassword() {
	    var cpassword = document.forms["cpform"]["cpassword"].value;
	    var npassword = document.forms["cpform"]["npassword"].value;
	    var cnfpassword = document.forms["cpform"]["cnfpassword"].value;
	    if (npassword !== cnfpassword) {
	        alert("confirm password missmatch");
	        return false;
	    }

	    if (cpassword.length < 8 || npassword.length < 8) {
	        alert("password lenght should not be less than 8");
	        return false;
	    }
	    return true;
	}
	</script>
</body>
</html>