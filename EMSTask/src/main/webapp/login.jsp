<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page errorPage="ErrorPage.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<!-- Favicon Icon -->
<link rel="icon" type="image/png" href="images/icons/favicon.ico" />
<!-- BootStrap and Custom Link -->
<link rel="stylesheet" type="text/css"
	href="vendor/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
<link rel="stylesheet" type="text/css"
	href="vendor/css-hamburgers/hamburgers.min.css">
<link rel="stylesheet" type="text/css"
	href="vendor/animsition/css/animsition.min.css">
<link rel="stylesheet" type="text/css"
	href="vendor/select2/select2.min.css">
<link rel="stylesheet" type="text/css"
	href="vendor/daterangepicker/daterangepicker.css">
<link rel="stylesheet" type="text/css" href="css/util.css">
<link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body>
	<!-- Include the Header file -->
	<%@ include file="header.jsp"%>
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">
				<form class="login100-form  p-l-55 p-r-55 p-t-178" name="userlogin"
					method="get" action="LoginController">
					<span class="login100-form-title"> Sign In </span>


					<div class="wrap-input100 validate-input m-b-16"
						data-validate="Please enter username">
						<input class="input100" type="text" name="uemail" id="uemail"
							placeholder="Enter Your Email"> <span id="emailerror"
							style="color: red"></span>
					</div>

					<div class="wrap-input100 validate-input"
						data-validate="Please enter password">
						<input class="input100" type="password" name="upassword"
							id="upassword" placeholder="Password"> <span
							id="passworderror" style="color: red"></span>
					</div>


					
					<div class="text-right p-t-13 p-b-23">
						<span class="txt1"> Forgot </span> <a href="forgotpassword.jsp"
							class="txt2"> Password? </a>
					<span class="txt1"> Reset </span> <a href="resetPassword.jsp"
						class="txt2"> Password? </a>
					</div>



					<div class="container-login100-form-btn">
						<button class="login100-form-btn" type="submit">Sign in</button>
					</div>

					<div class="flex-col-c p-t-70 p-b-30">
						<span class="txt1 p-b-9"> Don't have an account? </span> <a
							href="registration.jsp" class="txt3"> Sign up now </a>
					</div>
				</form>

			</div>
		</div>
	</div>

	<!-- JavaScript File -->
	<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.3/jquery.validate.min.js"></script>
	<script src="vendor/jquery/formToJson.js"></script>
	<script src="vendor/animsition/js/animsition.min.js"></script>
	<script src="vendor/bootstrap/js/popper.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
	<script src="vendor/select2/select2.min.js"></script>
	<script src="vendor/daterangepicker/moment.min.js"></script>
	<script src="vendor/daterangepicker/daterangepicker.js"></script>
	<script src="vendor/countdowntime/countdowntime.js"></script>
	<script src="js/login.js"></script>
	<script>
		// 		$(document).ready(function() {
		// 			$("form").submit(function(event) {
		// 				event.preventDefault();
		// 				var formData = {
		// 					email : $("#uemail").val(),
		// 					password : $("#upassword").val(),
		// 				};

		// 				$.ajax({
		// 					type : "GET",
		// 					async: false,
		// 					url : "LoginController",
		// 					data : formData,
		// 					success: function(data) {
		// 						alert("Data was succesfully captured");
		// 		            },
		// 				});

		// 				$("#msg").text(successmessage);
		// 				.done(function(data) {
		// 					console.log($(this).formToJson());
		// 					return false;
		// 					console.log(data);
		// 				});

		// 			});
		// 		});
	</script>
	<!-- Include the Footer file -->
	<%@ include file="footer.jsp"%>
</body>
</html>