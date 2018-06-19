<%-- 
    Document   : DoQuiz
    Created on : May 24, 2018, 12:34:32 AM
    Author     : lenovo
--%>
<%@page import="javax.script.ScriptEngineManager"%>
<%@page import="javax.script.ScriptEngine"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Quiz"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Do Quiz</title>
        <link href="${pageContext.servletContext.contextPath}/css/Home.css" rel="stylesheet" type="text/css"/>
        <link href="${pageContext.servletContext.contextPath}/css/TakeQuiz.css" rel="stylesheet" type="text/css"/>
        <link href="${pageContext.servletContext.contextPath}/css/DoQuiz.css" rel="stylesheet" type="text/css"/>
    </head>
    <body onload="countdown();">
        <div class="top"></div>
        <div class="wrapper">
            <%@include  file="Header.jsp" %>
            <div class="main">
                <p>Welcome <span>${sessionScope.username}</span></p>
                <form action="takequiz" method="POST">
                    <p class="lblTimer">Time remaining <span id="timer"></span></p>
                    <input type="hidden" id="currentQuiz" name="currentQuiz" value="${currentQuiz}"/>
                    <p>${q.content}</p>
                    <div>
                        <input type="checkbox" class="options" value="${q.optA}"/>
                        <span class="opt">${q.optA}</span>
                    </div>
                    <div>
                        <input type="checkbox" class="options" value="${q.optB}"/>
                        <span class="opt">${q.optB}</span>
                    </div>
                    <div>
                        <input type="checkbox" class="options" value="${q.optC}"/>
                        <span class="opt">${q.optC}</span>
                    </div>
                    <div>
                        <input type="checkbox" class="options" value="${q.optD}"/>
                        <span class="opt">${q.optD}</span>
                    </div>
                    <input type="submit" value="Next"/>
                    <input type="hidden" name="result" value="" id="result"/>
                </form>
            </div>
        </div>
        <script src="${pageContext.servletContext.contextPath}/js/DoQuiz.js" type="text/javascript"></script>
    </body>
</html>