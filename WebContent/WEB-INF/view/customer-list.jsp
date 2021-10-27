<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.springdemo.utils.SortingUtils"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer-List</title>

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>
	<c:url var="sortLinkFirstName" value="/customer/list">
		<c:param name="sort"
			value="<%=Integer.toString(SortingUtils.FIRST_NAME)%>" />
	</c:url>

	<c:url var="sortLinkLastName" value="/customer/list">
		<c:param name="sort"
			value="<%=Integer.toString(SortingUtils.LAST_NAME)%>" />
	</c:url>

	<c:url var="sortLinkEmail" value="/customer/list">
		<c:param name="sort"
			value="<%=Integer.toString(SortingUtils.EMAIL)%>" />
	</c:url>
	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
		<div id="container">
			<input type="button" value="Add Customer"
				onclick="window.location.href='showAddCustomer';" />
			<form action="searchCustomer">
			<label>Search Customer : </label><input type="text" name="searchName">
			<input type="submit" value="Search">
			</form>
			<div id="content">
				<table>
					<thead>
						<tr>
							<th><a href="${sortLinkFirstName}">First Name</a></th>
							<th><a href="${sortLinkLastName}">Last Name</a></th>
							<th><a href="${sortLinkEmail}">Email</a></th>
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
								<td><a href="${UpdateLink}">Update</a>|<a
									href="${DeleteLink}"
									onclick="if !(confirm('Are you sure you want to Delete?'))return false;">Delete</a></td>
							</tr>

						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>