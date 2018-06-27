<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">  
<script src="../js/bootstrap.min.js"></script> 
<title>Departments</title>
</head>



<body>
<h1>Departments</h1>
<h2>Register a New Department</h2>
<div class="container">
	<form class="form-group" name="form" method="post" action="<c:url value="/departments" />">
	
	    <c:if test = "${not empty departmentModel.messageError}">
                    <div class="alert alert-danger" role ="alert">
                         <strong>${departmentModel.messageError}</strong>
                    </div>
        </c:if>
	
    	<div class="form-group" >
    	<label for="name">Department Name</label>
    	<input type="text" class="form-control" id="name" name="name">
    	</div>
    	<div class="form-group">
    	<label for="id">Department ID</label>
    	<input type="text" class="form-control" id="id" name="id">
    	</div>
    	<button type="submit" class="btn btn-primary">Register</button>
     </form>
<br>
<h2>List of Departments</h2>
        <table id="departmentlist"  class="table table-dark">                
                  <thead>
                    <tr>
                      <th width="60%">Name</th>
                      <th width="60%">ID</th>
                    </tr>
                  </thead>
                  
                  <tbody>
                    <c:forEach var="department" items="${departmentModel.departments}">
                        <tr> 
                            <td>${department.name}</td>
                            <td>${department.id}</td>
                        </tr>
                    </c:forEach>
                  </tbody>
                  
          </table>
 </div>
</body>
</html>