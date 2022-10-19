<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

	<style>

.sidebar {
	width: 18%;
	background-color: rgb(0, 128, 64) !important;
	height: 100%;
	position: fixed;
	padding-top: 45px;
	z-index: 999999999999999999;
	
	
}

.sidebar a {
	display: block;
	width: 100%;
	padding: 10px 25px;
	text-decoration: none;
	color:white;
}

.sidebar a:hover {
	background-color: #e2e2e2;
	color: black;
}


.sidebar .divider {
	height: .5px;
	width: 100%;
	background: #e2e2e2;
	margin-top: 10px;
}
	</style>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="sidebar">
		
		<div class="container text-center text-white">
		<i class="fas fa-user-circle fa-5x"></i>
		<h6>Teacher</h6>
		</div>
		<div class="divider"></div>
		<a href="/teacher/home" class="item"><i class="fas fa-home"></i> Home</a>
		
		<a href="/teacher/view_profile" class="item"><i class="fas fa-home"></i> Profile</a>
			
		<a href="/teacher/student" class=""><i class="fas fa-user"></i> Student</a> 
			
		<a href="/teacher/attendance" class="item"><i class="fas fa-user-circle"></i> Attendence</a> 
			
		<a href="/teacher/result" class="item"><i class="fas fa-poll-h"></i> Result</a> 

		<a href="/teacher/viewnotice" class="item"><i class="fas fa-poll-h"></i> Notice</a> 

		<div class="divider"></div>
	</div>
</body>
</html>