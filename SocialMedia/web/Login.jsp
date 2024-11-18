<%-- 
    Document   : Login
    Created on : 1 Oct, 2024, 9:48:57 AM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Login Page</title>
    </head>
    <body>
        <h1>Login to My Social-Media WebPage!! </h1>
        <form action="Login" method="POST">
            UserName: <input type="text" name="userName"> <br>
            Password: <input type="password" name="password"> <br>
            
            <input type="submit" name="loginSubmit">  
        </form>
    </body>
</html>