<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
<style type="text/css">

.navbar{
background-color:silver;
display:flex;
justify-content:left;
align-items:center;
height:80px;

}

.navbar a{
display: block;
padding: 15px 30px;
margin-right:  100px;
background-color: #fff;
color:#333;
border-radius:8px;
box-shadow: 0 4px 8px rgba(0,0,0,0.1);
transition:transform 0.2s,box-shadow 0.2s;
font-weight: bold;
font-size: 18px;
align-items: right;

}



</style>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="RegisterView.css">
</head>
<body>
<div class="navbar">
	<table>
		<a href="BankHome.jsp">Home</a><br>
		
	
	<br>

	</table>
		</div>

	<form action="RegistrationController">

		<section class="vh-100 bg-image"
			style="background-image: url('https://mdbcdn.b-cdn.net/img/Photos/new-templates/search-box/img4.webp');">
			<div class="mask d-flex align-items-center h-100 gradient-custom-3">
				<div class="container h-100">
					<div
						class="row d-flex justify-content-center align-items-center h-100">
						<div class="col-12 col-md-9 col-lg-7 col-xl-6">
							<div class="card" style="border-radius: 15px;">
								<div class="card-body p-5">
									<h2 class="text-uppercase text-center mb-5">Create an
										account</h2>

									<form>

										<div data-mdb-input-init class="form-outline mb-4">
										<label
												class="form-label" for="form3Example1cg">Account
												Number</label>
											<input type="number" id="form3Example1cg"
												class="form-control form-control-lg" name="acc_no" /> 
										</div>

										<div data-mdb-input-init class="form-outline mb-4">
										<label
												class="form-label" for="form3Example3cg">Customer
												Name</label>
											<input type="text" id="form3Example3cg"
												class="form-control form-control-lg" name="cust_nm" /> 
										</div>
										<div data-mdb-input-init class="form-outline mb-4">
											<input type="number" id="form3Example1cg"
												class="form-control form-control-lg" name="pan_no" /> <label
												class="form-label" for="form3Example1cg">Pan Number</label>
										</div>

										<div data-mdb-input-init class="form-outline mb-4">
											<input type="number" id="form3Example1cg"
												class="form-control form-control-lg" name="adh_no" /> <label
												class="form-label" for="form3Example1cg">Adhar
												Number</label>
										</div>

										<div data-mdb-input-init class="form-outline mb-4">
											<input type="text" id="form3Example1cg"
												class="form-control form-control-lg" name="branch" /> <label
												class="form-label" for="form3Example1cg">Branch Name
											</label>
										</div>


										<div data-mdb-input-init class="form-outline mb-4">
											<input type="email" id="form3Example3cg"
												class="form-control form-control-lg" name="mail" /> <label
												class="form-label" for="form3Example3cg">Your Email</label>
										</div>

										<div data-mdb-input-init class="form-outline mb-4">
											<input type="text" id="form3Example1cg"
												class="form-control form-control-lg" name="user_name" /> <label
												class="form-label" for="form3Example1cg">User Name</label>
										</div>
										<div data-mdb-input-init class="form-outline mb-4">
											<input type="password" id="form3Example4cg"
												class="form-control form-control-lg" name="password" /> <label
												class="form-label" for="form3Example4cg">Password</label>
										</div>


										<div class="d-flex justify-content-center">
											<button type="submit" data-mdb-button-init
												data-mdb-ripple-init
												class="btn btn-success btn-block btn-lg gradient-custom-4 text-body">Register</button>
										</div>

										<p class="text-center text-muted mt-5 mb-0">
											Have already an account? <a href="LoginView.jsp"
												class="fw-bold text-body"><u>Login here</u></a>
										</p>

									</form>

								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
	</form>
</body>
</html>