package day5;

import java.util.*;

class Student {
    int id;
    String name;

    // Constructor to initialize id and name
    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // equals method for object comparison
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student s = (Student) o;
        return id == s.id && name.equals(s.name);
    }

    // hashCode method for use in HashMap
    public int hashCode() {
        return Objects.hash(id, name);
    }

    // For display
    public String toString() {
        return id + " - " + name;
    }
}

public class taskmain4 {
    static ArrayList<Student> studentList = new ArrayList<>();
    static HashMap<Student, List<String>> courseMap = new HashMap<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n--- Student Course Enrollment System ---");
            System.out.println("1. Add Student and Courses");
            System.out.println("2. Remove Student");
            System.out.println("3. Display Students and Courses");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            while (!sc.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number (1-4).");
                sc.nextLine();
                System.out.print("Enter your choice: ");
            }

            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> removeStudent();
                case 3 -> displayStudents();
                case 4 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 4);
    }

    static void addStudent() {
        int id;
        while (true) {
            System.out.print("Enter student ID: ");
            if (sc.hasNextInt()) {
                id = sc.nextInt();
                sc.nextLine(); // consume newline
                break;
            } else {
                System.out.println("Invalid input. Please enter a valid integer ID.");
                sc.nextLine(); // clear invalid input
            }
        }

        System.out.print("Enter student name: ");
        String name = sc.nextLine();

        Student student = new Student(id, name);
        studentList.add(student);

        List<String> courses = new ArrayList<>();
        System.out.println("Enter course names (type 'done' to finish):");
        while (true) {
            String course = sc.nextLine();
            if (course.equalsIgnoreCase("done")) break;
            courses.add(course);
        }

        courseMap.put(student, courses);
        System.out.println("Student and courses added.");
    }

    static void removeStudent() {
        System.out.print("Enter student ID to remove: ");
        int id;
        while (!sc.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid student ID.");
            sc.nextLine();
        }
        id = sc.nextInt();
        sc.nextLine();

        Iterator<Student> itr = studentList.iterator();
        boolean found = false;

        while (itr.hasNext()) {
            Student s = itr.next();
            if (s.id == id) {
                itr.remove();
                courseMap.remove(s);
                System.out.println("Student removed.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student ID not found.");
        }
    }

    static void displayStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No students enrolled.");
            return;
        }

        System.out.println("\n--- Student List with Courses ---");
        Iterator<Student> itr = studentList.iterator();
        while (itr.hasNext()) {
            Student s = itr.next();
            System.out.println(s + " => " + courseMap.get(s));
        }
    }
}


