package day7;

import java.sql.*;
import java.util.Scanner;

public class taskmain4 {
    static final String URL = "jdbc:mysql://localhost:3306/taskmain4";
    static final String USER = "root";
    static final String PASSWORD = "RAVM1"; 

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {

            createTable(conn); 

            int choice;
            do {
                System.out.println("\n--- Student DB Manager ---");
                System.out.println("1. Add Student");
                System.out.println("2. View All Students");
                System.out.println("3. Delete Student by ID");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");
                choice = sc.nextInt();
                sc.nextLine(); 

                switch (choice) {
                    case 1:
                        addStudent(conn);
                        break;
                    case 2:
                        viewStudents(conn);
                        break;
                    case 3:
                        deleteStudent(conn);
                        break;
                    case 4:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            } while (choice != 4);

        } catch (SQLException e) {
            System.out.println("❌ Database Error: " + e.getMessage());
        }
    }

    static void createTable(Connection conn) throws SQLException {
        String create = "CREATE TABLE IF NOT EXISTS student ("
                + "id INT AUTO_INCREMENT PRIMARY KEY, "
                + "name VARCHAR(100), "
                + "department VARCHAR(100))";
        conn.createStatement().executeUpdate(create);
    }

    static void addStudent(Connection conn) throws SQLException {
        System.out.print("Enter student name: ");
        String name = sc.nextLine();
        System.out.print("Enter department: ");
        String dept = sc.nextLine();

        String insert = "INSERT INTO student (name, department) VALUES (?, ?)";
        PreparedStatement ps = conn.prepareStatement(insert);
        ps.setString(1, name);
        ps.setString(2, dept);
        int result = ps.executeUpdate();

        if (result > 0)
            System.out.println("✅ Student added.");
    }

    static void viewStudents(Connection conn) throws SQLException {
        String select = "SELECT * FROM student";
        ResultSet rs = conn.createStatement().executeQuery(select);

        System.out.println("\nID\tName\tDepartment");
        System.out.println("----------------------------");
        while (rs.next()) {
            System.out.println(rs.getInt("id") + "\t" + rs.getString("name") + "\t" + rs.getString("department"));
        }
    }

    static void deleteStudent(Connection conn) throws SQLException {
        System.out.print("Enter student ID to delete: ");
        int id = sc.nextInt();

        String delete = "DELETE FROM student WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(delete);
        ps.setInt(1, id);
        int result = ps.executeUpdate();

        if (result > 0)
            System.out.println("✅ Student deleted.");
        else
            System.out.println("❌ No student found with that ID.");
    }
}
