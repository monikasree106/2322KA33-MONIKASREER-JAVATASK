package day4;
import java.io.*;
import java.util.*;
public class taskpost5
{
    static final String FILE_NAME = "employees.txt";
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int choice;
        do 
        {
            System.out.println("\n--- Employee Record System ---");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) 
            {
                case 1: addEmployee(sc); break;
                case 2: viewEmployees(); break;
                case 3: updateEmployee(sc); break;
                case 4: deleteEmployee(sc); break;
                case 5: System.out.println("Exiting..."); break;
                default: System.out.println("Invalid choice!");
            }
        } 
        while (choice != 5);
        sc.close();
    }
    static void addEmployee(Scanner sc) 
    {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true)))
        {
            System.out.print("Enter ID: ");
            String id = sc.next();
            System.out.print("Enter Name: ");
            String name = sc.next();
            System.out.print("Enter Department: ");
            String dept = sc.next();
            System.out.print("Enter Salary: ");
            String salary = sc.next();
            writer.write(id + " " + name + " " + dept + " " + salary);
            writer.newLine();
            System.out.println("Employee added.");
        }
        catch (IOException e) 
        {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
    static void viewEmployees() 
    {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME)))
        {
            String line;
            System.out.println("\n--- Employee Records ---");
            while ((line = reader.readLine()) != null) 
            {
                System.out.println(line);
            }
        }
        catch (IOException e)
        {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
    static void updateEmployee(Scanner sc) 
    {
        System.out.print("Enter ID to update: ");
        String targetId = sc.next();
        File inputFile = new File(FILE_NAME);
        File tempFile = new File("temp.txt");
        boolean found = false;
        try 
        (
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))
        ) 
        {
            String line;
            while ((line = reader.readLine()) != null)
            {
                String[] parts = line.split(" ");
                if (parts[0].equals(targetId)) 
                {
                    found = true;
                    System.out.print("Enter New Name: ");
                    String name = sc.next();
                    System.out.print("Enter New Department: ");
                    String dept = sc.next();
                    System.out.print("Enter New Salary: ");
                    String salary = sc.next();
                    writer.write(targetId + " " + name + " " + dept + " " + salary);
                }
                else
                {
                    writer.write(line);
                }
                writer.newLine();
            }

            if (found) 
            {
                if (!inputFile.delete() || !tempFile.renameTo(inputFile))
                {
                    System.out.println("Could not update file.");
                } 
                else 
                {
                    System.out.println("Employee updated.");
                }
            } 
            else 
            {
                System.out.println("Employee ID not found.");
                tempFile.delete();
            }
        }
        catch (IOException e) 
        {
            System.out.println("Error: " + e.getMessage());
        }
    }
    static void deleteEmployee(Scanner sc)
    {
        System.out.print("Enter ID to delete: ");
        String targetId = sc.next();
        File inputFile = new File(FILE_NAME);
        File tempFile = new File("temp.txt");
        boolean found = false;
        try
        (
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))
        ) 
        {
            String line;
            while ((line = reader.readLine()) != null) 
            {
                String[] parts = line.split(" ");
                if (parts[0].equals(targetId)) 
                {
                    found = true;
                    continue; 
                }
                writer.write(line);
                writer.newLine();
            }
            if (found) 
            {
                if (!inputFile.delete() || !tempFile.renameTo(inputFile)) 
                {
                    System.out.println("Could not update file.");
                }
                else
                {
                    System.out.println("Employee deleted.");
                }
            }
            else
            {
                System.out.println("Employee ID not found.");
                tempFile.delete();
            }
        }
        catch (IOException e)
        {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

