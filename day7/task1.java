package day7;
// Task 1: Connect to MySQL DB
import java.sql.*;

public class task1 {
    public static void main(String[] args) {
        // Replace with your details
        String url = "jdbc:mysql://localhost:3306/student_db"; 
        String user = "root"; 
        String password = "RAVM"; 

        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Load driver
            Connection con = DriverManager.getConnection(url, user, password); // Connect
            System.out.println("Connection Successful!");
            con.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
