<%--
    Document   : login
    Created on : May 17, 2018, 11:52:27 PM
    Author     : maxy
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/style.min.css">
        <link rel="stylesheet" href="css/mdb.min.css">
        <link rel="stylesheet" href="css/mdb.lite.min.css">
        
    </head>
    <body>
   
        <!--Navbar -->
<nav class="mb-1 navbar navbar-expand-lg navbar-dark green darken-3">
  <a class="navbar-brand" href="#">Dairy Milk</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent-555"
    aria-controls="navbarSupportedContent-555" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarSupportedContent-555">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="#">Home
          <span class="sr-only">(current)</span>
        </a>
      </li>
    </ul>
    <ul class="navbar-nav ml-auto nav-flex-icons">
      <li class="nav-item avatar">
        <a class="nav-link p-0" href="#">
            <img src="img/cow.jfif" class="rounded-circle z-depth-0" alt="avatar image" height="35">
        </a>
      </li>
    </ul>
  </div>
</nav>
<!--/.Navbar -->
        <div>
            <c:if test="${requestScope.error != null}">
                <p>${requestScope.error}</p>
            </c:if>
            <c:if test="${requestScope.success != null}">
                <p>${requestScope.success}</p>
            </c:if>
        </div>
        <!-- Default form register -->
        <form class="text-center border border-light p-5" action="login" method="post">

    <p class="h4 mb-4">Apply Contract</p>

    <div class="form-row mb-4">
        <div class="col">
            <!-- First name -->
            <input type="text" id="defaultRegisterFormFirstName" class="form-control" placeholder="First name">
        </div>
        <div class="col">
            <!-- Last name -->
            <input type="text" id="defaultRegisterFormLastName" class="form-control" placeholder="Last name">
        </div>
    </div>

    <!-- E-mail -->
    <input type="email" id="defaultRegisterFormEmail" class="form-control mb-4" placeholder="E-mail">

    <!-- National Id -->
    <input type="number" id="nationalId" class="form-control" placeholder="National Id">
    <br>

    <!-- Phone number -->
    <input type="text" id="defaultRegisterPhonePassword" class="form-control" placeholder="Phone number" aria-describedby="defaultRegisterFormPhoneHelpBlock">
    
    <br>
   
    <div class="input-group">
        <div class="input-group-prepend">
             <span class="input-group-text" id="inputGroupFileAddon01">Upload</span>
         </div>
         <div class="custom-file">
            <input type="file" class="custom-file-input" id="inputGroupFile01" aria-describedby="inputGroupFileAddon01">
            <label class="custom-file-label" for="inputGroupFile01">Upload Tender Document</label>
         </div>
    </div>

    <br>
    <!-- Sign up button -->
    <button class="btn green darken-3 my-4 btn-block" type="submit">Apply</button>


</form>
<!-- Default form register -->
        
        <script type="text/javascript" src="js/jquery-3.3.1.min.js">
        <script type="text/javascript" src="js/bootstrap.min.js">
        <script type="text/javascript" src="js/mdb.min.js">
        <script type="text/javascript" src="js/popper.min.js">
        
    </body>
</html>
