import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/Login"})
public class Login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        
        PrintWriter pw = response.getWriter();
        
        /**
         * Here we will perform Read operation from database
         */
        String url = "jdbc:mysql://localhost:3306/social_media";
        String user = "root";
        String pwd = "";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pwd);
            
            String query = "SELECT * FROM apna_adda WHERE userName = ?";
            PreparedStatement ps = con.prepareStatement(query);
            
            ps.setString(1, userName);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                String userNameFromDb = rs.getString("userName");
                String passwordFromDb = rs.getString("password");
                String emailFromDb = rs.getString("email");
                
                if(password.equals(passwordFromDb)){
                    pw.write("<h3>User verified successfully</h3>");
                   
                    RequestDispatcher rd = request.getRequestDispatcher("./HomePage.jsp");
                    request.setAttribute("username", userNameFromDb);
                    request.setAttribute("email", emailFromDb);
                    
                    rd.include(request, response);
                    
                }else{
                    pw.write("<h3>Userid or password is incorrect</h3>");
                    
                    RequestDispatcher rd = request.getRequestDispatcher("./Register.jsp");
                    rd.include(request, response);
                }
                
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }

}