<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/addForm.css">
<title>Add User</title>
</head>
<body>

	<div>
		<jsp:include page="/jsp/NavBarHeader.jsp" />
	</div>

	<div class="addForm">

		<h3>Add New User</h3>

		<form action="CustomerControllerServlet" method="GET">

			<table>
				<tbody>
					<tr>
						<td><label> First name: </label></td>
						<td><input type="text" name="firstName" required class="inputName"/></td>
					</tr>

					<tr>
						<td><label></label></td>
					</tr>

					<tr>
						<td><label> Last name: </label></td>
						<td><input type="text" name="lastName" required class="inputName"/></td>
					</tr>

					<tr>
						<td><label></label></td>
					</tr>

					<tr>
						<td><label> Email: </label></td>
						<td><input type="email" name="email" required /></td>
					</tr>

					<tr>
						<td><label></label></td>
					</tr>

					<tr>
						<td><label> Company: </label></td>
						<td><input type="text" name="company" required /></td>
					</tr>

					<tr>
						<td><label></label></td>
					</tr>

					<tr>
						<td><label> IP Address: </label></td>
						<td><input type="text" id="ipAddress" name="ipAddress"
							required/></td>
					</tr>

					<tr>
						<td><label></label></td>
					</tr>

					<tr>
						<!-- 						<td><label></label></td> -->

						<td><input type="submit" value="Save"
							class="save tableButton" /></td>
						<!-- 						<td><label></label></td> -->
						<td><input type="reset" value="Reset"
							class="reset tableButton" /></td>
					</tr>
				</tbody>
			</table>


			<input type="hidden" name="command" value="ADD" />
		</form>

		<div style="clear: both;"></div>
		<br>
		<p>
			<a href="CustomerControllerServlet">Back to List</a>
		</p>

	</div>

	<div>
		<jsp:include page="/jsp/InfoFooter.jsp" />
	</div>


</body>

</html>