<%-- 
Document   : ErrorPage
    Created on : May 30, 2018, 1:35:09 PM
    Author     : lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error Page</title>
        <link href="css/Home.css" rel="stylesheet" type="text/css"/>
        <link href="css/TakeQuiz.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="top"></div>
        <div class="wrapper">
            <%@include  file="WEB-INF/Header.jsp" %>
            <div class="main">
                <h1>Access denied</h1>
                <p>Only teacher can use this function!</p>
            </div>
        </div>
    </body>
</html>
