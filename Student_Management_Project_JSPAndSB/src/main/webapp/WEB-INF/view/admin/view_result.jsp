
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>admin: View Result</title>

<%@include file="all_css.jsp"%>
</head>
<body class="bg-card-color">

	<%@include file="navbar.jsp"%>

	<div class="container-fluid" style="margin: 0%; padding: 0px;">
		<div class="row">
			<div class="col-md-2">
				<%@include file="left-navbar.jsp"%>
			</div>

			<div class="col-md-10">
				<div class="container-fluid">
					<div class="col-md-8 offset-md-2">

					
						<br>
						<div class="card">
							<div class="card-body">
								
								<h4 class="text-center">Result</h4>
								<hr>
								<div class="mt-2">
									<h6>
										Name :
										${requestScope.rsobj.name}</h6>
									<h6>
										Roll No :
										${requestScope.rsobj.roll}</h6>
									<h6>
										Course :
										${requestScope.rsobj.course}</h6>
									<h6>
										Semestar :
										${requestScope.rsobj.semestar}</h6>
								</div>
								<hr>
								<div class="mt-2">
									<table class="table table-bordered text-center">
										<thead class="bg-light">
											<tr>
												<th>Subject</th>
												<th>Total Mark</th>
												<th>Mark</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="p" items="${requestScope.mlist}">
											<tr>
												<td>${p.subject}</td>
												<td>100</td>
												<td>${p.mark}</td>
											</tr>
											</c:forEach>
											<tr>
												<th>Total Mark</th>
												<th>${requestScope.tmark}</th><th>${requestScope.gmark} </th>
											</tr>

											<tr>
												<th>Percentage</th>
												<th colspan="2">
													${requestScope.per} %
												</th>
											</tr>
											<tr>
												<th>Division</th>
												<th colspan="2">
													${requestScope.res}
												</th>
											</tr>

										</tbody>
									</table>
								</div>


							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
</body>
</html><body>

</body>
</html>