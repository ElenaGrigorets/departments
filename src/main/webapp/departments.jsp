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
</head>
<body>
<h1>Departments List</h1>
<table>
  <tr>
    <td>Name</td>
    <td>Edit</td>
    <td>Remove</td>
  </tr>
  <c:forEach items="${departmentsList}" var="item">
    <tr>
      <td><a href="/listUsersServlet?id=${item.id}"><c:out value="${item.name}"/></a></td>
    <%--
     <td><a href="users.jsp?departmentId=${item.id}&departmentName=${item.name}"><c:out value="${item.name}"/></a></td>
     --%>
     <td><a href="/addDepartmentServlet?id=${item.id}"><button>E</button></a></td>
     <td><a href="/removeDepartmentServlet?id=${item.id}"><button>R</button></a></td>
   </tr>
   </c:forEach>
 </table>
    <p>
        <a href="/addDepartmentServlet"><button>Add department</button></a>
    </p>
 </body>
 </html>
