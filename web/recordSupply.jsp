<%-- 
    Document   : addsupplier
    Created on : Feb 4, 2019, 3:27:29 PM
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
        <script src="validation.js"></script>
        <title>tendering</title>
    </head>
    <body style="background-color: #dad4d4">
        <div class="green darken-3 topnav" style="
             position: fixed;
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
        <form action="supply" id="form1" method="POST">
            <table  >
                <thead>
                    <tr>
                        <th>     </th>
                        <th style=" float:right;  font-size: 24px" class="mb-5 mt-4 font-weight-bold"><strong>RECORD SUPPLY</strong></th>

                    </tr>
                </thead> 
                <tbody>
                    <tr>
                        <td><label for="field1"><span><strong>Id Number </strong><span class="required"></span></span></label> </td>

                        <td><input type="number" name="id" class="input-field"  required /></td>
                    </tr>
                    <tr>
                        <td><label for="field1"><span><strong>Amount  </strong><span class="required"></span></span></label> </td>

                        <td><input type="text" name="amount" class="input-field"  required /></td>
                    </tr>
                    <tr>
                        <td><label for="field1"><span><strong>Quality </strong><span class="required"></span></span></label> </td>
                        <td>Good<input type="radio" name="quality"   value="Good"/></td>
                        <td>Bad<input type="radio" name="quality" value="Bad" /></td>

                    </tr>

                    <tr>
                        <td ><label><span><input type="reset"  value="Clear"  name="create" style="background: limegreen " /> </span></label>
                        </td>
                        <td ><label><span><input type="submit"  value="Create"  name="create" id="btn" /> </span></label>
                        </td>
                    </tr>
                </tbody>
            </table>
        </form>
        <br><br>
        <jsp:include page="./includes/footer.jsp"/>
    </body>
</html>
