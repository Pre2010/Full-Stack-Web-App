<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
<link rel="stylesheet" href="css/header_footer.css">
<script src="https://code.jquery.com/jquery-2.1.4.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body class="headerBody">
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-nav-demo"
					aria-expanded="false">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a href="MainMenuControllerServlet" class="navbar-brand"><span
					class="glyphicon glyphicon-knight"></span> FS-WA</a>
			</div>
			<div class="collapse navbar-collapse" id="bs-nav-demo">
				<ul class="nav navbar-nav">
					<li><a href="MainMenuControllerServlet">Home</a></li>
					<li><a href="AboutPage.jsp">About</a></li>
					<li><a href="ContactPage.jsp">Contact</a></li>
					<li><a href="GalleryPage.jsp">View Gallery</a></li>
					<li><a href="StorePage.jsp">Store</a></li>
					<li><a href="CustomerControllerServlet">View Customers</a></li>
					<li><a href="UserControllerServlet">View Users</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="RegisterPage.jsp">Sign Up</a></li>
					<li><a href="Login.jsp">Login</a></li>
				</ul>
			</div>
		</div>
	</nav>

</body>
</html>