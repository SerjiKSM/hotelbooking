<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<!DOCTYPE html>

<html>
<head>
    <%@ include file="meta-data.jsp" %>
</head>
<body>

<div class="boxed">
    <section class="main-blog-single page-wrap">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="container">

                        <%@ include file="menu.jsp" %>

                        <h1>List orders</h1>

                        <div class="block-filter">
                            <div class="filter-user">
                                <form role="form" enctype="multipart/form-data" class="form-horizontal" action="/filter-user" method="post">
                                    <div class="form-group">
                                        <label for="filterUser">User:</label>
                                        <select id="filterUser" class="" name="filterUser" title="Choose user..." required>
                                            <option value="">None</option>
                                            <c:forEach var="user" items="${users}">
                                                <option value="<c:out value='${user.id}' />">
                                                    <c:out value="${user.username}" />
                                                </option>
                                            </c:forEach>
                                        </select>
                                    </div>

                                    <div class="form-group"><input type="submit" class="btn btn-primary" value="User filter"></div>
                                </form>
                            </div>

                            <div class="filter-all-orders">
                                <form role="form" enctype="multipart/form-data" class="form-horizontal" action="/list-orders" method="post">
                                    <div class="form-group"><input type="submit" class="btn btn-primary" value="Show all orders"></div>
                                </form>
                            </div>
                        </div>

                        <div>
                            <table class="table">
                                <thead>
                                <tr>
                                    <th scope="col">Date from</th>
                                    <th scope="col">Date to</th>
                                    <th scope="col">User</th>
                                    <th scope="col">Hotel</th>
                                    <th scope="col">№ apartment</th>
                                    <th scope="col">Room</th>
                                    <th scope="col">Category</th>
                                    <th scope="col">Apartment price</th>
                                    <th scope="col">Additional service</th>
                                    <th scope="col">Additional service price</th>
                                    <th scope="col">Total</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${orders}" var="order">
                                    <tr>
                                        <td>${order.getFormatDateFrom("dd-MM-yyyy")}</td>
                                        <td>${order.getFormatDateTo("dd-MM-yyyy")}</td>
                                        <td>${order.user.username}</td>
                                        <td>${order.availableApartments.hotel.title}</td>
                                        <td>${order.availableApartments.apartmentNumber}</td>
                                        <td>${order.availableApartments.apartmentTypeNumber.title}</td>
                                        <td>${order.availableApartments.apartmentsCategory.title}</td>
                                        <td>${order.availableApartments.apartmentPrice.value}</td>
                                        <td>${order.additionalApartmentServiceEntity.title}</td>
                                        <td>${order.additionalApartmentServiceEntity.additionalApartmentServicePrice.value}</td>
                                        <td>${order.total}</td>
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

<script type="text/javascript" >
    adminManager.init(null);
</script>