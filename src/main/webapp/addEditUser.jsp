<%--
  Created by IntelliJ IDEA.
  User: dik81
  Date: 24.01.18
  Time: 11:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User</title>
</head>
<body>

<form action="/addUserServlet" method="post">
<input type="hidden" name="id" value="<%=request.getParameter("id")%>">
<input type="hidden" name="userId" value="${userId}">
    <table>
    <tr><td>Enter name:</td></tr>
    <tr><td><input type="text" name="name" value="${editedName}"></td></tr>
    <tr><td>Enter age:</td></tr>
    <tr><td><input type="text" name="age" value="${editedAge}"></td></tr>
    <tr><td><input type="submit" value="Submit"></td></tr>
    </table>
</form>

</body>
</html>
