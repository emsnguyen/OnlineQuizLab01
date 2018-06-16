<%-- 
    Document   : Header
    Created on : May 24, 2018, 9:48:55 AM
    Author     : lenovo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="${pageContext.servletContext.contextPath}/css/Header.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="header">
            <a href="Home.jsp">Home</a>
            <a href="takequiz">Take Quiz</a>
            <a href="makequiz">Make Quiz</a>
            <a href="managequiz">Manage Quiz</a>
            <c:if test="${sessionScope.username != null}">
                <a href="logout">Logout</a>
            </c:if>
        </div>
    </body>
</html>
