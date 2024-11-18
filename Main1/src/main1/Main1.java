//package crud.operation;

import java.sql.*;
import java.util.Scanner;
//import java.sql.Statement;
//import java.sql.ResultSet;
//import java.sql.DriverManager;

public class Main1 {
    
    public static void main(String[] args) {
        // TODO code application logic here
        String url = "jdbc:mysql://localhost:3306/stu";
        String username = "root";
        String password = "";
        //Scanner sc = new Scanner(System.in);
        
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
       
        try{ //for read
            //Load Driver
            Class.forName("com.mysql.jdbc.Driver");
            
            conn = DriverManager.getConnection(url, username, password);
            st = conn.createStatement();
            
            rs = st.executeQuery("select * from cs");
            
            while(rs.next()){
                String name = rs.getString("name");
                int rollNo = rs.getInt("rollNo");
                
                System.out.println("Name : "+name+" Roll : "+rollNo);
            }
        }catch(Exception e){
            System.out.println(e);
        }
        
       
        try{ //for update 
            Class.forName("com.mysql.jdbc.Driver");
            Scanner sc = new Scanner(System.in);
            
            conn = DriverManager.getConnection(url,username,password);
            //st = conn.createConnection(url, username, password);
    
            String query = "insert into cs values(?, ?)";
            //System.out.println("enter rollno. =");
           // int rollno= sc.nextInt();
            System.out.println("enter name = ");
            String name=sc.nextLine();
            System.out.println("enter rollno. =");
            int rollno= sc.nextInt();
            PreparedStatement pst = conn.prepareStatement(query);
            
            pst.setString(1, name);
            pst.setInt(2, rollno);
            
            System.out.println(pst.executeUpdate()+" row(s) affected");
            
            
           }catch(Exception e){
               System.out.print(e);
           }
        
    }
       
    
}

