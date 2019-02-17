<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
    <c:if test="${requestScope.error != null}">
        <div id="snackbar" style="background-color: #ff0000">${requestScope.error}</div>
    </c:if>
    <c:if test="${requestScope.success != null}">
        <div id="snackbar" style="background-color: #2e7d32">${requestScope.success}</div>
    </c:if>
</div>