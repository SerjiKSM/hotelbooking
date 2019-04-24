<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>

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

                        <form role="form" enctype="multipart/form-data" class="form-horizontal" action="/user/add" method="post">

                            <div class="form-group">
                                <h1>Create new user</h1>
                            </div>

                            <div class="form-group">
                                <label for="user">User name</label>
                                <input id="user" type="text" name="user" required>
                            </div>

                            <div class="form-group"><input type="submit" class="btn btn-primary booking" value="Create"></div>
                        </form>
                    </div>
                </div><!-- /.col-md-12 -->
            </div><!-- /.row -->
        </div><!-- /.container -->
    </section>
</div><!-- boxed -->
</body>
</html>

