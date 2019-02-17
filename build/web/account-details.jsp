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

        <!-- Title -->
        <h2 class="card-title h2">Your Account Details</h2>
        <!-- Subtitle -->
        <p class="blue-text my-4 font-weight-bold">You can change your login password by clicking on the edit button</p>

        <!-- Grid row -->
        <div class="row d-flex justify-content-center">

          <!-- Grid column -->
          <div class="col-xl-7 pb-2">
              <jsp:useBean id="accountInfo" scope="session" class="beans.AccountInfoBean"/>
              <p class="card-text">
                  <label for="name" style="font-weight: bold">Username <i class="far fa-user"></i></label>
                  <span id="name"><jsp:getProperty name="accountInfo" property="username"/></span>
              </p>
              <p class="card-text">
                  <label for="number" style="font-weight: bold">Id Number <i class="far fa-id-card"></i> </label>
                  <span id="number"><jsp:getProperty name="accountInfo" property="idNo"/></span>
              </p>

          </div>
          <!-- Grid column -->

        </div>
        <!-- Grid row -->

        <hr class="my-4">

        <div class="pt-2">
          <button id="edit" type="button" class="btn btn-outline-primary waves-effect">change password <i class="fas fa-user-edit"></i></button>
        </div>

     </div>
    <!-- Jumbotron -->
        
    <div id="editForm" style="height: 100vh; display: none;">
        <div class="flex-center flex-column">
            <section>
                <div class="card card-image" style=" width: 30rem;">
                    <div class="text-white py-5 px-5 z-depth-4">

                        <!--Header-->
                        <div class="text-center">
                            <h2 id="login-header" class="mb-5 mt-4 font-weight-bold"><strong>Change Password</strong></h2>
                        </div>

                        <!--Body-->
                        <form action="change-details" method="POST">
                            <div class="md-form">
                                <input type="password" id="old-password" class="form-control" name="oldPassword" autocomplete="false" required>
                                <label for="old-password">Old password</label>
                            </div>

                            <div class="md-form">
                                <input type="password" id="new-password1" class="form-control" name="newPassword1" autocomplete="false" required>
                                <label for="new-password1">New password</label>
                            </div>

                            <div class="md-form">
                                <input type="password" id="new-password2" class="form-control" name="newPassword2" autocomplete="false" required>
                                <label for="new-password2">Confirm password</label>
                            </div>

                            <!--Grid row-->
                            <div class="row d-flex align-items-center mb-4">

                                <!--Grid column-->
                                <div class="text-center mb-3 col-md-12">
                                    <button id="update" type="submit" class="btn btn-block btn-rounded z-depth-1 navbarColor" disabled><b>Update</b></button>
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
        
        <jsp:include page="./includes/footer.jsp"/>
        <jsp:include page="./includes/scripts.jsp"/>
        <script type="text/javascript" src="js/display-form.js"></script>
        <script type="text/javascript" src="js/edit-account.js"></script>
        <script type="text/javascript" src="js/toast_message.js"></script>
    </body>
</html>
