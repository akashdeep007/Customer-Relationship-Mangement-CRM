<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer-List</title>

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
		<div id="container">
			<input type="button" value="Add Customer"
				onclick="window.location.href='showAddCustomer';" />
			<div id="content">
				<table>
					<thead>
						<tr>
							<th>First Name</th>
							<th>Last Name</th>
							<th>Email</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>

						<c:forEach var="tempCustomer" items="${Customers}">
							<c:url var="UpdateLink" value="/customer/showUpdateCustomer">
								<c:param name="customerId" value="${tempCustomer.id }"></c:param>
							</c:url>
							<c:url var="DeleteLink" value="/customer/deleteCustomer">
								<c:param name="customerId" value="${tempCustomer.id }"></c:param>
							</c:url>
							<tr>
								<td>${tempCustomer.firstName}</td>
								<td>${tempCustomer.lastName}</td>
								<td>${tempCustomer.email}</td>
								<td><a href="${UpdateLink}">Update</a>|<a href="${DeleteLink}" onclick="if !(confirm('Are you sure you want to Delete?'))return false;">Delete</a></td>
							</tr>

						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>