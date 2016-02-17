<html>
<head>
<link rel="stylesheet"
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<link href='http://fonts.googleapis.com/css?family=Varela+Round'
	rel='stylesheet' type='text/css'>
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1" />
<link rel="stylesheet" type="text/css" href="index.css">
</head>
<body>
<div class="text-center" style="padding: 50px 0">

	<center>
		<div class="logo">login</div>
		<!-- Main Form -->
		<div class="form-group error">${error}</div>
		<div class="login-form-1">
			<form id="login-form" class="text-left" method="post"
				action="/Hibernate/LoginValidate">
				<div class="login-form-main-message"></div>
				<div class="main-login-form">
					<div class="login-group">
						<div class="form-group">
							<label for="lg_username" class="sr-only"> Username </label> <input
								type="text" class="form-control" id="lg_username"
								name="username">
						</div>
						<div class="form-group">
							<label for="lg_password" class="sr-only"> Password </label> <input
								type="password" class="form-control" id="lg_password"
								name="password">
						</div>

						<div class="form-group login-group-checkbox">
							<input type="checkbox" id="lg_remember" name="lg_remember">
							<label for="lg_remember"> remember </label>
						</div>
					</div>
					<button type="submit" class="login-button">
						<i class="fa fa-chevron-right"></i>
					</button>
				</div>
				<div class="etc-login-form">
					<p>
						new user? <a href="#">create new account</a>
					</p>
				</div>
			</form>
		</div>
	</center>

	<!-- end:Main Form -->
</div>
</body>
</html>