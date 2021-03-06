<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        .error {
            color: red;
        }
    </style>
</head>
<body>
<h1>Hello</h1>

<c:if test="${empty sessionScope['userId']}">
<form method="post" action="/login">
    <p>Login: <input type="text" name="login"></p>
    <p>Password: <input type="password" name="password"></p>
    <p><input type="submit"></p>
</form>
</c:if>

<c:if test="${not empty param['login']}">
<p class="error">
    Login or password is incorrect!
</p>
</c:if>
</body>
</html>