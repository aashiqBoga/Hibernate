<html>
<head>
<link rel="stylesheet"
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<link href='http://fonts.googleapis.com/css?family=Varela+Round'
	rel='stylesheet' type='text/css'>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.13.1/jquery.validate.min.js"></script>
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1" />
<link rel="stylesheet" type="text/css" href="index.css">
<link rel="stylesheet" type="text/javascript" href="formJs.js">
</head>
<body>

	<div class="text-center" style="padding: 50px 0">
		<div align="center">
			<div class="logo">search</div>
			<!-- Main Form -->
			<div>${deleteMessage}</div>
			<div class="form-group error">${error}</div>
			<div class="login-form-1">
				<form id="login-form" class="text-left"
					action="/Hibernate/EmployeeSearch" method="post">
					<div class="login-form-main-message"></div>
					<div class="main-login-form">
						<div class="login-group">
							<div class="form-group">
								<label for="lg_username" class="sr-only">Employee ID</label> <input
									type="text" class="form-control" id="lg_username" name="id">
							</div>
							<div class="form-group">
								<label for="lg_password" class="sr-only">Employee
									First/Last Name</label> <input type="text" class="form-control"
									id="lg_password" name="name">
							</div>

						</div>
						<button type="submit" class="login-button">
							<i class="fa fa-chevron-right"></i>
						</button>
					</div>
					<div class="logo">or</div>

				</form>
				<form id="login-form" class="text-left"
					action="/Hibernate/EmployeeSearch">
					<div class="form-group">
						<button class="btn login-group ">
							Get All Employees <i class="fa fa-chevron-right"></i>
						</button>
					</div>
				</form>
			</div>
		</div>

	</div>

</body>
</html>