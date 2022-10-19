
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
<div> <%@include file="navbar.jsp" %></div>
	<div class="container-fluid" style="margin: 0%; padding: 0px;">
		<div class="row">
			<div class="col-md-2">
				<%@include file="left-navbar.jsp"%>
			</div>

			<div class="col-md-10">
				<div class="container-fluid">
					<h3>Attendance</h3>
				</div>

				<div class="card">
					<div class="card-body">

						<table class="table table-bordered mt-2 bg-light">
							<thead class="bg-primary text-white text-center">
								<tr>
										<th scope="col">Year</th>
										<th scope="col">Month</th>
										<th scope="col">No Of Days</th>
								</tr>
							</thead>
							<tbody class="text-center">

								<c:forEach var="p" items="${requestScope.alist}">
								<tr>
									<td>${p.year}</td>
									<td>${p.month}</td>
									<td>${p.days}</td>
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