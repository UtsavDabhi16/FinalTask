<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!--===============================================================================================-->
<link rel="icon" type="image/png" href="images/icons/favicon.ico" />
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/select2/select2.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="css/util.css">
<link rel="stylesheet" type="text/css" href="css/main.css">
<!--===============================================================================================-->
</head>
<body>
<!-- Include the Header file -->
	<%@ include file="header.jsp"%>
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">
				<form class="login100-form  p-l-55 p-r-55 p-t-178" action="ForgotPasswordController" method="get"
					name="forgotpassword">
					<span class="login100-form-title"> Forgot Password </span>

					<div class="wrap-input100 validate-input m-b-16"
						data-validate="Please enter username">
						<input class="input100" type="text" name="useremail"
							id="useremail" placeholder="Enter Your Email">
					</div>
					 <span id="emailerror" style="color: red"></span>


					<div class="wrap-input100 validate-input m-b-16">
						<input type="text" id="userphoneno" class="input100"
							name="userphoneno" aria-required="true" placeholder="1234567890">
					</div>


					<div class="wrap-input100 validate-input m-b-16"
						data-validate="Please enter secutiry answer">
						<input type="text" id="useranswer"
							class="input100" name="useranswer"
							placeholder="Enter Your Programming Language Answer">
						<span id="serror" style="color: red"></span>
					</div>

					<div class="wrap-input100 validate-input m-b-16"
						data-validate="Please enter password">
						<input class="input100" type="password" name="newpassword"
							id="newpassword" placeholder="Enter Your New Password"> <span
							id="passworderror" style="color: red"></span>
					</div>

					<div class="container-login100-form-btn m-b-32">
						<button class="login100-form-btn"  type="submit">Save
						</button>
					</div>

				</form>
			</div>
		</div>
	</div>


	<!--===============================================================================================-->
	<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="vendor/jquery/jquery.validate.min.js"></script>
	<!--===============================================================================================-->
	<script src="vendor/animsition/js/animsition.min.js"></script>
	<!--===============================================================================================-->
	<script src="vendor/bootstrap/js/popper.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
	<!--===============================================================================================-->
	<script src="vendor/select2/select2.min.js"></script>
	<!--==============================================================================================-->
	<script src="vendor/daterangepicker/moment.min.js"></script>
	<script src="vendor/daterangepicker/daterangepicker.js"></script>
	<!--===============================================================================================-->
	<script src="vendor/countdowntime/countdowntime.js"></script>

	<!--===============================================================================================-->
	<script src="js/forgotpassword.js"></script>
	<script>
// 		$(document).ready(function() {
// 			// 						$("#btn").click(function() {
// 			// 							$("#btn").hide();
// 			$("#btn").on('submit', function(event) {
// 				console.log("document loaded");
// 			});
// 		});

		// 				event.preventDefault();
		// 				var f = $(this).serialize();
		// 				console.log(f);
		// 				$.ajax({
		// 					url : 'LoginController',
		// 					data : f,
		// 					type : 'GET',
		// 					success : function(data) {
		// 						alert(data);
		// 						$('#msg').html("Added Successfully");
		// 					},
		// 					error : function() {
		// 						alert('error');
		// 					}
		// 				});

		// 			});
	</script>
	<!-- Include the Footer file -->
	<%@ include file="footer.jsp"%>
</body>
</html>