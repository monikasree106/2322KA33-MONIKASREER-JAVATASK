package day5;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class taskpost5 {

    static ArrayList<String> studentNames = new ArrayList<>();
    static HashMap<Integer, String> studentCourses = new HashMap<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n--- Mini Student Management App ---");
            System.out.println("1. Add Student and Course");
            System.out.println("2. Search Student by ID");
            System.out.println("3. Delete Student by ID");
            System.out.println("4. Display All Students");
            System.out.println("5. Save to File");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            while (!sc.hasNextInt()) {
                System.out.println("Enter a valid number!");
                sc.nextLine();
                System.out.print("Enter your choice: ");
            }
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> searchStudent();
                case 3 -> deleteStudent();
                case 4 -> displayAll();
                case 5 -> saveToFile();
                case 6 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice.");
            }

        } while (choice != 6);
    }

    static void addStudent() {
        System.out.print("Enter student ID: ");
        int id;
        while (!sc.hasNextInt()) {
            System.out.println("Invalid ID! Try again.");
            sc.nextLine();
        }
        id = sc.nextInt();
        sc.nextLine();

        if (studentCourses.containsKey(id)) {
            System.out.println("Student ID already exists.");
            return;
        }

        System.out.print("Enter student name: ");
        String name = sc.nextLine();
        System.out.print("Enter course name: ");
        String course = sc.nextLine();

        studentNames.add(name);
        studentCourses.put(id, course);
        System.out.println("Student added successfully.");
    }

    static void searchStudent() {
        System.out.print("Enter student ID to search: ");
        int id = sc.nextInt();
        sc.nextLine();

        if (studentCourses.containsKey(id)) {
            System.out.println("Student ID: " + id + ", Course: " + studentCourses.get(id));
        } else {
            System.out.println("Student not found.");
        }
    }

    static void deleteStudent() {
        System.out.print("Enter student ID to delete: ");
        int id = sc.nextInt();
        sc.nextLine();

        if (studentCourses.containsKey(id)) {
            studentCourses.remove(id);
            System.out.println("Student with ID " + id + " deleted.");
        } else {
            System.out.println("Student ID not found.");
        }
    }

    static void displayAll() {
        if (studentCourses.isEmpty()) {
            System.out.println("No students available.");
            return;
        }

        System.out.println("\n--- All Students ---");
        for (Map.Entry<Integer, String> entry : studentCourses.entrySet()) {
            System.out.println("ID: " + entry.getKey() + ", Course: " + entry.getValue());
        }
    }

    static void saveToFile() {
        try {
            FileWriter writer = new FileWriter("course_list.txt");
            for (Map.Entry<Integer, String> entry : studentCourses.entrySet()) {
                writer.write("ID: " + entry.getKey() + ", Course: " + entry.getValue() + "\n");
            }
            writer.close();
            System.out.println("Data saved to course_list.txt");
        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }
    }
}
