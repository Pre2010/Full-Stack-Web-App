<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="css/tabulator.min.css" rel="stylesheet">

<script type="text/javascript"
	src="https://unpkg.com/tabulator-tables@4.2.3/dist/js/tabulator.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/1.3.5/jspdf.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jspdf-autotable/3.0.5/jspdf.plugin.autotable.js"></script>
<script type="text/javascript"
	src="http://oss.sheetjs.com/js-xlsx/xlsx.full.min.js"></script>
</head>
<body>
	<div class="table-instructions">
		<p>Click on a row to update/delete customer. Click on the 'Field' and
			'Type' drop-down boxes for more search options. You can also add a
			new customer by clicking on the 'Add customer' button. You can export the
			table data in the following formats: PDF, CSV, and Excel.</p>
	</div>
	<div class="table-controls">

		<label class="table-filter-labels">Field: </label> <select
			id="filter-field">
			<!-- <option></option> -->
			<option value="id" selected="selected">ID</option>
			<option value="firstName">First Name</option>
			<option value="lastName">Last Name</option>
			<option value="company">Company</option>
			<option value="email">Email</option>
			<option value="ipAddress">IP Address</option>
		</select> <label class="table-filter-labels" hidden>Type: </label> <select
			id="filter-type" hidden>
			<option value="=">=</option>
			<option value="<">&lt;</option>
			<option value="<=">&lt;=</option>
			<option value=">">&gt;</option>
			<option value=">=">&gt;=</option>
			<option value="!=">!=</option>
			<option value="like" selected="selected">like</option>
		</select> <label class="table-filter-labels">Input: </label> <input type="text"
			id="filter-value" placeholder="Search param(s) here.">

		<button id="customer-filter-clear" class="tableButton">Clear Filter</button>

		<label class="verticalLine">|</label> <input type="button"
			id="add-customer" value="Add customer"
			onclick="window.location.href='Addcustomer.jsp'; return false;"
			class="tableButton" /> <label class="verticalLine">|</label> <input
			type="button" id="delete-customer" value="Delete customer(s)"
			onclick="'; return false;" class="tableButton" /> <label
			class="verticalLine">|</label>

		<button id="pdfExport" class="tableButton exportButton">PDF
			Export</button>
		<label class="verticalLine">|</label>
		<button id="csvExport" class="tableButton exportButton">CSV
			Export</button>
		<label class="verticalLine">|</label>
		<!-- 			<button id="jsonExport" class=tableButton exportButton">JSON Export</button> -->
		<button id="excelExport" class="tableButton exportButton">Excel
			Export</button>
		<label class="verticalLine">|</label>
	</div>

	<div id="customer-table"></div>

	<script>
//input data into the table
 var tabledata = [
 	<c:forEach var="tempCustomer" items="${CUSTOMER_LIST}">
 	{id:'${tempCustomer.id}', firstName:'${tempCustomer.firstName}', lastName:'${tempCustomer.lastName}', email:'${tempCustomer.email}', company:'${tempCustomer.company}', ipAddress:'${tempCustomer.ipAddress}'},
 	</c:forEach>
 ];

// //Custom filter example
//  function customFilter(data){
//      return data.car && data.rating < 3;
//  }

 //Trigger setFilter function with correct parameters
 function updateFilter(){

     var filter = $("#filter-field").val() == "function" ? customFilter : $("#filter-field").val();

     if($("#filter-field").val() == "function" ){
         $("#filter-type").prop("disabled", true);
         $("#filter-value").prop("disabled", true);
     }else{
         $("#filter-type").prop("disabled", false);
         $("#filter-value").prop("disabled", false);
     }

     table.setFilter(filter, $("#filter-type").val(), $("#filter-value").val());
 }

 //Update filters on value change
 $("#filter-field, #filter-type").change(updateFilter);
 $("#filter-value").keyup(updateFilter);

 //Clear filters on "Clear Filters" button click
 $("#filter-clear").click(function(){
     $("#filter-field").val("id");
     $("#filter-type").val("like");
     $("#filter-value").val("");

     table.clearFilter();
 });

//create Tabulator on DOM element with id "customer-table"
 var table = new Tabulator("#customer-table", {
  	height:"475px", // set height of table (in CSS or here), this enables the Virtual DOM and improves render speed dramatically (can be any valid css height value)
  	data:tabledata, //assign data to table
  	layout:"fitColumns",
  	responsiveLayout:"collapse",
// 	responsibeLayout:true,
//   	autoResize: true,
  	movableColumns:true,
  	pagination:"local",
  	selectable: true,
  	selectablePersistence:true,
  	paginationSize: 25, //default amount of rows in the table
  	paginationSizeSelector:[10,15,20,25,30,35,40,45,50], //options for how many rows appear in the table
  	columns:[ //Define Table Columns
 	 	{title:"ID", field:"id", frozen:true},
 	 	{title:"First Name", field:"firstName"},
 	 	{title:"Last Name", field:"lastName"},
 	 	{title:"Email", field:"email"},
 	 	{title:"Company", field:"company"},
 	 	{title:"IP Address", field:"ipAddress"},
 	 	
  	],
//   	rowClick:function(e, row){ //trigger an alert message when the row is clicked
//   		alert("Delete customer " + row.getData().firstName + " " + row.getData().lastName + "?");
//   	},
 });

//trigger download of data.csv file
 $("#csvExport").click(function(){
     table.download("csv", "customer-data.csv");
 });

//  //trigger download of data.json file
//  $("#jsonExport").click(function(){
//      table.download("json", "customer-data.json");
//  });

 //trigger download of data.xlsx file
 $("#excelExport").click(function(){
     table.download("xlsx", "customer-data.xlsx", {sheetName:"customer Data"});
 });

 //trigger download of data.pdf file
 $("#pdfExport").click(function(){
     table.download("pdf", "customer-data.pdf", {
         orientation:"portrait", //set page orientation to portrait
         title:"customer Data Report", //add title to report
     });
 });
</script>
</body>
</html>