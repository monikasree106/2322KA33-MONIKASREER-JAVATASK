package day7;
import java.sql.*;
import java.util.Scanner;
public class task2
{
    public static void main(String[] args) 
    {
        String url = "jdbc:mysql://localhost:3306/task1";
        String user = "root"; 
        String password = "RAVM";
        Scanner sc = new Scanner(System.in);
        try (Connection conn = DriverManager.getConnection(url, user, password))
        {
            System.out.println("✅ Connected to MySQL database.");
            System.out.print("Enter student name: ");
            String name = sc.nextLine();
            System.out.print("Enter student department: ");
            String dept = sc.nextLine();
            String query = "INSERT INTO student (name, department) VALUES (?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, name);
            pstmt.setString(2, dept);
            int rows = pstmt.executeUpdate();
            if (rows > 0) 
            {
                System.out.println("🎉 Student inserted successfully.");
            }
            else 
            {
                System.out.println("⚠️ Insertion failed.");
            }
        }
        catch (SQLException e) 
        {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }
}


