<%-- 
    Document   : index
    Created on : Jan 4, 2019, 2:50:46 PM
    Author     : enrico
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <jsp:include page="./includes/global_stylesheets.jsp"/>
    </head>
    <body>
        <jsp:include page="./includes/nab-bar.jsp"/>

        <form action="display" method="GET">
            <input type="submit" name="showAllApplication" value="Show">
        </form>
        <jsp:include page="./includes/scripts.jsp"/>
        <jsp:include page="./includes/footer.jsp"/>
    </body>
</html>
