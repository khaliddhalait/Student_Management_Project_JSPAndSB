<style>

.sidebar {
	width: 18%;
	background-color: #01579b;
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

<div class="sidebar">
	
	<!-- <span class="crossBtn text-white" onclick="toogleSidebar()">&times;</span> --> 
		
		<div class="container text-center text-white">
		<i class="fas fa-user-circle fa-5x"></i>
		<h6>Admin</h6>
		</div>
			<div class="divider"></div>
		<a href="/admin/home" class="item"><i class="fas fa-home"></i> Home</a> 
		
		<a href="/admin/add_info" class="item"><i class="fas fa-id-card-alt"></i> Add</a> 
		
		<a href="/admin/teacher" class="item"><i class="fas fa-id-card-alt"></i> Teacher</a> 
			
		<a href="/admin/student" class=""><i class="fas fa-pencil-alt"></i> Student</a> 
			
		<a href="/admin/attendance" class="item"><i class="fas fa-user-circle"></i> Attendence</a> 
			
		<a href="/admin/result" class="item"><i class="fas fa-poll-h"></i> Result</a> 
			
		<a href="/admin/notice" class="item"><i class="fas fa-poll-h"></i> Notice</a> 
		
		<div class="divider"></div>
	</div>