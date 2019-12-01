
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <form method="post" action="/markfordelete">
    <tr>
        <td>${allLinks.page}</td>
        <td>${allLinks.url}</td>
        <td>
        <input type="checkbox" name="delete" value="${allLinks.id}"> Will be deleted
        </td>
    </tr>
    </c:forEach>
    </tbody>
</table>
    <p><input type="submit"></p>
</form>
</body>
</html>