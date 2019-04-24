<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>

<c:set var="path" value="${pageContext.request.contextPath}"></c:set>

<html>
<head>
    <%@ include file="/WEB-INF/view/meta-data.jsp" %>
</head>
<body>

<div class="boxed">
    <section class="main-blog-single page-wrap">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="container">

                        <%@ include file="/WEB-INF/view/menu.jsp" %>

                        <br>

                        <div>
                            <table class="table">
                                <thead>
                                <tr>
                                    <th scope="col">User</th>
                                </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${users}" var="user">
                                        <tr>
                                            <td>${user.username}</td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>

                    </div>
                </div><!-- /.col-md-12 -->
            </div><!-- /.row -->
        </div><!-- /.container -->
    </section>
</div><!-- boxed -->
</body>
</html>
