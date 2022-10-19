
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.carousel-item:after {
content: "";
display: block;
position: absolute;
top: 0;
bottom: 0;
left: 0;
right: 0;
background: rgba(0, 0, 0, 0.4);
}

.carousel-caption {
color: #fff;
top: 10%;
}
</style>
<%@include file="all_component/allCss_file.jsp"%>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body style="background-color: #f0f1f2;">
<%@include file="all_component/navbar.jsp"%>

<div >
	<div >
		<div >
			<div class="carousel-caption">
				<h1 class=" text-white">
					Welcome to <br>Student Management System
				</h1>
			</div>
			<img class="d-block w-100" src="./resources/img/c3.png" alt="First slide"
				style="width: 100%; height: 600px;">
		</div>
	</div>
</div>




<%@include file="all_component/footer.jsp"%>
</body>
</html>