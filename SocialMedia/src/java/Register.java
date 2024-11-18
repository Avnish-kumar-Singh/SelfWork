/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.servlet.RequestDispatcher;


@WebServlet("/Register") //URL mapping - Annotation
public class Register extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        PrintWriter out = response.getWriter();
        
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");
        String email = request.getParameter("userEmail");
//        String status = request.getParameter("Status");
        
        String url = "jdbc:mysql://localhost:3306/social_media";
        String user = "root";
        String pwd = "";
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pwd);
            
            PreparedStatement ps = con.prepareStatement("insert into apna_adda values(?,?,?)");
        
            ps.setString(1, userName);
            ps.setString(2, password);
            ps.setString(3, email);
//            ps.setString(4, status);
            
            int count = ps.executeUpdate();
            
            if(count > 0){
                out.print("<h3>User Registered Successfully</h3>");
                response.setContentType("text/html");
                RequestDispatcher rd = request.getRequestDispatcher("./Login.jsp");
                rd.include(request, response);
            } else {
                out.print("<h3>Some Error Occurred</h3>");
                response.setContentType("text/html");
                RequestDispatcher rd = request.getRequestDispatcher("./Register.jsp");
                rd.include(request, response);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        if (password.equals(confirmPassword)){
            //We are going to put values in database
            
        }
                
    }

    
}