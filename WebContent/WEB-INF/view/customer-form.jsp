<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/add-customer-style.css" />
<meta charset="ISO-8859-1">
<title>Add Customer</title>
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
		<div id="container">
			<form:form action="saveCustomer" modelAttribute="customer" method="POST">
			<h2>Add Customer</h2>
				<table>
				
					<tbody>
					
						<tr>
							<td><label>First Name : </label></td>
							<td><form:input path="firstName" /></td>
							<td><form:errors path="firstName"></form:errors></td>
						</tr>
						<tr>
							<td><label>Last Name : </label></td>
							<td><form:input path="lastName" /></td>
							<td><form:errors path="lastName"></form:errors></td>
						</tr>
						<tr>
							<td><label>Email : </label></td>
							<td><form:input path="email" /></td>
							<td><form:errors path="email"></form:errors></td>
						</tr>
						<tr>
							<td><input type="submit" value="Save"></td>
						</tr>
					</tbody>
				</table>



			</form:form>
		</div>
	</div>
</body>
</html>