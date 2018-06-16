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
        <script src="${pageContext.servletContext.contextPath}/js/TakeQuiz.js" type="text/javascript"></script>
    </head>
    <body>
        <div class="top"></div>
        <div class="wrapper">
            <%@include file="Header.jsp" %>
            <div class="main">
                <p>Welcome <span>${sessionScope.username}</span></p>
                <c:if test="${error ne null}">
                    <script src="js/TakeQuizAlertInRange.js" type="text/javascript"></script>
                </c:if>

                <p>Enter number of questions:</p>
                <form action="takequiz" id="frm1" method="GET">
                    <div>
                        <input type="number" name="chosenQuizzes" size="5" required="required"/>
                    </div>
                    <div>
                        <input type="submit" value="Start"/>
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>
