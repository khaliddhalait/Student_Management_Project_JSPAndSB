
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit teacher</title>
<%@include file="all_css.jsp"%>
</head>
<body class="bg-card-color">
<div> <%@include file="navbar.jsp" %></div>
	<div class="container-fluid" style="margin: 0%; padding: 0px;">
		<div class="row">
			<div class="col-md-2">
				<%@include file="left-navbar.jsp"%>
			</div>
			<div class="col-md-10  p-5">

				<div class="card">
					<div class="card-body">
						<form id="atform" onsubmit="return validateTeacher()" modelAttribute="uteacher" action="/admin/updateteacher" method="post">
							<input type="hidden" value="${requestScope.atobj.id}" name="id">
							<div class="form-row">

								<div class="form-group col-md-4">
									<label for="">Enter Name</label> <input type="text" required
										name="name" value="${requestScope.atobj.name}" id=""
										class="form-control">
								</div>

								<div class="form-group col-md-4">
									<label for="">Gender</label> <select name="gender" required
										class="custom-select my-1 mr-sm-2"
										id="inlineFormCustomSelectPref">
										<option value="Male">Male</option>
										<option value="Female">Female</option>
									</select>
								</div>
								<div class="form-group col-md-4">
									<label for="">Enter DOB</label> <input type="date" name="dob"
										id="" value="${requestScope.atobj.dob}" class="form-control" required>
								</div>
							</div>

							<div class="form-row">
								<div class="form-group col-md-4">
									<label for="">Enter Qualification</label> <input type="text"
										name="qualification" value="${requestScope.atobj.qualification}" id=""
										class="form-control" required>
								</div>

								<div class="form-group col-md-4">
									<label for="">Enter Email</label> <input type="text"
										name="email" value="${requestScope.atobj.email}" id=""
										class="form-control" readonly>
								</div>

								<div class="form-group col-md-4">
								 <input type="hidden"
										name="password" value="" id=""
										class="form-control" required>

								</div>

							</div>
							<button class="btn btn-primary">Submit</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<script type="text/javascript">
	function validateTeacher() {
		var name = document.forms["atform"]["name"].value;
	    if (name.length < 3) {
	        alert("Name lenght must be greater than 3");
	        return false;
	    }
	    if (!isNaN(name)) {
			alert("numbers are not allowed for name");
			return false;
		}
		var gender = document.forms["atform"]["gender"].value;
	    if (gender == "Choose...") {
	        alert("Please select valid gender");
	        return false;
	    }
	    var qua = document.forms["atform"]["qualification"].value;
	    if (qua.length == 1) {
	        alert("Qualification lenght must be greater than 1");
	        return false;
	    }
	    if (!isNaN(qua)) {
			alert("numbers are not allowed for qualification");
			return false;
		}
		var email = document.forms["atform"]["email"].value;
		if (!isNaN(email)) {
			alert("numbers are not allowed for email");
			return false;
		}
		
	    var password = document.forms["atform"]["password"].value;
	    var cpassword = document.forms["atform"]["cpassword"].value;
	    if (password !== cpassword) {
	        alert("confirm password missmatch");
	        return false;
	    }

	    if (password.length < 8) {
	        alert("password lenght should not be less than 8");
	        return false;
	    }
		
		return true;
	}
	</script>
</body>
</html>