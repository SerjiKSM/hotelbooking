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

                            <h1>List of available apartments</h1>

                            <div class="block-filter">
                                <div class="filter-date">
                                    <form role="form" enctype="multipart/form-data" class="form-horizontal" action="/find-available-apartment-by-dates" method="post">
                                        <div class="form-group">
                                            <label for="dateFrom">Date from:</label>
                                            <input id="dateFrom" type="date" name="dateFrom" required>
                                        </div>
                                        <div class="form-group">
                                            <label for="dateTo">Date to:</label>
                                            <input id="dateTo" type="date" name="dateTo" required>
                                        </div>

                                        <div class="form-group"><input type="submit" class="btn btn-primary booking" value="Date filter"></div>
                                    </form>
                                </div>

                                <div class="filter-category">
                                    <form role="form" enctype="multipart/form-data" class="form-horizontal" action="/filter-category" method="post">
                                        <div class="form-group">
                                            <label for="filterCategory">Category:</label>
                                            <select id="filterCategory" class="" name="filterCategory" title="Choose category..." required>
                                                <option value="">None</option>
                                                <c:forEach var="category" items="${categories}">
                                                    <option value="<c:out value='${category.id}' />">
                                                        <c:out value="${category.title}" />
                                                    </option>
                                                </c:forEach>
                                            </select>
                                        </div>

                                        <div class="form-group"><input type="submit" class="btn btn-primary" value="Category filter"></div>
                                    </form>
                                </div>

                                <div class="filter-all-category">
                                    <form role="form" enctype="multipart/form-data" class="form-horizontal" action="/list-available-numbers" method="post">
                                        <div class="form-group"><input type="submit" class="btn btn-primary" value="Show all apartments"></div>
                                    </form>
                                </div>
                            </div>

                            <div>
                                <table class="table">
                                    <thead>
                                    <tr>
                                        <th scope="col">Date from</th>
                                        <th scope="col">Date to</th>
                                        <th scope="col">Hotel</th>
                                        <th scope="col">№ apartment</th>
                                        <th scope="col">Room</th>
                                        <th scope="col">Category</th>
                                        <th scope="col">Price</th>
                                        <th scope="col">Action</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${availableApartments}" var="availableApartment">
                                        <tr>
                                            <td>${availableApartment.getFormatDateFrom("dd-MM-yyyy")}</td>
                                            <td>${availableApartment.getFormatDateTo("dd-MM-yyyy")}</td>
                                            <td>${availableApartment.hotel.title}</td>
                                            <td>${availableApartment.apartmentNumber}</td>
                                            <td>${availableApartment.apartmentTypeNumber.title}</td>
                                            <td>${availableApartment.apartmentsCategory.title}</td>
                                            <td>${availableApartment.apartmentPrice.value}</td>
                                            <td>
                                                <a class="btn btn-primary" href="/form-reservation?id=${availableApartment.id}">Reservation</a>
                                            </td>
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