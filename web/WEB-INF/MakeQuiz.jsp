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
        <link href="${pageContext.servletContext.contextPath}/css/Home.css" rel="stylesheet" type="text/css"/>
        <link href="${pageContext.servletContext.contextPath}/css/TakeQuiz.css" rel="stylesheet" type="text/css"/>
        <link href="${pageContext.servletContext.contextPath}/css/MakeQuiz.css" rel="stylesheet" type="text/css"/>
        <title>Make Quiz</title>
    </head>
    <body>
        <div class="top"></div>
        <div class="wrapper">
            <%@include file="Header.jsp" %>
            <div class="main">
                <form action="makequiz" method="POST">
                    <table>
                        <tr>
                            <td>Question:  </td>
                            <td>
                                <textarea class="txtQuestion" name="content" required="required"></textarea>
                            </td>
                        </tr>
                        <tr>
                            <td>Option 1: </td>
                            <td>
                                <textarea name="optA" required="required"></textarea>
                            </td>
                        </tr>
                        <tr>
                            <td>Option 2: </td>
                            <td>
                                <textarea name="optB" required="required"></textarea>
                            </td>
                        </tr>
                        <tr>
                            <td>Option 3: </td>
                            <td>
                                <textarea name="optC"></textarea>
                            </td>
                        </tr>
                        <tr>
                            <td>Option 4: </td>
                            <td>
                                <textarea name="optD"></textarea>
                            </td>
                        </tr>
                    </table>
                    <div class="options">
                        Answer(s): &nbsp;
                        <input type="checkbox" id="opt1" value="1" name="cb1">Option 1
                        <input type="checkbox" id="opt2" value="2" name="cb2">Option 2
                        <input type="checkbox" id="opt3" value="3" name="cb3">Option 3
                        <input type="checkbox" id="opt4" value="4" name="cb4">Option 4
                    </div>
                    <div>
                        <input type="submit" value="Save"/>
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>
