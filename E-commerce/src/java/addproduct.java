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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author avnis
 */
@WebServlet(urlPatterns = {"/addproduct"})
public class addproduct extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");

        String id = request.getParameter("id");
        String productname = request.getParameter("productname");
        String catogry = request.getParameter("catogry");
        String date = request.getParameter("date");

        String url = "jdbc:mysql://localhost:3306/midd";
        String user = "root";
        String pwd = "";

        try {
            Class.forName("com.mysql.jdbc.Driver"); 
            Connection con = DriverManager.getConnection(url, user, pwd);

            PreparedStatement ps = con.prepareStatement("INSERT INTO semm VALUES (?, ?, ?, ?)");
            ps.setString(1, id);
            ps.setString(2, productname);
            ps.setString(3, catogry);
            ps.setString(4, date);

            int count = ps.executeUpdate();

            if (count > 0) {
                out.print("<h3>Product added Successfully</h3>");
                RequestDispatcher rd = request.getRequestDispatcher("./addproduct.jsp");
                rd.include(request, response);
            } else {
                out.print("<h3>Error: Product could not be added.</h3>");
                RequestDispatcher rd = request.getRequestDispatcher("./error.jsp");
                rd.include(request, response);
            }

        } catch (Exception e) {
            e.printStackTrace();
            out.print("<h3>Database Connection Error</h3>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);  
    }

    @Override
    public String getServletInfo() {
        return "Servlet that adds products to the database";
    }
}
