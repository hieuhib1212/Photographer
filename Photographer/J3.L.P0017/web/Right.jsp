<%-- 
    Document   : Right
    Created on : Feb 22, 2021, 8:11:44 AM
    Author     : Hiệu Bùi
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/right.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="header-right">
            Share this page
        </div>
        <div class="social">
            <ul>
                <c:forEach items="${share}" var="share">
                    <li>
                        <img src="images/${share.icon_source}"> <a href="${share.link}" >${share.title}</a>
                    </li>
                </c:forEach>
            </ul>
        </div>
    </body>
</html>
