<%-- 
    Document   : deleteproduct
    Created on : 30 Oct, 2024, 6:09:10 PM
    Author     : avnis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="deleteproduct" method="DELETE">
            <h3>Enter the product id ,for deleted from the database</h3>
            Product_Id:<input type="number" name="id"><br>
            <input type="submit" value="submit">
        </form>
    </body>
</html>
