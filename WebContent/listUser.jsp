<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show All Users</title>
</head>
<body>
	<table border=2>
		<thead>
			<tr>
				<th>User ID</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Book Name</th>
				<th>Return Date</th>
				<th colspan=2>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${users}" var="user">
				<tr>
					<td><c:out value="${user.userid}" /></td>
					<td><c:out value="${user.firstName}" /></td>
					<td><c:out value="${user.lastName}" /></td>
					<td><c:out value="${user.bookName}" /></td>
					<td><c:out value="${user.returnDate}" /></td>
					<td><a href="controller?action=edit&userid=<c:out value="${user.userid}" />">Update </a></td>
					<td><a href="controller?action=delete&userid=<c:out value="${user.userid}" />">Delete </a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<p> <a href="controller?action=insert">Add new user</a></p>
</body>
</html>