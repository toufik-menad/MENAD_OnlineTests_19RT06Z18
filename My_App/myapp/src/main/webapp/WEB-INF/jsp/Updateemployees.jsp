<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">  
<script src="../js/bootstrap.min.js"></script> 
<title>Employees</title>
</head>
<body>

<h1>Employees</h1>

<h2>Update an Employee</h2>
<div class="container">
        <c:if test = "${not empty employeeModel.inputErrors['salary']}">
                    <div class="alert alert-danger" role ="alert">
                         <strong>${employeeModel.inputErrors['salary']}</strong>
                    </div>
        </c:if>
                <c:if test = "${not empty employeeModel.inputErrors['format']}">
                    <div class="alert alert-danger" role ="alert">
                         <strong>${employeeModel.inputErrors['format']}</strong>
                    </div>
        </c:if>
        
<form id = "FormPersonList" class="form-group" name="form" method="post" action="<c:url value="/employees/${employeeModel.employee.oid}" />">
    	<div class="form-group" >
    	<label for="name">First Name</label>
    	<input type="text" class="form-control" id="name" name="firstName" value="${employeeModel.employee.firstName }">
    	</div>
    	<div class="form-group" >
    	<label for="name">Last Name</label>
    	<input type="text" class="form-control" id="lastName" name="lastName" value="${employeeModel.employee.lastName }">
    	</div>
    	<div>
    	<label for="name">Salary</label>
    	<input type="text" class="form-control" id="salary" name="salary" value="${employeeModel.employee.salary}">
    	</div>
    	<div>
    	<label for="name">Department</label>
    	<input type="text" class="form-control" id="Department" name="Department" value="${employeeModel.myDepartmentName}" readonly>
    	</div>
    	
		<div class="form-group">
    		<label for="exampleFormControlSelect1">Select Department</label>
    			<select class="form-control" id="exampleFormControlSelect1" name="department">
      						<c:forEach var="department" items="${departmentModel.departments}">
                            	<option>${department.name}</option>
                    		</c:forEach>
    			</select>
  		</div>
  		<button type="submit" class="btn btn-primary">Update</button>
  		<a href="<c:url value="/employees/" />"  role="button" class ="btn pull-left" aria-pressed="true">Employee List link</a>
  		<a href="<c:url value="/employees/register" />"  role="button" class ="btn pull-left" aria-pressed="true">Register New Employee</a>
  </form>
  <br>
  
</body>
</html>