package day3;
import java.util.Scanner;
class Student 
{
    String name;
    int rollNo;
    int[] marks = new int[3];
    void getDetails(Scanner sc)
    {
        System.out.print("Enter Student Name: ");
        name = sc.nextLine();
        System.out.print("Enter Roll Number: ");
        rollNo = sc.nextInt();
        System.out.println("Enter marks for 3 subjects:");
        for(int i = 0; i < 3; i++)
        {
            System.out.print("Subject " + (i + 1) + ": ");
            marks[i] = sc.nextInt();
        }
        sc.nextLine(); 
    }
    int calculateTotal()
    {
        int total = 0;
        for(int mark : marks) 
        {
            total += mark;
        }
        return total;
    }
    double calculateAverage()
    {
        return calculateTotal() / 3.0;
    }
    void displayDetails()
    {
        System.out.println("\n--- Student Details ---");
        System.out.println("Name       : " + name);
        System.out.println("Roll No    : " + rollNo);
        System.out.println("Marks      : ");
        for(int i = 0; i < 3; i++)
        {
            System.out.println("Subject " + (i + 1) + ": " + marks[i]);
        }
        System.out.println("Total Marks: " + calculateTotal());
        System.out.println("Average    : " + calculateAverage());
    }
}
public class taskmain4
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Student student = new Student();
        student.getDetails(sc);
        student.displayDetails();
        sc.close();
    }
}
