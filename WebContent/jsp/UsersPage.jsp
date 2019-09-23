<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Users</title>

</head>
<body>

	<div>
		<jsp:include page="NavBarHeader.jsp" />
	</div>

<!-- <h5>View Users</h5> -->
<!-- <h5>Add User(s)</h5> -->
<!-- <h5>Remove User()s)</h5> -->
<!-- <h5>Add Customers</h5> -->



		<div>
			<jsp:include page="UserTable.jsp" />
		</div>

	<div>
		<jsp:include page="InfoFooter.jsp" />
	</div>

</body>

</html>