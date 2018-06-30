<%-- 
    Document   : Register
    Created on : May 24, 2018, 9:49:11 AM
    Author     : lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Page</title>
        <link href="${pageContext.servletContext.contextPath}/css/Home.css" rel="stylesheet" type="text/css"/>
        <link href="${pageContext.servletContext.contextPath}/css/TakeQuiz.css" rel="stylesheet" type="text/css"/>
        <link href="${pageContext.servletContext.contextPath}/css/Register.css" rel="stylesheet" type="text/css"/>

    </head>
    <body>
        <div class="top"></div>
        <div class="wrapper">
            <%@include file="Header.jsp" %>
            <div class="main">
                <h3 class="lblLogin">Registration Form</h3>
                <form action="register" method="POST">
                    <table>
                        <tbody>
                            <tr>
                                <td>Username: </td>
                                <td>
                                    <input type="text" value="${username}" name="username" required="required"/>
                                </td>
                                <td>
                                    <span>${invalidUsername}</span>
                                </td>
                            </tr>
                            <tr>
                                <td>Password: </td>
                                <td>
                                    <input type="password" name="password" required="required"/>
                                </td>
                                <td>
                                    <span>${invalidPassword}</span>
                                </td>
                            </tr>
                            <tr>
                                <td>User Type: </td>
                                <td>
                                    <select name="typeID">
                                        <c:forEach items="${types}" var="t">
                                        <option value="${t.ID}">${t.name}</option>
                                        </c:forEach>
                                    </select>
                                </td>
                                <td>
                                    <span>${invalidTypeID}</span>
                                </td>
                            </tr>
                            <tr>
                                <td>Email: </td>
                                <td>
                                    <input type="text" value="${email}" name="email" required="required"/>
                                </td>
                                <td>
                                    <span>${invalidEmail}</span>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                   
                                </td>
                                <td>
                                    <input type="submit" value="Register"/>
                                </td>
                                <td></td>
                            </tr>
                        </tbody>
                    </table>
                </form>
            </div>
        </div>
    </body>
</html>
