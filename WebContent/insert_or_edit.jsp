<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css"
	href="css/ui-lightness/jquery-ui-1.8.18.custom.css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.18.custom.min.js"></script>

<title>Insert or Update a user</title>
</head>

<body>
	<form method="POST" action='controller' >
		User ID : <input type="text" readonly="readonly" name="userid"
			value="<c:out value="${user.userid}" />" /> <br /> 
		First Name : <input type="text" name="firstName"
			value="<c:out value="${user.firstName}" />" /> <br /> 
		Last Name : <input type="text" name="lastName"
			value="<c:out value="${user.lastName}" />" /> <br />
		Book Name: <input type="text" name="bookName"
			value="<c:out value="${user.bookName}" />" /> <br /> 
		Return Due : <input type="text" name="returnDate" 
			value="<c:out value="${user.returnDate}" />" />
		<br /> <input type="submit" value="Submit" />
	</form>
</body>

</html>