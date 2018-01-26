<%--
  Created by IntelliJ IDEA.
  User: dik81
  Date: 23.01.18
  Time: 10:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Form</title>
</head>
<body>
<form action="/addDepartmentServlet?id=${id}" method="post">
    <table>
        <tr><td>Department name:</td></tr>
        <tr><td>
            <input type="text" name="name" value="${editedName}">
        </td></tr>
        <tr><td>
            <input type="submit" value="Submit">
        </td></tr>
    </table>
</form>

</body>
</html>
