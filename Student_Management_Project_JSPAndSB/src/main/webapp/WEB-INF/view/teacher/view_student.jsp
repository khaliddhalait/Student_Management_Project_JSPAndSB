<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student List</title>
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
					<c:set var="cou" value="${requestScope.course}"/>
					<c:set var="sem" value="${requestScope.semestar}"/>
					<c:set var="type" value="${requestScope.type}"/>
					<div>
						<c:if test="${smsg!=null}">
							<p class='text-center alert alert-success'><c:out value="${requestScope.smsg}"></c:out></p>
						</c:if>
						<c:if test="${fmsg!=null}">
							<p class='text-center alert alert-danger'><c:out value="${requestScope.fmsg}"></c:out></p>
						</c:if>
					</div>
					<h3 class="text-center">Course :&nbsp;${requestScope.course}&ensp;&ensp;&ensp;&ensp;Semester :&nbsp;${requestScope.semestar}
					</h3><hr><h3 class="text-center">
						 
							<c:if test="${type.equals('attend')}">  
								<c:out value="Attendance"></c:out>
							</c:if>  
							<c:if test="${type.equals('view')}">  
								<c:out value="Student details"></c:out>
							</c:if>  
							<c:if test="${type.equals('res')}">  
								<c:out value="Result"></c:out>
							</c:if>  
					</h3>
				</div>

				<div class="card">
					<div class="card-body">
					
					
						<table class="table table-bordered mt-2 bg-light">
							<thead class="bg-primary text-white">
								<tr>
									<th scope="col">Roll</th>
									<th scope="col">Name</th>
									<th scope="col">Course</th>
									<th scope="col">Semestar</th>
									<th scope="col">Gender</th>
									<th scope="col">Email</th>
									<th scope="col">Action</th>
								</tr>
							</thead>
							<tbody>

								<c:forEach var="p" items="${requestScope.list}">
									<tr>	<td>${p.roll}</td>
									<td>${p.name}</td>
									<td>${p.course}</td>
									<td>${p.semestar}</td>
									<td>${p.gender}</td>
									<td>${p.email}</td>
									<c:if test="${type.equals('attend')}">
										<td class="text-center"><a
											href="view_attend/${p.id}/${p.semestar}"
											class="btn btn-sm btn-warning text-white"><i
												class="far fa-eye"></i> View</a>
												<a
												href="take_atten/${p.id}"
												class="btn btn-sm btn-success text-white"><i
													class="fas fa-address-book"></i> Attend</a>
										</td>
									</c:if>
									
									<c:if test="${type.equals('res')}">
									<td><a href="add_mark/${p.id}"
										class="btn btn-sm btn-success"><i
											class="fas fa-plus-square"></i> Add Mark</a> <a
										href="view_result/${p.id}/${p.semestar}"
										class="btn btn-sm btn-success"><i class="fas fa-eye"></i>
											View</a></td>
										</c:if>
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