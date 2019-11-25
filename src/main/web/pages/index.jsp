<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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

<%--<c:if test="${empty sessionScope['userId']}">--%>
<form:form action="/register" method="post" modelAttribute="form">
<p>Login:
    <form:input type="text" path="login" />

    <form:errors path="login" cssStyle="color: red" />
</p>
<p>
    Password:
    <form:password path="password" />

    <form:errors path="password" cssStyle="color: red" />
</p>
    <input type="submit" value="Register">
</form:form>

<%--</c:if>--%>

<%--<c:if test="${not empty sessionScope['userId']}">--%>
<%--    <p><a href="/dashboard">Dashboard</a></p>--%>
<%--</c:if>--%>

<%--<c:if test="${not empty param['login']}">--%>
<%--<p class="error">--%>
<%--    Login or password is incorrect!--%>
<%--</p>--%>
<%--</c:if>--%>

</body>
</html>