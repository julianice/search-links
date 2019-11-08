
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="sites" scope="request" type="java.util.List<searchlinks.entities.Site>"/>
<html>
<head>
    <title>Your pages</title>
</head>
<body>

<h1>Your pages</h1>

<%--<form method="post" action="/login">--%>
<%--    <p>Enter domain for search links: <input type="text" name="domain" value="${param['domain']}"></p>--%>
<%--    <p><input type="submit"></p>--%>
<%--</form>--%>

<table>
    <thead>
        <tr>
            <th>domain</th>
        </tr>
    </thead>
    <tbody>
    <c:forEach items="${sites}" var="sites">
    <tr>
        <td>${sites.domain}</td>
    </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>