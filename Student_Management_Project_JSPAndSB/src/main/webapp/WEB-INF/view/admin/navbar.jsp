<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@page isELIgnored="false" %>
<style>

</style>
		<nav class="navbar navbar-expand-lg navbar-dark bg-color sticky-top" style="background-color: #01579b">
			<a class="navbar-brand" href="#">Student Management System</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav mr-auto">
				</ul>
				<form class="form-inline my-2 my-lg-0">
					<div class="btn-group">
						<button type="button" class="btn btn-light text-dark" aria-haspopup="true"
							aria-expanded="false">
							<i class="fas fa-user-circle"></i> ${adname}
						</button>

					</div>
					<a href="/admin/logout" class="btn btn-light my-2 my-sm-0 ml-2" type="submit"><i
							class="fas fa-sign-out-alt"></i>Logout </a>

				</form>
			</div>
		</nav>
		<c:if test="${empty aobj }">
		<c:redirect url="/admin/login" />
	</c:if>
	