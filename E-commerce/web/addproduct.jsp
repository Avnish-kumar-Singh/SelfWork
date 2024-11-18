<%-- 
    Document   : addproduct
    Created on : 30 Oct, 2024, 6:08:26 PM
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
        <form action="addproduct" method="POST">
            <h3>Insert the Product details Which is required...</h3>
            Product_Id:<input type="number" name="id"><br>
            Product_Name:<input type="text" name="productname"><br>
            Product_Catgry:<input type="text" name="catogry"><br>
            Mgf_Date:<input type="date" name="date"><br>
            <input type="submit" value="submit">
            
        </form>
    </body>
</html>
