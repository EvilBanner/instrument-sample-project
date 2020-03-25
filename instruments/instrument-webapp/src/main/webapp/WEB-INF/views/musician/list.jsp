<%--
  Created by IntelliJ IDEA.
  User: patri
  Date: 23.03.2020
  Time: 13:38
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/musician.css"/>
<html>
<head>
    <title>Person list</title>
</head>
<body>
<h2>Musicians</h2>
<table class="display">

    <thead>
    <tr class="thDisplay">
        <th>Musician id</th>
        <th>Musician name</th>
        <th>Country</th>
        <th>Delete</th>
        <th>Edit</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${musicians}" var="musician" >
        <tr>
            <td>${musician.id}</td>
            <td>${musician.name}</td>
            <td>${musician.country}</td>
            <td><a href="./delete/${musician.id}">Delete</a></td>
            <td><a href="./edit/${musician.id}">Edit</a></td>
        </tr>
    </c:forEach>
    </tbody>

</table>



<a href="${pageContext.request.contextPath}index">Homepage</a>
<a href="./new">Create new Musician</a>
</body>
</html>
