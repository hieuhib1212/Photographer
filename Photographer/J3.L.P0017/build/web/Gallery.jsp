<%-- 
    Document   : Gallery
    Created on : Feb 22, 2021, 8:10:22 AM
    Author     : Hiệu Bùi
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gallery Page</title>
        <link href="css/home.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <jsp:include page="Header.jsp"/>
            <div class="main">
                <div class="left">
                    <c:if test="${error1!=null}">
                        <h3>${error1}</h3>
                    </c:if>
                    <c:if test="${error1==null}"> 
                        <div class="about">
                            <h3>${gallery.title}</h3>
                        </div>
                        <c:if test="${error!=null}">
                            <h3>${error}</h3>
                        </c:if>
                        <c:if test="${error==null}">
                            <div class="slideshow-container">
                                <c:forEach items="${lstImage}" var="o">
                                    <div class="mySlides fade">
                                        <img src="${imagePath}${o.img_url}" style="width:100%">
                                    </div>
                                </c:forEach>
                                <a class="prev" onclick="plusSlides(-1)">&#10094;</a>
                                <a class="next" onclick="plusSlides(1)">&#10095;</a>

                            </div>
                        </c:if>
                        <div class="contentGalery">
                            <ul>
                                <c:forEach items="${lstImage}" var="o" varStatus="loop">
                                    <li>
                                        <a onclick="currentSlide(${loop.index + 1})">
                                            <img src="${imagePath}${o.img_url}">
                                        </a>
                                    </li>
                                </c:forEach>
                            </ul>
                            <p style="color: white">${gallery.view} views</p>
                            <div class="paging">
                                <c:if test="${endPage < 1}">
                                    <h3>Not Found!!</h3>
                                </c:if>
                                <c:if test="${endPage > 1}">
                                    <c:forEach begin="1" end="${endPage}" var="i">
                                        <a class="${i==index?"active":""}" href="GalleryController?index=${i}&gid=${gid}">${i}</a>
                                    </c:forEach>
                                </c:if>
                            </div>

                        </div>
                    </c:if>
                </div>
                <div class="right">
                    <jsp:include page="Right.jsp"/>
                </div>
            </div>
        </div>
        <jsp:include page="Footer.jsp"/>
    </body>
    <script>
        var slideIndex = 1;
        showSlides(slideIndex);
//        setInterval(function(){ showSlides(++slideIndex); }, 3000);
        function plusSlides(n) {
            showSlides(slideIndex += n);
        }

        function currentSlide(n) {
            showSlides(slideIndex = n);
        }

        function showSlides(n) {
            var i;
            var slides = document.getElementsByClassName("mySlides");
            if (n > slides.length) {
                slideIndex = 1;
            }
            if (n < 1) {
                slideIndex = slides.length;
            }
            for (i = 0; i < slides.length; i++) {
                slides[i].style.display = "none";
            }
            slides[slideIndex - 1].style.display = "block";
            setTimeout(function(){ showSlides(++slideIndex); }, 3000)
        }
        
    </script>
</html>
