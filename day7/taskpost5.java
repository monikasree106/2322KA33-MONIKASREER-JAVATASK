package day7;

import java.sql.*;
import java.util.Scanner;

public class taskpost5 {
    static final String URL = "jdbc:mysql://localhost:3306/taskpost5";
    static final String USER = "root"; 
    static final String PASSWORD = "RAVM"; 
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            createTable(conn);

            int choice;
            do {
                System.out.println("\n=== Inventory Management ===");
                System.out.println("1. Add Product");
                System.out.println("2. View All Products");
                System.out.println("3. Search Product by Name");
                System.out.println("4. Exit");
                System.out.print("Enter choice: ");
                choice = sc.nextInt();
                sc.nextLine(); // consume newline

                switch (choice) {
                    case 1: addProduct(conn); break;
                    case 2: viewProducts(conn); break;
                    case 3: searchProduct(conn); break;
                    case 4: System.out.println("Exiting..."); break;
                    default: System.out.println("Invalid choice.");
                }
            } while (choice != 4);

        } catch (SQLException e) {
            System.out.println("❌ Database Error: " + e.getMessage());
        }
    }

    static void createTable(Connection conn) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS products ("
                   + "id INT AUTO_INCREMENT PRIMARY KEY, "
                   + "name VARCHAR(100), "
                   + "category VARCHAR(100), "
                   + "price DOUBLE, "
                   + "quantity INT)";
        conn.createStatement().executeUpdate(sql);
    }

    static void addProduct(Connection conn) throws SQLException {
        System.out.print("Enter product name: ");
        String name = sc.nextLine();
        System.out.print("Enter category: ");
        String category = sc.nextLine();
        System.out.print("Enter price: ");
        double price = sc.nextDouble();
        System.out.print("Enter quantity: ");
        int qty = sc.nextInt();

        String sql = "INSERT INTO products (name, category, price, quantity) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, name);
        ps.setString(2, category);
        ps.setDouble(3, price);
        ps.setInt(4, qty);
        ps.executeUpdate();
        System.out.println("✅ Product added.");
    }

    static void viewProducts(Connection conn) throws SQLException {
        String sql = "SELECT * FROM products";
        ResultSet rs = conn.createStatement().executeQuery(sql);
        System.out.println("\nID\tName\tCategory\tPrice\tQty");
        System.out.println("--------------------------------------------");
        while (rs.next()) {
            System.out.println(rs.getInt("id") + "\t" + rs.getString("name") + "\t" +
                    rs.getString("category") + "\t" + rs.getDouble("price") + "\t" +
                    rs.getInt("quantity"));
        }
    }

    static void searchProduct(Connection conn) throws SQLException {
        System.out.print("Enter product name to search: ");
        String search = sc.nextLine();

        String sql = "SELECT * FROM products WHERE name LIKE ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, "%" + search + "%");
        ResultSet rs = ps.executeQuery();

        boolean found = false;
        while (rs.next()) {
            if (!found) {
                System.out.println("\nID\tName\tCategory\tPrice\tQty");
                System.out.println("--------------------------------------------");
                found = true;
            }
            System.out.println(rs.getInt("id") + "\t" + rs.getString("name") + "\t" +
                    rs.getString("category") + "\t" + rs.getDouble("price") + "\t" +
                    rs.getInt("quantity"));
        }

        if (!found) {
            System.out.println("⚠️ No product found with name: " + search);
        }
    }
}
