<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
	crossorigin="anonymous">
</head>
<body>
	<%if(session.getAttribute("loginError") != null){ %>
		<div class="alert alert-danger" role="alert">
  Account Not Found!!
</div>
	<%} %>

	<div
		class="container vh-100 d-flex justify-content-center align-items-center">
		<div class="row w-100">
			<div class="col-12 text-center">
				<div class="card" style="width: 80%; margin: 0 auto;">
					<div class="card-body">
						<form action="login" method="post">
							<div class="mb-3">
								<label for="loginId" class="form-label">LoginId</label> <input
									type="text" class="form-control" id="loginId"
									aria-describedby="emailHelp" name="loginId">
							</div>
							<div class="mb-3">
								<label for="password" class="form-label">Password</label> <input
									type="password" class="form-control" id="password" name="password">
							</div>
							<button type="submit" class="btn btn-primary">Submit</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>









	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
		crossorigin="anonymous"></script>
</body>
</html>