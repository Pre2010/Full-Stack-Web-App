<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Customers</title>

</head>
<body>

	<div>
		<jsp:include page="NavBarHeader.jsp" />
	</div>

<!-- <h5>View Customers</h5> -->
<!-- <h5>Add Customer(s)</h5> -->
<!-- <h5>Remove Customer()s)</h5> -->
<!-- <h5>Add Customers</h5> -->



		<div>
			<jsp:include page="CustomerTable.jsp" />
		</div>

	<div>
		<jsp:include page="InfoFooter.jsp" />
	</div>

</body>

</html>