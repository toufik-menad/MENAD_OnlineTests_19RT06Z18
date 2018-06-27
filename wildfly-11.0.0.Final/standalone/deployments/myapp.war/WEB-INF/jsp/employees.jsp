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

<br>
<div class="container">
  <h2>List of Employees</h2>
  <a href="<c:url value="/employees/register" />"  role="button" class ="btn pull-left" aria-pressed="true">Register New Employee</a>
  <table id="employeelist"  class="table table-dark">                
                  <thead>
                    <tr>
                      <th width="60%">First Name</th>
                      <th >Last Name</th>
                      <th >Salary</th>
                    </tr>
                  </thead>
                  <tbody>
                    <c:forEach var="employee" items="${employeeModel.employees}">
                        <tr> 
                            <td><a href ="<c:url value="/employees/${employee.oid}" />">${employee.firstName}</a>
                            <td>${employee.lastName}</td>
                            <td>${employee.salary}</td>
                        </tr>
                    </c:forEach>
                  </tbody>                  
   </table>
 </div>
</body>
</html>