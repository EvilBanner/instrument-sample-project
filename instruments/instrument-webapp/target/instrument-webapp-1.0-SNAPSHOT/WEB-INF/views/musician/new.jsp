<%@page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/musician.css"/>
<html>
<head>
    <title>Add musician</title>
</head>
<body>

        <h2>Add new musician</h2>
    <form:form method="post" modelAttribute="musicianForm" action="${pageContext.request.contextPath}/musician/create">
        <table >
            <tr>
                <th class="">Person name</th>
                <td><form:label path="name">Name</form:label>
                    <form:input value='${param.name}' path="name"/>
                </td>
            </tr>
            <tr>
                <th>Person country</th>
                <td><label>
                    <form:label path="name">Country</form:label>
                    <form:input value='${param.country}' path="country"/>
                </label></td>
            </tr>
        </table>
        <input type="Submit" value=Submit" />
    </form:form>
    <a href="./list">View all players</a>

</body>
</html>