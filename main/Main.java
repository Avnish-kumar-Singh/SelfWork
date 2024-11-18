//package crud.operation;

import java.sql.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Database connection details
        String url = "jdbc:mysql://localhost:3306/stu";
        String username = "root";
        String password = "";

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        Scanner sc = new Scanner(System.in);
        
        try {
            // Load Driver
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, password);

            //System.out.println("Enter your choice:");
            System.out.println("Menu is Below.");
            System.out.println("1. Read All Data");
            System.out.println("2. Insert Data");
            System.out.println("Enter your choice:");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline left-over

            switch (choice) {
                case 1:
                    // Read Data
                    try {
                        st = conn.createStatement();
                        rs = st.executeQuery("SELECT * FROM cs");

                        while (rs.next()) {
                            String name = rs.getString("name");
                            int rollNo = rs.getInt("rollNo");
                            System.out.println("Name: " + name);
                            System.out.println("Roll No:"+ rollNo);
                        }
                    } catch (SQLException e) {
                       // System.out.println("Error while reading data: " + e.getMessage());
                        System.out.println(e);
                    }
                    break;

                case 2:
                    // Insert Data
                    try {
                        System.out.println("Enter name:");
                        String name = sc.nextLine();
                        System.out.println("Enter roll number:");
                        int rollNo = sc.nextInt();

                        String query = "INSERT INTO cs (name, rollNo) VALUES (?, ?)";
                        PreparedStatement pst = conn.prepareStatement(query);
                        pst.setString(1, name);
                        pst.setInt(2, rollNo);

                        int rowsAffected = pst.executeUpdate();
                        System.out.println(rowsAffected + " row(s) affected.");
                    } catch (SQLException e) {
                        //System.out.println("Error while inserting data: " + e.getMessage());
                        System.out.println(e);
                    }
                    break;

                default:
                    System.out.println("Invalid choice. Please select either 1 or 2.");
            }

        } catch (Exception e) {
           // System.out.println("Error: " + e.getMessage());
            System.out.println(e);
        } finally {
            // Close resources
            try {
                if (rs != null) rs.close();
                if (st != null) st.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("Error closing resources: " + e.getMessage());
            }
        }
    }
}
