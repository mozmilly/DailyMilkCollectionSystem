<%-- 
    Document   : welcome
    Created on : Jan 23, 2019, 11:42:12 AM
    Author     : AMO
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.1/css/all.css">
        <title>DAIRY MILK </title>
        <jsp:include page="./includes/global_stylesheets.jsp"/>
        <link href="css/style.css" rel="stylesheet">
        <link href="css/toast_message.css" rel="stylesheet"/>
    </head>

    <body>
        <jsp:include page="./includes/toast_message.jsp" />
        <div class="green darken-3 topnav ">
            <a class="active" href="/DailyMilkCollectionSystem/">Home</a>
            <c:if test="${sessionScope.loggedIn==false || sessionScope.loggedIn==null}">
                <a href="#about">About Us</a>
                <a href="Contactus.jsp">Contact Us</a>
            </c:if>
            <c:if test="${sessionScope.loggedIn==true}">
                <a href="account">Account</a>
                <!--<a href="/SupplyRecords">Supply Records</a>-->
            </c:if>
            <c:if test="${sessionScope.accountInfo.role.equals('COLLECTOR')}">
                <a href="supply">Record Supply</a>
            </c:if>
            <c:if test="${sessionScope.accountInfo.role.equals('ADMIN')}">
                <a href="create-tender">Tender</a>
            </c:if>
            <c:if test="${sessionScope.accountInfo.role.equals('ADMIN')}">
                <a href="add-supplier">Add Supplier</a>
            </c:if>
            <c:if test="${sessionScope.loggedIn==false || sessionScope.loggedIn==null}">   
                <div class="login-container">
                    <a href="login">Login</a>
                </div>
            </c:if>
            <c:if test="${sessionScope.loggedIn==true}">
                <div class="login-container">
                    <a href="logout">Logout</a>
                </div>
            </c:if>
        </div>
        <div id="carouselExampleSlidesOnly" class="carousel slide" data-ride="carousel">
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img class="d-block w-100" src="img/img1.jpg" height=600px>
                </div>
            </div>
        </div>
        <jsp:include page="includes/footer.jsp"/>
        <jsp:include page="./includes/scripts.jsp"/>
        <script type="text/javascript" src="js/toast_message.js"></script>
    </body>
</html>
