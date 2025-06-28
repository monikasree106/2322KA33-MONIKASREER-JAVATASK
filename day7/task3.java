package day7;

import java.sql.*;

public class task3 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/task3";
        String user = "root";
        String password = "RAVM";

        try (Connection conn = DriverManager.getConnection(url, user, password)) 
        {
            String createTable = "CREATE TABLE IF NOT EXISTS student ("
                    + "id INT AUTO_INCREMENT PRIMARY KEY, "
                    + "name VARCHAR(100) NOT NULL, "
                    + "department VARCHAR(100) NOT NULL)";
            conn.createStatement().executeUpdate(createTable);
            String insertData = "INSERT INTO student (name, department) VALUES "
                    + "('Moni', 'CSE'), "
                    + "('Anu', 'ECE'), "
                    + "('Ravi', 'IT')";
            conn.createStatement().executeUpdate(insertData);
            String query = "SELECT * FROM student";
            ResultSet rs = conn.createStatement().executeQuery(query);
            System.out.println("ID\tName\tDepartment");
            System.out.println("----------------------------");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String dept = rs.getString("department");
                System.out.println(id + "\t" + name + "\t" + dept);
            }
        } 
        catch (SQLIntegrityConstraintViolationException dup) 
        {
            System.out.println("⚠️ Duplicate data skipped.");
        }
        catch (SQLException e) 
        {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }
}
