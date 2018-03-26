<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: dik81
  Date: 23.01.18
  Time: 10:30
  To change this template use File | Settings | File Templates.
--%>

<html>
<head>
    <title>Departments List</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
<h1>Departments List</h1>
<table class="table-condensed table-bordered table-hover">
  <tr>
    <th>Name</th>
    <th>Edit</th>
    <th>Remove</th>
  </tr>
  <c:forEach items="${departmentsList}" var="item">
    <tr>
      <td><a href="/mvc/listUsersServlet?id=${item.id}"><c:out value="${item.name}"/></a></td>
    <%--
     <td><a href="users.jsp?departmentId=${item.id}&departmentName=${item.name}"><c:out value="${item.name}"/></a></td>
     --%>
     <td class="text-center"><a href="/mvc/addDepartmentServlet?id=${item.id}"><button>E</button></a></td>
     <td class="text-center"><a href="/mvc/removeDepartmentServlet?id=${item.id}"><button>R</button></a></td>
   </tr>
   </c:forEach>
 </table>
    <br>
    <p>
        <a href="/mvc/addDepartmentServlet"><button class="btn btn-primary btn-circle btn-xl">Add department</button></a>
    </p>
</div>
 </body>
 </html>
