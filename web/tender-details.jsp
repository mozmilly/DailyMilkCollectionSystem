<%-- 
    Document   : account-details
    Created on : Feb 4, 2019, 3:10:26 PM
    Author     : enrico
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Account</title>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.1/css/all.css"/>
        <jsp:include page="./includes/global_stylesheets.jsp"/>
        <link href="css/style.css" rel="stylesheet"/>
        <link rel="stylesheet" href="css/login.css" />
        <link href="css/toast_message.css" rel="stylesheet"/>
        <style>
            p > span{
                padding-left: 30px;
            }
        </style>
    </head>
    <body>
        <jsp:include page="./includes/toast_message.jsp" />
        <div class="green darken-3 topnav ">
            <a class="active" href="/DailyMilkCollectionSystem/">Home</a>
            <c:if test="${sessionScope.loggedIn==true && sessionScope.accountInfo.role.equals('ADMIN')}">
                <a href="create-tender">Tender</a>
            </c:if>
            <c:if test="${sessionScope.accountInfo.role.equals('COLLECTOR')}">
                <a href="supply">Record Supply</a>
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

        <!-- Jumbotron -->
        <div class="jumbotron text-center card-image" style=" width: 30rem; margin: 15px auto;">
            <jsp:useBean id="tenderBean" scope="session" class="beans.TenderBean"/>
            <!-- Title -->
            <h2 class="card-title h2">Tender Details</h2>
            <!-- Subtitle -->
            <p class="blue-text my-4 font-weight-bold">Displays details of the current tender</p>

            <!-- Grid row -->
            <div class="row d-flex justify-content-center">

                <!-- Grid column -->
                <div class="col-xl-7 pb-2">
                    <p class="card-text">
                        <label for="title" style="font-weight: bold">Title</label>
                        <span id="title"><jsp:getProperty name="tenderBean" property="title"/></span>
                    </p>
                    <p class="card-text">
                        <label for="document" style="font-weight: bold">Document</label>
                        <span id="document"><a href="tender-document" target="_blank">click to view</a></span>
                    </p>
                    <p class="card-text">
                        <label for="start" style="font-weight: bold">Start Date</label>
                        <span id="start"><jsp:getProperty name="tenderBean" property="start_date"/></span>
                    </p>
                    <p class="card-text">
                        <label for="end" style="font-weight: bold">End Date</label>
                        <span id="end"><jsp:getProperty name="tenderBean" property="end_date"/></span>
                    </p>

                </div>
                <!-- Grid column -->

            </div>
            <!-- Grid row -->

        </div>
        <!-- Jumbotron -->


        <jsp:include page="./includes/footer.jsp"/>
        <jsp:include page="./includes/scripts.jsp"/>
        <script type="text/javascript" src="js/toast_message.js"></script>
    </body>
</html>
