
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="links1" scope="request" type="java.util.List<searchlinks.entities.Link>"/>
<html>
<head>
</head>
<body>

<h1>Links for deleting</h1>

<table>
    <thead>
    <tr>
        <th>Link url</th>
        <th>Page url</th>
        <th>Mark for deleting</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${linksWillBeDeleted}" var="links1">
        <tr>
            <td>${links.page}</td>
            <td>${links.url}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>