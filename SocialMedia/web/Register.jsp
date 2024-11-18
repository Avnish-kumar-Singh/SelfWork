<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Registration Page</title>
    </head>
    <body>
        <h1>Register Yourself Here!!</h1>
        <form action="Register" method="POST">
            Username: <input type="text" name="userName" placeholder="Enter Username"> <br>
            Email: <input type="email" name="userEmail" placeholder="Enter Email"> <br>
            Password: <input type="password" name="password" placeholder="Enter Password"> <br>
            Confirm password:  <input type="password" name="ConfirmPassword" placeholder="Re-Enter Password"> <br>
            <!--Status :  <input type="text" name="status" placeholder="Active/In-Active">-->
            <input type="submit" name="LoginSubmit">
        </form>
    </body>
</html>