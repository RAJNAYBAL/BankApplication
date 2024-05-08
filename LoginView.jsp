<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>Login Page</title>
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

<!--Bootsrap 4 CDN-->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">

<!--Fontawesome CDN-->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
	integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU"
	crossorigin="anonymous">

<!--Custom styles-->
<link rel="stylesheet" type="text/css" href="LoginView.css">
</head>
<body>

<div class="navbar">
	<table>
		<a href="BankHome.jsp">Home</a><br>
		
	
	<br>

	</table>
		</div>

<form action="LoginController">
	<div class="container">
		<div class="d-flex justify-content-center h-100">
			<div class="card">
				<div class="card-header">
					<h3>Sign In</h3>
					<div class="d-flex justify-content-end social_icon">
						<!-- <span><i class="fab fa-facebook-square"></i></span> -->
						<span><a href="https://www.instagram.com/_rajnaybal_"
							class="fab fa-facebook-square"></a></span>
						<!-- <span><i class="fab fa-google-plus-square"></i></span> -->
						<span><a href="https://www.instagram.com/_rajnaybal_"
							class="fab fa-google-plus-square"></a></span> <span><a
							href="https://www.instagram.com/_rajnaybal_"
							class="fab fa-twitter-square"></a></span>

						<!-- <span><i class="fab fa-twitter-square"></i></span> -->
					</div>
				</div>
				<div class="card-body">
					<form>
						<div class="input-group form-group">
							<div class="input-group-prepend">
								<span class="input-group-text"><i class="fas fa-user"></i></span>
							</div>
							<input type="text" class="form-control" placeholder="username" name="unm">

						</div>
						<div class="input-group form-group">
							<div class="input-group-prepend">
								<span class="input-group-text"><i class="fas fa-key"></i></span>
							</div>
							<input type="password" class="form-control"
								placeholder="password" name="password">
						</div>
						<div class="row align-items-center remember">
							<input type="checkbox">Remember Me
						</div>
						 <div class="form-group">
							<input type="submit" value="Login"
								class="btn float-right login_btn">  
				<!-- <a href="LoginController"><button class="btn float-right login_btn">LOGIN</button></a>	 -->					</div>
					</form>
				</div>
				<div class="card-footer">
					<div class="d-flex justify-content-center links">
						Don't have an account?<a href="RegisterView.jsp">Sign Up</a>
					</div>
					<div class="d-flex justify-content-center">
						<a href="forgetpassword.jsp">Forgot your password?</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	</form>
</body>
</html>