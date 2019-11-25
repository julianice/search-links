<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Dashboard</title>
</head>
<body>

<form method="post" action="/getpages">
    <p>Enter URL with sitemap for search links: <input type="text" name="domain" value="${param['urlWithSitemap']}"></p>
    <p><input type="submit"></p>
</form>
</body>
</html>