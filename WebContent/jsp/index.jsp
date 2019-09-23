<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.time.LocalDateTime"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="css/styles.css" rel="stylesheet">
<script src="js/index.js"></script>
<title>Web Playground</title>
</head>
<body>
	<header>
		<h1>Welcome to the Web Playground/Sandbox</h1>
	</header>
	<nav>
		<div class="navbar">
			<a class="active" href="index.jsp">Home</a> <a
				href="jsp/AboutPage.jsp">About Us</a> <a href="jsp/GalleryPage.jsp">Gallery</a>
			<a href="jsp/StorePage.jsp">Store</a> <a href="jsp/ContactPage.jsp">Contact
				Us</a>
		</div>
	</nav>

	<h2>
		Current time is
		<%=LocalDateTime.now()%></h2>
	<img src="images/sakura_lane.jpg">
	<p>Lorem Ipsum is simply dummy text of the printing and typesetting
		industry. Lorem Ipsum has been the industry's standard dummy text ever
		since the 1500s, when an unknown printer took a galley of type and
		scrambled it to make a type specimen book. It has survived not only
		five centuries, but also the leap into electronic typesetting,
		remaining essentially unchanged. It was popularised in the 1960s with
		the release of Letraset sheets containing Lorem Ipsum passages, and
		more recently with desktop publishing software like Aldus PageMaker
		including versions of Lorem Ipsum.</p>
	<table border="1" style="width: 300, cellpadding:5">
		<tr>
			<td><img src="images/index.jfif" /></td>
			<td>Test JSP</td>
			<td><img src="images/giphy4.gif" /></td>
			<td><a href="jsp/AboutPage.jsp">Click</a></td>
			<td>Slideshow</td>
		</tr>
	</table>

	<script type="text/javascript">
		
	</script>
</html>

