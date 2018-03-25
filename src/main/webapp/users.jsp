<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--
  Created by IntelliJ IDEA.
  User: dik81
  Date: 23.01.18
  Time: 14:13
  To change this template use File | Settings | File Templates.
--%>

<html>
<head>
    <title>Users of Department</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
<h3>Users of department <c:out value="${department.name}"/> </h3>

<table class="table-condensed table-bordered table-hover">
    <tr>
        <th>Name</th>
        <th>Age</th>
        <th>Edit</th>
        <th>Remove</th>
    </tr>
    <c:forEach items="${usersList}" var="item">
        <tr>
            <td><c:out value="${item.name}"/></td>
            <td><c:out value="${item.age}"/></td>
            <td class="text-center"><a href="/mvc/addUserServlet?userId=${item.id}&id=<c:out value="${department.id}"/>"><button>E</button></a></td>
            <td class="text-center"><a href="/mvc/removeUserServlet?userId=${item.id}&id=<c:out value="${department.id}"/>">
                <button>R</button></a></td>
        </tr>
    </c:forEach>
</table>
<br>
    <p>
        <a href="/mvc/addUserServlet?id=<c:out value="${department.id}"/>"><button class="btn btn-primary btn-circle btn-xl">Add user</button></a>
    </p>
<%--
    <%=request.getAttribute("departmentId")%>
           --%>
    <p>
        <a href="/mvc/mainServlet"><button class="btn btn-primary btn-circle btn-xl">Back to departments</button></a><br>
    </p>
</div>
</body>
</html>
