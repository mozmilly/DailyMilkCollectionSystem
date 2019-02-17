<%-- 
    Document   : add-supplier
    Created on : Feb 11, 2019, 1:13:40 PM
    Author     : enrico
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Supplier</title>
        <jsp:include page="./includes/global_stylesheets.jsp"/>
        <link rel="stylesheet" href="css/login.css" />
        <link href="css/style.css" rel="stylesheet"/>
        <link href="css/toast_message.css" rel="stylesheet"/>
    </head>
    <body style="background-color: #dad4d4">
        <jsp:include page="./includes/toast_message.jsp" />

        <div class="green darken-3 topnav" style="
             top: 0;
             width: 100%;
             ">
            <a class="active" href="/DailyMilkCollectionSystem/">Home</a>
            <c:if test="${sessionScope.loggedIn==true}">
                <a href="account">Account</a>
            </c:if>
            <c:if test="${sessionScope.loggedIn==true  && sessionScope.accountInfo.role.equals('ADMIN')}">
                <a href="create-tender">Tender</a>
            </c:if>
            <c:if test="${sessionScope.accountInfo.role.equals('COLLECTOR')}">
                <a href="supply">Record Supply</a>
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
        
        <!-- Add Supplier Page-->
        <div style="height: 100vh">
            <div class="flex-center flex-column">
                <section>
                    <!--F-->
                    <div class="card card-image" style=" width: 30rem;">
                        <div class="text-white py-5 px-5 z-depth-4">

                            <!--Header-->
                            <div class="text-center">
                                <h2 id="login-header" class="mb-5 mt-4 font-weight-bold"><strong>Add a Supplier</strong></h2>
                            </div>

                            <!--Body-->
                            <form action="add-supplier" method="POST">
                                <div class="md-form">
                                    <input type="number" id="nationalId" class="form-control" name="nationalId" autocomplete="false" required>
                                    <label for="nationalId">National Id</label>
                                </div>
                                <div class="md-form">
                                    <input type="text" id="firstName" class="form-control" name="firstName" autocomplete="false" required>
                                    <label for="firstName">First Name</label>
                                </div>
                                <div class="md-form">
                                    <input type="text" id="lastName" class="form-control" name="lastName" autocomplete="false" required>
                                    <label for="lastName">Last Name</label>
                                </div>
                                <div class="md-form">
                                    <input type="number" id="phone" class="form-control" name="phone" autocomplete="false" required>
                                    <label for="phone">Phone</label>
                                </div>
                                <div class="md-form">
                                    <input type="email" id="email" class="form-control" name="email" autocomplete="false" required>
                                    <label for="email">Email</label>
                                </div>
                                
                                <!--Grid row-->
                                <div class="row d-flex align-items-center mb-4">

                                    <!--Grid column-->
                                    <div class="text-center mb-3 col-md-12">
                                        <button type="submit" class="btn btn-block btn-rounded z-depth-1 navbarColor"><b>Add Supplier</b></button>
                                    </div>

                                </div>
                            </form>
                            <!--Grid row-->

                        </div>
                    </div>
                    <!--/Form without header-->

                </section>
                <!-- End of section-->
            </div>
        </div>
        <!--End of add supplier page-->
        
        <jsp:include page="./includes/footer.jsp"/>
        <jsp:include page="./includes/scripts.jsp"/>
        <script type="text/javascript" src="js/toast_message.js"></script>
    </body>
</html>
