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
                        <c:forEach var="p" items="${requestScope.allNotice}">
                            <div class="card mt-2">
                                <div class="card-body">
                                    <div class="text-center text-danger">
                                        <i class="far fa-clipboard fa-2x"></i>
                                    </div>
                                    <h6>
                                        Publish By:
                                        ${p.name}
                                    </h6>
                                    <h6>
                                        Date :
                                        ${p.date}
                                    </h6>
                                    <p>
                                        ${p.message}
                                    </p>
                                    <br>
                                </div>
                                <div>
                                    <div>
                                        <a class="btn btn-danger m-2" href="/admin/deletenotice/${p.id}"
                                            role="button">Delete</a>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>


                    </div>
                </div>
            </div>
        </div>
</body>

</html>