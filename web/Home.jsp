<%-- 
    Document   : Home
    Created on : May 24, 2018, 12:06:32 AM
    Author     : lenovo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Home</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/Home.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="top"></div>
        <div class="wrapper">
            <jsp:include page="WEB-INF/Header.jsp"/>
            <br/>
            <form action="login" method="POST" id="loginForm">
                <h3 class="lblLogin">Login Form</h3>
                <table>
                    <tbody>
                        <tr>
                            <td>User Name: </td>
                            <td>
                                <input type="text" value="${username}" name="username" required="required"/>
                            </td>
                        </tr>
                        <tr>
                            <td>Password: </td>
                            <td>
                                <input type="password" value="${password}" name="password" required="required"/>
                            </td>
                        </tr>
                        <tr>
                            <td></td>
                            <td>
                                <input type="submit" value="Sign in" class="btnLogin"/>
                                <a href="register" class="aResgister">Register</a>
                            </td>
                        </tr>
                    </tbody>
                </table>
                <c:if test="${error ne null}">
                    <span class="error">${error}</span>
                </c:if>
            </form>
        </div>
        <c:if test="${username eq null}">
            <script src="js/HomeAlertLogin.js" type="text/javascript"></script>
        </c:if>
    </body>
</html>
