
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
</head>
<body>

<h1>Pages</h1>

<table>
    <thead>
        <tr>
            <th>Your pages: </th>
        </tr>
    </thead>
    <tbody>
    <c:forEach items="${pages}" var="pages">
    <tr>
        <td>${pages.path}</td>
    </tr>
    </c:forEach>
    </tbody>
</table>

<form method="post" action="/getlinks">
    <p><input type="submit"></p>
</form>
</body>
</html>
