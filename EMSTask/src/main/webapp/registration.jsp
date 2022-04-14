<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Register Page</title>

<!-- Default CSS Link -->
<link rel="icon" type="image/png" href="images/icons/favicon.ico" />
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

<!-- Custom CSS Link -->
<link rel="stylesheet" type="text/css" href="css/util.css">
<link rel="stylesheet" type="text/css" href="css/main.css">
<link rel="stylesheet" type="text/css" href="css/custom.css">

</head>
<body>
	<!-- Include the Header file -->
	<%@ include file="header.jsp"%>

	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">
				<form class="login100-form  p-l-55 p-r-55 p-t-178" name="register"
					action="RegisterController" method="post">
					<span class="login100-form-title"> Sign UP User </span>

					<div class="wrap-input100 validate-input m-b-16"
						data-validate="Please enter First Name">
						<input class="input100" type="text" name="firstname"
							id="firstname" Placeholder="Enter your First Name"> <span
							id="fnameerror" style="color: red"></span>
					</div>

					<div class="wrap-input100 validate-input m-b-16"
						data-validate="Please enter Last Name">
						<input class="input100" type="text" name="lastname" id="lastname"
							Placeholder="Enter your Last Name"> <span id="lnameerror"
							style="color: red"></span>
					</div>


					<div class="wrap-input100 validate-input m-b-16"
						data-validate="Please enter username">
						<input class="input100" type="text" name="email" id="email"
							Placeholder="abc@gmail.com"> <span id="result"
							style="color: green"></span> <span id="emailerror"
							style="color: red"></span>

					</div>


					<div class="wrap-input100 validate-input m-b-16"
						data-validate="Please enter phoneno">
						<input class="input100" type="text" name="phoneno" id="phoneno"
							Placeholder="Phoneno"> <span id="emailerror"
							style="color: red"></span>
					</div>


					<div class="wrap-input100 validate-input m-b-16"
						data-validate="Please enter birthdate">
						<input class="input100" type="date" name="birthdaydate"
							id="birthdaydate">
					</div>

					<div class="wrap-input100 validate-input m-b-16">
						<label class="m-l-12" for="customer-gender">Gender : -</label> <label
							for="male" class="gender-size">Male</label> <input class="m-l-4"
							type="radio" id="male" name="gender" value="Male"> <br>
						<label class="gender-size m-l-85" for="female">Female</label> <input
							type="radio" id="female" name="gender" value="Female">
					</div>


					<div class="wrap-input100 validate-input m-b-16"
						data-validate="Please enter phoneno">
						<input type="text" id="sanswer" class="input100" name="sanswer"
							Placeholder="Enter your Security Answer"> <span
							id="serror" style="color: red"></span>
					</div>


					<div class="wrap-input100 validate-input m-b-16"
						data-validate="Please enter password">
						<input class="input100" type="password" name="password"
							id="password" Placeholder="******"> <span id="perror"
							style="color: red"></span>
					</div>

					<div class="wrap-input100 validate-input m-b-16"
						data-validate="Please enter password">
						<input class="input100" type="password" name="cpassword"
							id="cpassword" Placeholder="******"> <span id="cperror"
							style="color: red"></span>
					</div>

					<div id="example-3" class="content">

						<div class="row">
							<div class="col-md-12">
								<button type="button" id="btnAdd-3" class="btn btn-primary">Add
									Address</button>
							</div>
						</div>

						<div class="row group">

							<div class="col-md-12 m-b-12 m-t-12">
								<input class="input100 AddLineOne" type="text"
									name="AddressLineOne" Placeholder="AddressLine One"> <span
									class="AddressLineOneError"></span>
							</div>
							<div class="col-md-12 m-b-12">
								<input class="input100 AddLineTwo" type="text"
									name="AddressLineTwo" Placeholder="AddressLine Two"> <span
									class="AddressLineTwoError"></span>
							</div>

							<div class="col-md-12 m-b-12">
								<input type="text" name="pincode" class="input100 pin"
									maxlength="6" Placeholder="Pincode"> <span
									class="PinError"></span>
							</div>
							<div class="col-md-12 m-b-12">
								<input type="text" class="input100 city" name="city"
									maxlength="64" Placeholder="City"> <span
									class="CityError"></span>
							</div>
							<div class="col-md-12 m-b-12">
								<input type="text" class="input100 state" name="state"
									maxlength="64" Placeholder="State"><span
									class="StateError"></span>
							</div>
							<div class="col-md-3">
								<button type="button" class="btn btn-danger btnRemove">Remove</button>
							</div>

						</div>
					</div>


					<div class="container-login100-form-btn m-b-32 m-t-16">
						<button class="login100-form-btn" type="submit">Submit</button>
					</div>
				</form>
			</div>
		</div>
	</div>

	<!-- 	Default JavaScript Link -->
	<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="vendor/jquery/jquery.validate.min.js"></script>
	<script src="vendor/animsition/js/animsition.min.js"></script>
	<script src="vendor/bootstrap/js/popper.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
	<script src="vendor/select2/select2.min.js"></script>
	<script src="vendor/daterangepicker/moment.min.js"></script>
	<script src="vendor/daterangepicker/daterangepicker.js"></script>
	<script src="vendor/countdowntime/countdowntime.js"></script>
	
	<!-- Custom JavaScript Link -->
	<script src="js/registervalidation.js"></script>
	<script src="js/Gruntfile.js"></script>
	<script src="js/jquery.multifield.js"></script>
	<script src="js/jquery.multifield.min.js"></script>
	<script>
		$('#example-3').multifield({
			section : '.group',
			btnAdd : '#btnAdd-3',
			btnRemove : '.btnRemove',
			max : 1000
		});
	</script>
	<script>
		// 		$(document).ready(function() {
		// 			$("form").submit(function(event) {
		// 				var formData = {
		// 					firstname : $("#firstname").val(),
		// 					lastname : $("#lastname").val(),
		// 					email : $("#email").val(),
		// 					phone : $("#phoneno").val(),
		// 					date : $("#birthdaydate").val(),
		// 					radioValue : $("input[name='gender']:checked").val(),
		// 					securityAnswer : $("#sanswer").val(),
		// 					password : $("#password").val(),
		// 					cpassword : $("#cpassword").val(),

		// 				};

		// 				$.ajax({
		// 					type : "POST",
		// 					url : "RegisterController",
		// 					data : formData,
		// 				});

		// 				event.preventDefault();
		// 			});
		// 		});
	</script>
	<!-- Include the Footer file -->
	<%@ include file="footer.jsp"%>
</body>
</html>