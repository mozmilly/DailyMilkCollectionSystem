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
        <jsp:include page="./includes/global_stylesheets.jsp"/>
    </head>
    <body>
        <jsp:include page="./includes/nab-bar.jsp"/>
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
                    <input type="text" id="defaultRegisterFormFirstName" name="firstname" class="form-control" placeholder="First name" required>
                </div>
                <div class="col">
                    <!-- Last name -->
                    <input type="text" id="defaultRegisterFormLastName" name="lastname" class="form-control" placeholder="Last name" required>
                </div>
            </div>

            <!-- E-mail -->
            <input type="email" id="defaultRegisterFormEmail" name="email" class="form-control mb-4" placeholder="E-mail" required>

            <!-- National Id -->
            <input type="number" id="nationalId" name="id" class="form-control" placeholder="National Id" required oninput="javascript: if (this.value.length > this.maxLength) this.value = this.value.slice(0, this.maxLength);" maxlength="8">
            <br>
            <!-- Phone number -->
            <input type="number" id="phoneNumber" name="phonenumber" class="form-control" placeholder="Phone Number" required oninput="javascript: if (this.value.length > this.maxLength) this.value = this.value.slice(0, this.maxLength);" maxlength="10">
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
