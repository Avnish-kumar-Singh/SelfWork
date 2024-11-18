/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author avnis
 */
@WebServlet(urlPatterns = {"/displayproduct"})
public class displayproduct extends HttpServlet {

    //@Override
    protected void doDisplay(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String id = request.getParameter("id");

        String url = "jdbc:mysql://localhost:3306/midd";
        String user = "root";
        String pwd = "";

        try (PrintWriter out = response.getWriter()) {
            Class.forName("com.mysql.jdbc.Driver"); 
            Connection con = DriverManager.getConnection(url, user, pwd);

            
            PreparedStatement ps = con.prepareStatement("SELECT * FROM semm WHERE id = ?");
            ps.setString(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                // Display the product details
                out.print("<h3>Product Details..!!,whom you used to see :</h3>");
                out.print("<p>ID: " + rs.getString("id") + "</p>");
                out.print("<p>Product Name: " + rs.getString("productname") + "</p>");
                out.print("<p>Category: " + rs.getString("catogry") + "</p>");
                out.print("<p>Date: " + rs.getString("date") + "</p>");
            } else {
               // out.print("<h3>No product found with ID: " + id + "</h3>");
                out.print("<h3> Product id not present in the database.., For collect/Display the data</h3>");
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().print("<h3>Database Connection Error</h3>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
             throws ServletException, IOException {
             doDisplay(request, response);  
      }

      @Override
      public String getServletInfo() {
      return "Servlet that displays product details by ID";
      }
}
