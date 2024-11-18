
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author avnis
 */
@WebServlet("/calculator")
public class calculator extends HttpServlet {
    protected void doPost(HttpServletRequest request, 
                         HttpServletResponse response) throws IOException, ServletException {
        
        //PrintWriter is a class which prints response from server to client
        PrintWriter pw = response.getWriter();
        
        int n1 = Integer.parseInt(request.getParameter("n1"));
        int n2 = Integer.parseInt(request.getParameter("n2"));
        RequestDispatcher rd=request.getRequestDispatcher("/index1.html");
        response.setContentType("text/html");
        rd.include(request,response);
        int sum, sub, mul;
        float div;
        
        String operation = request.getParameter("cal");
                
        if(operation.equals("+")){
             sum = n1+n2;
             pw.write("Sum = "+sum);
        }else if(operation.equals("-")){
            sub = n1-n2;
             pw.write("Difference = "+sub);
        } else if(operation.equals("*")){
            mul = n1*n2;
             pw.write("Product = "+mul);
        }else if(operation.equals("/")){
            div = (float)n1/n2;
             pw.write("Division = "+div);
        }      
        
    }
}
