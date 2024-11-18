<%-- 
    Document   : HomePage
    Created on : 1 Oct, 2024, 9:49:18 AM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>HomePage</title>
    </head>
    <body>
        <h1> Welcome <%=request.getAttribute("username") %> !! </h1>
        <!--<h3> Username - </h3>-->
        <h3> Your Email:<%=request.getAttribute("email") %></h3>
        
    </body>    
</html>