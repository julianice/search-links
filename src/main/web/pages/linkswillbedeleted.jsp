
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
</head>
<body>

<h1>Links for deleting</h1>

<table>
    <thead>
    <tr>
        <th>Page</th>
        <th>Link for deleting</th>

    </tr>
    </thead>
    <tbody>
    <c:forEach items="${links}" var="linksForDeleting">
        <tr>
            <td>${linksForDeleting.page}</td>
            <td>${linksForDeleting.url}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>