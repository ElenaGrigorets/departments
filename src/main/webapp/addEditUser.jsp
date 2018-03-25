<%--
  Created by IntelliJ IDEA.
  User: dik81
  Date: 24.01.18
  Time: 11:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="/resources/js/jquery.min.js"></script>
<script src="/resources/js/jquery.form-validator.min.js"></script>
<%--<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>--%>
<script src="/resources/js/formcheck.js"></script>
<%--<script src="<c:url value="js/formcheck.js" />"></script>--%>
<%--<script src="<c:url value="/resources/ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js" />"></script>--%>
<%--<script src="<c:url value="//cdnjs.cloudflare.com/ajax/libs/jquery-form-validator/2.3.26/jquery.form-validator.min.js" />"></script>--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>User</title>

</head>
<body>

<spring:form id="myform" name="myForm" action="/mvc/addUserServlet" method="post" modelAttribute="user">

<spring:hidden path="departmentId" name="id" value="${departmentId}"/>
<spring:hidden path="id" name="userId" value="${user.id}"/>
    <table>
    <tr><td>Enter name:</td></tr>
    <tr><td><spring:input id="userName" path="name" type="text" name="name" value="${user.name}"
                          data-validation="length" data-validation-length="max100"/></td></tr>
    <tr><td>Enter age:</td></tr>
    <tr><td><spring:input path="age" type="number" name="age" value="${user.age}" required="required"/></td></tr>
    <tr><td><spring:input  class="btn large btn-success" path="" type="submit" value="Submit"/></td></tr>
    </table>

</spring:form>

</body>
</html>
