<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>

<c:set var="path" value="${pageContext.request.contextPath}"></c:set>

<html>
<head>
    <title>11111</title>
</head>
<body>
<div class="boxed">
    <p>${message}</p>
    <p>
        <a href="${path}/user/list">User list</a>
        <br>
        <a href="${path}/address/list">Address list</a>
    </p>
</div><!-- boxed -->

</body>
</html>