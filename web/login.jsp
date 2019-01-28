<%--
    Document   : login
    Created on : May 17, 2018, 11:52:27 PM
    Author     : enrico
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <jsp:include page="./includes/global_stylesheets.jsp"/>
        <link rel="stylesheet" href="css/login.css" />
        <link href="css/style.css" rel="stylesheet">
    </head>
    <body style="background-color: #dad4d4">
        <div>
            <c:if test="${requestScope.error != null}">
                <p>${requestScope.error}</p>
            </c:if>
            <c:if test="${requestScope.success != null}">
                <p>${requestScope.success}</p>
            </c:if>
        </div>

        <div class="green darken-3 topnav" style="
             position: fixed;
             top: 0;
             width: 100%;
             ">
            <a class="active" href="/DailyMilkCollectionSystem/">Home</a>
            <a href="#contact">Contact Us</a>
        </div>

        <!-- Portal login page-->
        <div style="height: 100vh">
            <div class="flex-center flex-column">
                <!--Login page starts here-->
                <section>

                    <!--F-->
                    <div class="card card-image" style=" width: 30rem;">
                        <div class="text-white py-5 px-5 z-depth-4">

                            <!--Header-->
                            <div class="text-center">
                                <h2 id="login-header" class="mb-5 mt-4 font-weight-bold"><strong>MaziwaMob Collection Portal</strong></h2>
                            </div>

                            <!--Body-->
                            <form action="login" method="POST">
                                <div class="md-form">
                                    <input type="text" id="username" class="form-control" name="username" autocomplete="false">
                                    <label for="username">Username</label>
                                </div>

                                <div class="md-form">
                                    <input type="password" id="password" class="form-control" name="password" autocomplete="false">
                                    <label for="password">Your password</label>
                                </div>

                                <!--Grid row-->
                                <div class="row d-flex align-items-center mb-4">

                                    <!--Grid column-->
                                    <div class="text-center mb-3 col-md-12">
                                        <button type="submit" class="btn btn-block btn-rounded z-depth-1 navbarColor"><b>Login</b></button>
                                    </div>

                                </div>
                            </form>
                            <!--Grid row-->

                            <!--Grid column-->
                            <div class="col-md-12">
                                <p class="font-small d-flex justify-content-end"><a href="/DailyMilkCollectionSystem/" class="ml-1 font-weight-bold navColorText">Return Home</a></p>
                            </div>
                            <!--Grid column-->

                        </div>
                    </div>
                    <!--/Form without header-->

                </section>
                <!-- End of section-->
            </div>
        </div>
        <!--End of login page-->

        <jsp:include page="./includes/footer.jsp"/>
        <jsp:include page="./includes/scripts.jsp"/>
    </body>
</html>
