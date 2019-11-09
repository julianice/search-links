
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="pages" scope="request" type="java.util.List<searchlinks.entities.Page>"/>
<html>
<head>
</head>
<body>

<h1>Your pages: </h1>

<table>
    <thead>
        <tr>
            <th>Page path</th>
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

<form method="get" action="/getlinks">
    <p><input type="submit" NAME="Get links!!"></p>
</form>
</body>
</html>