<%-- 
    Document   : loginPage
    Created on : Sep 18, 2017, 1:19:35 PM
    Author     : 727525
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1>Login</h1>
        <form action="LoginServlet" method="post"> 
            Username:
            <input type="text" name="username" value="${username}">
            <br>Password:
            <input type="text" name="password" value="${password}">
            <br>
            <input type="submit" value="Login">
        </form>
        <br>${message}
    </body>
</html>
