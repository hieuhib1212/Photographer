<%-- 
    Document   : Footer
    Created on : Feb 22, 2021, 8:11:31 AM
    Author     : Hiệu Bùi
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Footer Page</title>
        <link href="css/footer.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="footer">
            <div class="link">
                <a href="#">Created with SimpleSite</a>
                <c:forEach items="${view}" var="o">
                    <span class="count_viewer">${o}</span>
                </c:forEach>
            </div>
        </div>
    </body>
</html>
