
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
            <th>Page url</th>
            <th>Mark for deleting</th>
        </tr>
    </thead>
    <tbody>
    <c:forEach items="${links}" var="allLinks">
    <tr>
        <td>${allLinks.page}</td>
        <td>${allLinks.url}</td>
        <td>
<%--        <input type="checkbox" name="willBeDeleted" value=${allLinks.willBeDeleted}> Will be deleted--%>
        <input type="checkbox" name="willBeDeleted" value="${param['willBeDeleted']}"> Will be deleted
        </td>
    </tr>
    </c:forEach>
    </tbody>
</table>
<form method="post" action="/markfordelete">
    <p><input type="submit" NAME="Mark for deleting"></p>
</form>
</body>
</html>