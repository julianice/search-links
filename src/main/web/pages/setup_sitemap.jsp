<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Setup sitemap</title>
</head>
<body>

<form method="post" action="/getpages">
    <p>Enter URL with sitemap for search links: <input type="text" name="domain"></p>
    <p><input type="submit"></p>
</form>
</body>
</html>