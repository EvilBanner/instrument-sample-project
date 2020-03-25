<%--
  Created by IntelliJ IDEA.
  User: patri
  Date: 25.03.2020
  Time: 13:25
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/musician.css"/>
<html>
<head>
    <title>Instruments</title>
</head>
<body>
<h2>Musicians</h2>
<table class="display">

    <thead>
    <tr class="thDisplay">
        <th>Instrument id</th>
        <th>Instrument name</th>
        <th>Country</th>
        <th>Delete</th>
        <th>Edit</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${allInstruments}" var="instrument" >
        <tr>
            <td>${instrument.id}</td>
            <td>${instrument.name}</td>
            <td>${instrument.country}</td>
            <td><a href="./delete/${instrument.id}">Delete</a></td>
            <td><a href="./edit/${instrument.id}">Edit</a></td>
        </tr>
    </c:forEach>
    </tbody>

</table>



<a href="../">Homepage</a>
<a href="./new">Create new Instrument</a>
</body>
</html>
