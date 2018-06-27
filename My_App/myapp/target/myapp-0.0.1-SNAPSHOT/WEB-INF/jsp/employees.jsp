<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
<title>Employees</title>

</head>
<body>

<h1>Employees</h1>


<div>
<div>
<table>
<tr>
	<th>First Name</th>
	<th>Last Name</th>
	<th>Salary</th>
	<th>Department</th>
</tr>
<tr>
	<th>First Name</th>
	<th>Last Name</th>
	<th>Salary</th>
	<th>Department</th>
</tr>
</table>
</div>
<div>

	<form name="form" method="post" action="<c:url value="/employees" />" >
		First name:<br> <input type="text" name="firstName"
			value="Mickey"> <br>
		
		Last name:<br> <input
			type="text" name="lastName" value="Mouse"> <br>
		
		Salary:<br>
		<input type="text" name="salary" value="1000"> <br>
		
		Department:<br> <input type="text" name="department"
			value="Mickey"> <br> <br>
		<br> <input type="submit" value="Submit">
	</form>
</div>
</div>

</body>
</html>