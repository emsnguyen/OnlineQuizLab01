<%-- 
    Document   : ManageQuiz
    Created on : May 24, 2018, 12:05:44 AM
    Author     : lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Make Quiz Success</title>
        <link href="${pageContext.servletContext.contextPath}/css/Home.css" rel="stylesheet" type="text/css"/>
        <link href="${pageContext.servletContext.contextPath}/css/TakeQuiz.css" rel="stylesheet" type="text/css"/>
        <link href="${pageContext.servletContext.contextPath}/css/ManageQuiz.css" rel="stylesheet" type="text/css"/>
        <link href="${pageContext.servletContext.contextPath}/css/MakeQuizSuccess.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="top"></div>
        <div class="wrapper">
            <%@include file="Header.jsp" %>
            <div class="main">
                <h3>A new quiz has been successfully created!</h3>
                <table border="1">
                    <tr>
                        <td>Content</td>
                        <td>${q.content}</td>
                    </tr>
                    <tr>
                        <td>Option 1</td>
                        <td>${q.optA}</td>
                    </tr>
                    <tr>
                        <td>Option 2</td>
                        <td>${q.optB}</td>
                    </tr>
                    <tr>
                        <td>Option 3</td>
                        <td>${q.optC}</td>
                    </tr>
                    <tr>
                        <td>Option 4</td>
                        <td>${q.optD}</td>
                    </tr>
                </table>
            </div>
        </div>
    </body>
</html>
