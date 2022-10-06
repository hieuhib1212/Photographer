<%-- 
    Document   : HomePage
    Created on : Feb 22, 2021, 8:03:19 AM
    Author     : Hiệu Bùi
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
        <link href="css/home.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>   
        <div class="container">
            <jsp:include page="Header.jsp"></jsp:include>
            <div class="main">
                <div class="left">
                    <div class="image">
                        <img src="${imagePath}${contact.main_image}"/>
                    </div>
                    <div class="description">
                        ${contact.short_description}
                    </div>
                    <div class="content">
                        <c:if test="${error!=null}">
                            <h3>${error}</h3>
                        </c:if>
                        <c:if test="${error==null}">
                            <ul>
                                <c:forEach items="${listGallery}" var="o" >
                                    <li>
                                        <div class="image">
                                            <img src="${imagePath}${o.image}" alt=""/>
                                        </div>
                                        <h4>
                                            <a href="GalleryController?gid=${o.id}">${o.title}</a>
                                        </h4>
                                        <p>
                                            ${o.description}
                                        </p>
                                    </li>
                                </c:forEach>
                            </ul>
                            <div class="paging">
                                <c:if test="${endPage < 1}">
                                    <h3>Not Found!!</h3>
                                </c:if>
                                <c:if test="${endPage > 1}">
                                    <c:forEach begin="1" end="${endPage}" var="i">
                                        <a class="${i==index?"active":""}" href="HomeController?index=${i}">${i}</a>
                                    </c:forEach>
                                </c:if>
                            </div>
                        </c:if>
                    </div>
                    <div class="about">
                        <h3>
                            About me
                        </h3>
                    </div>
                    <div class="about-detail">
                        ${contact.about}
                    </div>
                </div>
                <div class="right">
                    <jsp:include page="Right.jsp"></jsp:include>
                </div>
            </div>
        </div>
        <jsp:include page="Footer.jsp"></jsp:include>
    </body>
</html>
