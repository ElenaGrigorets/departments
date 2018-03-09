<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dik81
  Date: 23.01.18
  Time: 14:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users of department</title>
</head>
<body>
<h3>Users of department <c:out value="${departmentName}"/> </h3>

<table>
    <tr>
        <td>Name</td>
        <td>Age</td>
        <td>Edit</td>
        <td>Remove</td>
    </tr>
    <c:forEach items="${usersList}" var="item">
        <tr>
            <td><c:out value="${item.name}"/></td>
            <td><c:out value="${item.age}"/></td>
            <td><a href="/addUserServlet?userId=${item.id}&id=<c:out value="${departmentId}"/>"><button>E</button></a></td>
            <td><a href="/removeUserServlet?userId=${item.id}&id=<c:out value="${departmentId}"/>">
                <button>R</button></a></td>
        </tr>
    </c:forEach>
</table><br>
    <p>
        <a href="addEditUser.jsp?id=<c:out value="${departmentId}"/>"><button>Add user</button></a>
    </p>
<%--
    <%=request.getAttribute("departmentId")%>
           --%>
    <p>
        <a href="/mainServlet"><button>Back to departments</button></a><br>
    </p>
</body>
</html>
