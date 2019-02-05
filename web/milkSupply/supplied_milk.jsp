<%-- 
    Document   : supplied_milk
    Created on : Jan 30, 2019, 10:49:56 AM
    Author     : Mentor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Supplied Milk</title>
         <jsp:include page="./includes/global_stylesheets.jsp"/>
    </head>
    <body>
       <!--NavBar here-->
       
       <!--Display milk supply history here -->date,amount supplied,remarks etc-->
      
           <!--Table-->
        <table class="table table-hover table-fixed">

          <!--Table head-->
          <thead>
            <tr>
              <th>No.</th>
              <th>Date Supplied</th>
              <th>Amount Supplied(in Litres)</th>
              <th>Remarks/Status</th>
            
            </tr>
          </thead>
          <!--Table head-->

          <!--Table body-->
          <tbody>
            <c:forEach var="supply" items="${milkSupply}">
                 <tr>
                   <th scope="row"></th>
                   <td>${supply.dateSupplied}</td>
                   <td>${supply.milkAmountSupplied}</td>
                   <td>${supply.remarks}</td>                 
                 </tr>
             </c:forEach>
          </tbody>
          <!--Table body-->

        </table>
        <!--Table-->
    
       
        <jsp:include page="./includes/scripts.jsp"/>
    </body> 
   

</html>
