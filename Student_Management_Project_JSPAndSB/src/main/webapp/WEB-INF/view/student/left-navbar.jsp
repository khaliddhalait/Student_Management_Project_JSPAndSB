<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
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

.content {
	margin-left: 20%;
}
</style>
<div class="sidebar">
	
		
		
		<div class="container text-center text-white">
		<i class="fas fa-user-circle fa-5x"></i>
		<h6>Student</h6>
		<div class="divider"></div>
		</div>
			
		<a href="/student/home" class="item"><i class="fas fa-home"></i> Home</a>
			
		<a href="/student/view_profile" class=""><i class="fas fa-user"></i> Profile</a> 
		
		<a href="/student/edit_profile" class=""><i class="fas fa-pencil-alt"></i> Edit Profile</a> 
			
		<a href="/student/view_attend/${sessionScope.sobj.id}/${sessionScope.sobj.semestar}" class="item"><i class="fas fa-user-circle"></i> Attendence</a>
			
		<a href="/student/result/${sessionScope.sobj.id}/${sessionScope.sobj.semestar}" class="item"><i class="fas fa-poll-h"></i> Result</a> 

		<a href="/student/viewnotice" class="item"><i class="fas fa-poll-h"></i> Notice</a> 

		<div class="divider"></div>
	</div>