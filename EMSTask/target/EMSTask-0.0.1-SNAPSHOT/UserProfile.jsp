<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- <%@ page session="true"%> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<!-- TAB icon/Favicon -->
<link rel="icon" type="image/png" href="images/icons/favicon.ico" />

<!-- BootStrap Link -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<!-- 	Google Font Link -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.9.0/css/all.min.css"
	rel="stylesheet">
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
<!--===============================================================================================-->

</head>
<body>
	<!-- Navigation Bar  -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<a class="navbar-brand" href="#"><c:out
				value="${User.getFirstName()}" /></a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<input type="hidden" value="${User.getUserid()}">
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link"
					href="UpdateUserProfile">Edit Profile<span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item active"><a class="nav-link"
					href="UserLogout">Logout</a></li>
			</ul>
		</div>
	</nav>
	<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1 must-revalidate
	response.setHeader("Pragma", "no-cache"); // HTTP 1.0
	response.setHeader("Expires", "0"); // Proxy
	%>
	<c:choose>
		<c:when test="${not empty sessionScope.User}">
			<div class="limiter">
				<div class="container-login100">
					<div class="wrap-login100">
						<form class="login100-form  p-l-55 p-r-55 p-t-178">
							<span class="login100-form-title"> Welcome <c:out
									value="${User.getFirstName()}" />
							</span>

							<div class="wrap-input100 validate-input m-b-16"
								data-validate="Please enter First Name">
								<input class="input100" type="text" name="firstname"
									id="firstname" value="${User.getFirstName()}" readonly>
								<span id="fnameerror" style="color: red"></span>
							</div>

							<div class="wrap-input100 validate-input m-b-16"
								data-validate="Please enter Last Name">
								<input class="input100" type="text" name="lastname"
									id="lastname" value="${User.getLastName()}" readonly> <span
									id="lnameerror" style="color: red"></span>
							</div>


							<div class="wrap-input100 validate-input m-b-16"
								data-validate="Please enter username">
								<input class="input100" type="text" name="email" id="email"
									value="${User.getEmail()}" readonly> <span
									id="emailerror" style="color: red"></span>
							</div>


							<div class="wrap-input100 validate-input m-b-16"
								data-validate="Please enter phoneno">
								<input class="input100" type="text" name="phoneno" id="phoneno"
									value="${User.getPhoneNo()}" readonly> <span
									id="phoneerror" style="color: red"></span>
							</div>


							<div class="wrap-input100 validate-input m-b-16"
								data-validate="Please enter birthdate">
								<input class="input100" type="date" name="birthdaydate"
									value="${User.getDob()}" id="birthdaydate" readonly>
							</div>

							<div class="wrap-input100 validate-input m-b-16">
								<label class="m-l-12" for="customer-gender">Gender : -</label>
								<c:out value="${User.getGender()}" />
								<!-- 						<label 	for="male" class="gender-size">Male</label> <input class="m-l-4" -->
								<!-- 													type="radio" id="male" name="gender" value="Male"> <br> -->
								<!-- 												<label class="gender-size m-l-85" for="female">Female</label> <input -->
								<!-- 													type="radio" id="female" name="gender" value="Female"> -->
							</div>



							<div class="wrap-input100 validate-input m-b-16"
								data-validate="Please enter phoneno">
								<input type="text" id="sanswer" class="input100" name="sanswer"
									value="${User.getSecurityAnswer() }" readonly> <span
									id="serror" style="color: red"></span>
							</div>


							<div class="wrap-input100 validate-input m-b-16"
								data-validate="Please enter password">
								<input class="input100" type="password" name="password"
									id="password" value="${User.getPassword() }" readonly>
								<span id="perror" style="color: red"></span>
							</div>

							<div class="wrap-input100 validate-input m-b-16"
								data-validate="Please enter password">
								<input class="input100" type="password" name="cpassword"
									id="cpassword" value="${User.getCPassword() }" readonly>
								<span id="cperror" style="color: red"></span>
							</div>



							<%-- 					<c:forEach var="list" items="${UserAddress}"> --%>
							<!-- 						<div id="example-3" class="content"> -->

							<!-- 							<div class="row group"> -->
							<!-- 								<div class="col-md-12 m-b-12 m-t-12"> -->
							<!-- 									<input class="input100" type="text" id="AddressLineOne" -->
							<%-- 										name="AddressLineOne" value="${list.getAddressLineOne()}" readonly /> --%>
							<!-- 								</div> -->
							<!-- 								<div class="col-md-12 m-b-12"> -->
							<!-- 									<input class="input100" type="text" id="AddressLineTwo" -->
							<%-- 										name="AddressLineTwo" value="${list.getAddressLineTwo()}" readonly> --%>
							<!-- 								</div> -->

							<!-- 								<div class="col-md-12 m-b-12"> -->
							<!-- 									<input type="text" id="pincode" name="pincode" class="input100" -->
							<%-- 										maxlength="6" value="${list.getPincode()}" readonly> --%>
							<!-- 								</div> -->
							<!-- 								<div class="col-md-12 m-b-12"> -->
							<!-- 									<input type="text" id="city" class="input100" name="city" -->
							<%-- 										maxlength="64" value="${list.getCity()}" readonly> --%>
							<!-- 								</div> -->
							<!-- 								<div class="col-md-12 m-b-12"> -->
							<!-- 									<input type="text" id="state" class="input100" name="state" -->
							<%-- 										maxlength="64" value="${list.getState()}" readonly> --%>
							<!-- 								</div> -->
							<!-- 							</div> -->
							<!-- 						</div> -->
							<%-- 					</c:forEach> --%>
						</form>
					</div>
				</div>
			</div>
		</c:when>
		<c:otherwise>
			<c:redirect url="login.jsp" />
		</c:otherwise>
	</c:choose>
	<%-- 	<c:remove var="User" scope="session" /> --%>
	<%-- 	<c:remove var="UserAddress" scope="session" /> --%>

	<!-- jQuery File -->

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
	<script src="vendor/jquery/jquery.validate.min.js"></script>
	<script src="vendor/animsition/js/animsition.min.js"></script>
	<script src="vendor/bootstrap/js/popper.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
	<script src="vendor/select2/select2.min.js"></script>
	<script src="vendor/daterangepicker/moment.min.js"></script>
	<script src="vendor/daterangepicker/daterangepicker.js"></script>
	<script src="vendor/countdowntime/countdowntime.js"></script>
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