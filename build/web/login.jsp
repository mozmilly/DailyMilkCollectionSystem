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
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/style.min.css">
        <link rel="stylesheet" href="css/mdb.min.css">
        <link rel="stylesheet" href="css/mdb.lite.min.css">
        
    </head>
    <body>
        
        <div>
            <c:if test="${requestScope.error != null}">
                <p>${requestScope.error}</p>
            </c:if>
            <c:if test="${requestScope.success != null}">
                <p>${requestScope.success}</p>
            </c:if>
        </div>
        <!-- Default form register -->
        <<form action="login" method="POST">
            Username: <input type="text" name="username" required><br>
            Password: <input type="password" name="password" required><br>
            <input type="submit" value="Login">
        </form>
<!-- Default form register -->
        
        <script type="text/javascript" src="js/jquery-3.3.1.min.js">
        <script type="text/javascript" src="js/bootstrap.min.js">
        <script type="text/javascript" src="js/mdb.min.js">
        <script type="text/javascript" src="js/popper.min.js">
        
    </body>
</html>
