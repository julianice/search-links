
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="links" scope="request" type="java.util.List<searchlinks.entities.Link>"/>
<html>
<head>
</head>
<body>

<h1>Your links: </h1>

<table>
    <thead>
        <tr>
            <th>Link url</th>
        </tr>
    </thead>
    <tbody>
    <c:forEach items="${links}" var="allLinks">
    <tr>
        <td>${allLinks.url}</td>
    </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>