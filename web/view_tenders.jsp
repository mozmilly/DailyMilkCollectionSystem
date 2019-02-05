<%-- 
    Document   : all-applicant
    Created on : Jan 23, 2019, 11:18:11 AM
    Author     : Mentor
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Show all applicants</title>
    </head>
    <body>
         <c:forEach var="tender" items="${tenders}">
            
           Title: ${tender.title}} <br>
           Start date: ${tender.start_date} <br>  
           docs : ${tender.document} <br />
            -------------------------------------<br>
        </c:forEach>
    </body>
</html>
