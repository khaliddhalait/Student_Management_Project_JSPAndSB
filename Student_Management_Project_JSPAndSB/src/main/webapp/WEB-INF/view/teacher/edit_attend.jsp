
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>blank</title>
<%@include file="all_css.jsp"%>
</head>
<body>
<div> <%@include file="navbar.jsp" %></div>
	<div class="container-fluid" style="margin: 0%; padding: 0px;">
		<div class="row">
			<div class="col-md-2">
				<%@include file="left-navbar.jsp"%>
			</div>

			<div class="col-md-10">
				<div class="container-fluid">
					<h3>Edit Attendance</h3>
				</div>
				<div class="card">
					<div class="card-body">
						<form action="/teacher/updateattendance" method="post">

								<input type="hidden" name="id" value="${requestScope.att.id}">
								<input type="hidden" name="sid" value="${requestScope.att.sid}">

								<div class="form-row">
									<div class="form-group col-md-4">
										<label>Full Name</label> <input type="text" name="sname"
											class="form-control" value="${requestScope.att.sname}" readonly>
									</div>

									<div class="form-group col-md-4">
										<label>Course</label> <input type="text" name="course"
											class="form-control" value="${requestScope.att.course}" readonly>
									</div>

									<div class="form-group col-md-4">
										<label>Semestar</label> <input type="text" name="semestar"
											class="form-control" value="${requestScope.att.semestar}" readonly>
									</div>

									<div class="form-group col-md-4">
										<label>Year</label> <input type="text" name="year"
											class="form-control" value="${requestScope.att.year}" readonly>


									</div>

									<div class="form-group col-md-4">
										<label>Month</label> <input type="text" name="month"
											class="form-control" value="${requestScope.att.month}" readonly>
									</div>
									 
									<div class="form-group col-md-4">
										<label>No of Days</label> <input type="number" name="days"
											class="form-control" min="0" max="31" value="${requestScope.att.days}">
									</div>
								</div>
								<button class="btn btn-success">Submit</button>
							</form>
					
					</div>
				</div>
				
				
			</div>
		</div>
	</div>
	
</body>
</html>