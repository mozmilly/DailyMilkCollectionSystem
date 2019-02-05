<%-- 
    Document   : test
    Created on : 30-Jan-2019, 10:49:36
    Author     : moses
--%>

<%@page import="java.util.Enumeration"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            Enumeration parameterNames = request.getParameterNames();
            while (parameterNames.hasMoreElements()) {
                String parameterName = (String) parameterNames.nextElement();
                String parameterValue = request.getParameter(parameterName);
        %>
                <%= parameterName%> has value 
                <%= parameterValue%>. <br>
        <% }
        %>
    </body>
</html>
