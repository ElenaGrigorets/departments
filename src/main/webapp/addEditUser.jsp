<%--
  Created by IntelliJ IDEA.
  User: dik81
  Date: 24.01.18
  Time: 11:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>User</title>
</head>
<body>

<spring:form action="/addUserServlet" method="post" modelAttribute="user">
<spring:hidden path="departmentId" name="id" value="${departmentId}"/>
<spring:hidden path="id" name="userId" value="${user.id}"/>
    <table>
    <tr><td>Enter name:</td></tr>
    <tr><td><spring:input path="name" type="text" name="name" value="${user.name}"/></td></tr>
    <tr><td>Enter age:</td></tr>
    <tr><td><spring:input path="age" type="text" name="age" value="${user.age}"/></td></tr>
    <tr><td><spring:input path="" type="submit" value="Submit"/></td></tr>
    </table>
</spring:form>

</body>
</html>
