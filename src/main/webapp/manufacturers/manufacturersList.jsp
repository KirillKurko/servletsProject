<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.Manufacturer" %>
<%@ page import="DAO.interfaces.ManufacturerDAO" %>
<%@ page import="DAO.implementation.ManufacturerDAOImplementation" %>
<html>
	<head>
		<title>Manufacturers</title>
		<link rel="stylesheet" href="../resources/css/registrationPageStyle.css" type="text/css">
		<link rel="stylesheet" href="../resources/css/toolbar.css" type="text/css">
		<link rel="stylesheet" href="../resources/css/table.css" type="text/css">
	</head>
	<body>
		<div class="topnav">
			<a class="active" href="addManufacturerForm.jsp">Add</a>
			<a class="active" href="deleteManufacturerForm.jsp">Delete</a>
			<a class="active" href="editManufacturerForm.jsp">Edit</a>
			<a style="float: right" class="active" href="../main.jsp">Back</a>
		</div>
		<table class="content-table">
			<thead>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Country</th>
			</tr>
			</thead>
			<tbody>
			<% ManufacturerDAO manufacturerDAO = new ManufacturerDAOImplementation();
				List<Manufacturer> manufacturers = manufacturerDAO.selectAllManufacturers();
				for (Manufacturer manufacturer: manufacturers) { %>
			<tr>
				<td><%=manufacturer.getId()%></td>
				<td><%=manufacturer.getName()%></td>
				<td><%=manufacturer.getCountry()%></td>
			</tr>
			<%}%>
			</tbody>
		</table>
	</body>
</html>