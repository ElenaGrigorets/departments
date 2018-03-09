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
    <%--<script>--%>
        <%--function validateForm() {--%>
            <%--var x = document.departmentForm.name.value;--%>
            <%--if (x == "") {--%>
                <%--alert("Name must be filled out!");--%>
                <%--return false;--%>
 <%--//               /^[A-Za-z ]+$/.test(x)--%>
            <%--}--%>
        <%--}--%>
    <%--</script>--%>
</head>
<body>
<form name="departmentForm" action="/addDepartmentServlet?id=${id}"  method="post">
    <table>
        <tr><td>Department name:</td></tr>
        <tr><td>
            <input type="text" pattern="[a-zA-Z0-9]+" name="name" value="${editedName}" title="Please enter letters or digits" required>
        </td></tr>
        <tr><td>
            <input type="submit" value="Submit">
        </td></tr>
    </table>
</form>

</body>
</html>
