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
        <title>Take Quiz Page</title>
        <link href="${pageContext.servletContext.contextPath}/css/Home.css" rel="stylesheet" type="text/css"/>
        <link href="${pageContext.servletContext.contextPath}/css/TakeQuiz.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="top"></div>
        <div class="wrapper">
            <%@include file="Header.jsp" %>
            <div class="main">
                <p>Welcome <span class="blue-color">${username}</span></p>
                <p>Enter number of questions:</p>
                <form action="takequiz" id="frm1" method="POST">
                    <div>
                        <input type="number" name="chosenQuizzes" size="5" required="required"/>
                    </div>
                    <div>
                        <input type="submit" value="Start"/>
                    </div>
                </form>
                <div class="error">${error}</div>
            </div>
        </div>
    </body>
</html>
