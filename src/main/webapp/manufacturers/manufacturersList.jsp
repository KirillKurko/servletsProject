<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Manufacturers</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">List of Users</h3>
			<hr>
			<div class="container text-left">

                <
				<a href="addManufacturerForm.jsp" class="btn btn-success">Add
					New Manufacturer</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Manufacturer Email</th>
						<th>Price</th>
						<th>Manufacturer ID</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<!--   for (Todo todo: todos) {  -->
					<c:forEach items="${souvenirs}" var="souvenir" varStatus="status">

						<tr>
							<td><c:out value="${souvenir.id}" /></td>
							<td><c:out value="${souvenir.name}" /></td>
							<td><c:out value="${souvenir.manufacturerEmail}" /></td>
							<td><c:out value="${souvenir.price}" /></td>
							<td><c:out value="${souvenir.manufacturerID}" /></td>
							<td><a href="edit?id=<c:out value='${souvenir.id}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete?id=<c:out value='${souvenir.id}' />">Delete</a></td>
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>