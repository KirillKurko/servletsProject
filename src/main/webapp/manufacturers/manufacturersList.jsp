<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.Manufacturer" %>
<%@ page import="DAO.interfaces.ManufacturerDAO" %>
<%@ page import="DAO.implementation.ManufacturerDAOImplementation" %>
<html>
	<head>
		<title>Souvenirs</title>
		<link rel="stylesheet" href="../resources/css/registrationPageStyle.css" type="text/css">
	</head>
	<body>
		<div class="login-page">
			<div class="form">
				<form class="login-form" action="manufacturerServlet" method="post">
					<button name="addManufacturerButton">Add</button>
					<button name="deleteManufacturerButton">Delete</button>
					<button name="searchManufacturerButton">Search</button>
					<button name="editManufacturerButton">Edit</button>
				</form>
			</div>
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