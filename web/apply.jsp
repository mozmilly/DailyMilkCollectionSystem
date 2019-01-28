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
        <title>Apply</title>
        <jsp:include page="./includes/global_stylesheets.jsp"/>
    </head>
    <body>
        <jsp:include page="./includes/navbar.jsp"/>
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
        <jsp:include page="./includes/footer.jsp"/>
        <jsp:include page="./includes/scripts.jsp"/>
</body>
</html>
