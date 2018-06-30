<%-- 
    Document   : TakeQuiz
    Created on : May 24, 2018, 12:05:44 AM
    Author     : lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Test Result Page</title>
        <link href="${pageContext.servletContext.contextPath}/css/Home.css" rel="stylesheet" type="text/css"/>
        <link href="${pageContext.servletContext.contextPath}/css/TakeQuiz.css" rel="stylesheet" type="text/css"/>
        <script src="${pageContext.servletContext.contextPath}/js/TestResult.js" type="text/javascript"></script>
        <link href="${pageContext.servletContext.contextPath}/css/TestResult.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="top"></div>
        <div class="wrapper">
            <%@include file="Header.jsp" %>
            <div class="main">
                <div class="score">
                    Your score ${fResult}<span class="blue-color"> (${percentResult}%) - ${sResult}</span>
                </div>
                <div>
                    Take another test
                    <button onclick="takeTest();">Start</button>
                </div>
            </div>
        </div>
    </body>
</html>
