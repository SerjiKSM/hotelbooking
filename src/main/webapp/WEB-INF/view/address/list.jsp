<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>

<c:set var="path" value="${pageContext.request.contextPath}"></c:set>

<html>
<head>
    <title>Address</title>
</head>
<body>
<div class="boxed">

    <p>
        <a href="${path}/user/list">User list</a>
        <br>
        <a href="${path}/address/list">Address list</a>
    </p>

    <table>
        <thead>
            <tr>
                <th>city</th>
                <th>state</th>
                <th>country</th>
                <th>user</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${addresses}" var="address">
                <tr>
                    <td>${address.city}</td>
                    <td>${address.state}</td>
                    <td>${address.country}</td>
                    <td>${address.user.username}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div><!-- boxed -->

</body>
</html>