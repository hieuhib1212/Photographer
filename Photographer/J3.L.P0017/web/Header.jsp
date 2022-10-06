<%-- 
    Document   : Header
    Created on : Feb 22, 2021, 8:11:24 AM
    Author     : Hiệu Bùi
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Header Page</title>
        <link href="css/header.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="nav">
            <div class="nav-link">
                <ul>
                    <li>
                        <a class="${active=="0"?"activeMenu":""}" href="HomeController">My front page</a> </li>
                    </li>
                    <c:forEach items="${top3}" var="top3">
                        <li>
                            <a class="${active==top3.id?"activeMenu":""}" href="GalleryController?gid=${top3.id}">${top3.title}</a>
                        </li>
                    </c:forEach>
                    <li>
                        <a class="${active=="4"?"activeMenu":""}" href="ContactController">Contact</a>
                    </li>
                </ul>
            </div>
        </div>
        <div class="header">
            <div class="header-inner">
                <div class="image">
                </div>
                <div class="title">
                    PHOTOGRAPHER
                </div>
                <div class="subtitle">
                    Welcome to this website
                </div>
            </div>
        </div>
    </body>
</html>
