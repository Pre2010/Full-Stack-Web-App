<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="css/tabulator.min.css" rel="stylesheet">

<script type="text/javascript" src="https://unpkg.com/tabulator-tables@4.2.3/dist/js/tabulator.min.js"></script>

</head>
<body>
<div id="example-table-theme"></div>

<script>
//input data into the table
 var tabledata = [
 	<c:forEach var="tempUser" items="${USER_LIST}">
 	{id:'${tempUser.id}', firstName:'${tempUser.firstName}', lastName:'${tempUser.lastName}', email:'${tempUser.email}', username:'${tempUser.username}', password:'${tempUser.password}', role:'${tempUser.role}'},
 	</c:forEach>
 ];
 
//create Tabulator on DOM element with id "example-table"
 var table = new Tabulator("#example-table-theme", {
  	height:"331px", // set height of table (in CSS or here), this enables the Virtual DOM and improves render speed dramatically (can be any valid css height value)
  	data:tabledata, //assign data to table
  	layout:"fitColumns",
  	responsiveLayout:"collapse",
  	movableColumns:true,
  	pagination:"local",
  	paginationSize: 5,
  	paginationSizeSelector:[10,15,20,25],
  	columns:[ //Define Table Columns
 	 	{title:"ID", field:"id", frozen:true},
 	 	{title:"First Name", field:"firstName"},
 	 	{title:"Last Name", field:"lastName"},
 	 	{title:"Email", field:"email"},
 	 	{title:"Username", field:"username"},
 	 	{title:"Password", field:"password"},
 	 	{title:"Role", field:"role"},
 	 	
  	],
  	rowClick:function(e, row){ //trigger an alert message when the row is clicked
  		alert("Row " + row.getData().id + " Clicked!!!!");
  	},
 });
</script>
</body>
</html>