<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: patri
  Date: 23.03.2020
  Time: 17:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit musician</title>
</head>
<body>
<form:form method="post" modelAttribute="musicianEditedForm" action="${pageContext.request.contextPath}/musician/save" >

    <table >
        <tr>
            <td>
                <form:hidden path="id"  style="display:none"/>
            </td>
        </tr>

        <tr>
            <td><form:label path="name">Current Name: </form:label>
                <form:input path="name"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="country">Current country: </form:label>
                <form:input path="country"/>
            </td>
        </tr>
    </table>
    <input type="Submit" value=Edit />
</form:form>
</body>
</html>
