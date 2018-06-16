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
        <title>Manage Quiz</title>
        <link href="${pageContext.servletContext.contextPath}/css/Home.css" rel="stylesheet" type="text/css"/>
        <link href="${pageContext.servletContext.contextPath}/css/TakeQuiz.css" rel="stylesheet" type="text/css"/>
        <link href="${pageContext.servletContext.contextPath}/css/ManageQuiz.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="top"></div>
        <div class="wrapper">
            <%@include file="Header.jsp" %>
            <div class="main">
                <table cellpadding="5">
                    <tr>
                        <td class="firstTd">
                            Number of questions: <span>${quizzes.size()}</span>
                        </td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>
                            <span>Question</span>
                        <td>
                            <span>DateCreated</span>
                        </td>
                    </tr>
                    <c:forEach items="${quizzes}" var="q">
                        <tr>
                            <td>
                                ${q.content} 
                            </td>
                            <td>
                                <fmt:formatDate value="${q.dateCreated}" pattern="dd-MMM-yyyy"/>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
            <div class="footer">
                ${paging}
            </div>
        </div>
    </body>
</html>
