<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

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

                                    <form role="form" enctype="multipart/form-data" class="form-horizontal" action="/booking/${availableApartment.id}" method="post">
                                        <div class="form-group"><h1>Apartment reservation</h1></div>
                                        <div class="form-group">
                                            <label for="hotel">Hotel:</label>
                                            <input id="hotel" type="text" class="form-control" name="hotel" placeholder="Hotel"
                                                   value="${availableApartment.hotel.title}"
                                                   required
                                                   readonly
                                            >
                                        </div>
                                        <div class="form-group">
                                            <label for="apartmentNumber">Apartment №:</label>
                                            <input id="apartmentNumber" type="text" class="form-control" name="apartmentNumber" placeholder="Apartment №"
                                                   value="${availableApartment.apartmentNumber}"
                                                   required
                                                   readonly
                                            >
                                        </div>
                                        <div class="form-group">
                                            <label for="apartmentTypeNumber">Apartment type number:</label>
                                            <input id="apartmentTypeNumber" type="text" class="form-control" name="apartmentTypeNumber" placeholder="Apartment type number"
                                                   value="${availableApartment.apartmentTypeNumber.title}"
                                                   required disabled>
                                        </div>
                                        <div class="form-group">
                                            <label for="apartmentsCategory">Apartments category:</label>
                                            <input id="apartmentsCategory" type="text" class="form-control" name="apartmentsCategory" placeholder="Apartments category"
                                                   value="${availableApartment.apartmentsCategory.title}"
                                                   required disabled>
                                        </div>
                                        <div class="form-group">
                                            <label for="apartmentPrice">Apartment price:</label>
                                            <input id="apartmentPrice" type="text" class="form-control" name="apartmentPrice" placeholder="Apartment price"
                                                   value="${availableApartment.apartmentPrice.value}"
                                                   required disabled>
                                        </div>
                                        <div class="form-group">
                                            <label for="additionalApartmentService">Additional apartment service:</label>
                                            <select id="additionalApartmentService" class="" name="additionalApartmentService" title="Choose additional apartment service...">
                                                <option value="">None</option>
                                                <c:forEach var="additionalApartmentService" items="${additionalApartmentServices}">
                                                    <option value="<c:out value='${additionalApartmentService.id}' />">
                                                        <c:out value="${additionalApartmentService.title}" />
                                                    </option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                        <div class="form-group">
                                            <label for="additionalApartmentServicePrice">Additional apartment service price:</label>
                                            <input id="additionalApartmentServicePrice" type="text" class="form-control" name="additionalApartmentServicePrice" placeholder="Additional apartment service price">
                                        </div>
                                        <div class="form-group">
                                            <label for="user">User:</label>
                                            <select id="user" class="" name="user" title="Choose user..." required>
                                                <option value="">None</option>
                                                <c:forEach var="user" items="${users}">
                                                    <option value="<c:out value='${user.id}' />">
                                                        <c:out value="${user.username}" />
                                                    </option>
                                                </c:forEach>
                                            </select>
                                        </div>

                                        <div class="form-group">
                                            <label for="dateFromBooking">Enter a date and time from:</label>
                                            <input id="dateFromBooking" type="date" name="dateFrom" value="${availableApartment.getFormatDateFrom("yyyy-MM-dd")}">
                                            <input id="oldDateFromBooking" type="hidden" name="dateFrom" value="${availableApartment.getFormatDateFrom("yyyy-MM-dd")}">
                                        </div>
                                        <div class="form-group">
                                            <label for="dateToBooking">Enter a date and time to:</label>
                                            <input id="dateToBooking" type="date" name="dateTo" value="${availableApartment.getFormatDateTo("yyyy-MM-dd")}">
                                            <input id="oldDateToBooking" type="hidden" name="dateTo" value="${availableApartment.getFormatDateTo("yyyy-MM-dd")}">
                                        </div>

                                        <div class="form-group">
                                            <label for="total">Total:</label>
                                            <input id="total" type="text" class="form-control" name="total" placeholder="Total"
                                                   required
                                                    <c:choose>
                                                        <c:when test="${daysBetweenDates > 0}">
                                                            value="${availableApartment.apartmentPrice.value * daysBetweenDates}"
                                                        </c:when>
                                                        <c:otherwise>
                                                            value="${availableApartment.apartmentPrice.value}
                                                        </c:otherwise>
                                                    </c:choose>
                                            >
                                        </div>

                                        <div class="form-group"><input type="submit" class="btn btn-primary booking" value="Save"></div>
                                    </form>
                                </div>
                    </div><!-- /.col-md-12 -->
                </div><!-- /.row -->
            </div><!-- /.container -->
        </section>
    </div><!-- boxed -->
</body>
</html>

<script type="text/javascript" >
    adminManager.init(${configDataJson});
</script>
