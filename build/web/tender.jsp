<%-- 
    Document   : tender
    Created on : Jan 27, 2019, 8:35:29 PM
    Author     : TOLBERT
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/tendering.css">
        <jsp:include page="./includes/global_stylesheets.jsp"/>
        <link href="css/style.css" rel="stylesheet">
        <link href="css/toast_message.css" rel="stylesheet"/>
        <title>tendering</title>
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
        <br><br>
        <form name="tenderform" action="create-tender" id="form1" method="POST" onsubmit="return validate()" enctype="multipart/form-data">
            <table  >
                <thead>
                    <tr>
                        <th style="text-align: center"><b>Create Tender</b></th>

                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td><label for="field1"><span><b>Title</b><span class="required"></span></span></label> </td>
                        <td><input type="text" name="title" class="input-field"/></td>
                    </tr>
                    <tr>
                        <td><b>Tender document</b> </td>
                        <td>
                            <input type="file" id="file1" name="file_upload" accept="image/png, image/jpeg ,.doc,.docx,application/msword,application/vnd.openxmlformats-officedocument.wordprocessingml.document"/>
                        </td> 
                    </tr>
                    <tr>
                        <td>Open date for application</td>
                        <td>
                            <input type="date" name="start_date" required/>
                        </td>

                    </tr>
                    <tr>
                        <td>End date for application</td>
                        <td>
                            <input type="date" name="end_date" required/>
                        </td>

                    </tr>
                    <tr>
                        <td> <input type="submit" value="Clear" /></td>
                        <td ><label><span><input type="submit"  value="Create"  name="create" id="btn" /> </span></label>
                        </td>
                    </tr>
                </tbody>
            </table>
        </form>
        <jsp:include page="./includes/footer.jsp"/>
        <jsp:include page="./includes/scripts.jsp"/>
        <script type="text/javascript" src="js/toast_message.js"></script>
    </body>
</html>
