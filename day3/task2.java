package day3;
import java.util.Scanner;
class Person 
{
    String name;
    int age;
    public void getPersonDetails(Scanner sc)
    {
        System.out.print("Enter Name: ");
        name = sc.nextLine();
        System.out.print("Enter Age: ");
        age = sc.nextInt();
        sc.nextLine();
    }
    public void displayPersonDetails() 
    {
        System.out.println("Name : " + name);
        System.out.println("Age  : " + age);
    }
}
class Employee extends Person 
{
    String empId;
    double basicSalary;
    public void getEmployeeDetails(Scanner sc) 
    {
        getPersonDetails(sc);
        System.out.print("Enter Employee ID: ");
        empId = sc.nextLine();
        System.out.print("Enter Basic Salary: ");
        basicSalary = sc.nextDouble();
    }
    public double calculateSalary() {
        double hra = 0.15 * basicSalary; 
        double da = 0.10 * basicSalary; 
        return basicSalary + hra + da;
    }
    public void displayEmployeeDetails()
    {
        displayPersonDetails();
        System.out.println("Employee ID  : " + empId);
        System.out.println("Basic Salary : ₹" + basicSalary);
        System.out.println("Total Salary : ₹" + calculateSalary());
    }
}
public class task2
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Employee emp = new Employee();
        emp.getEmployeeDetails(sc);
        System.out.println("\n--- Employee Details ---");
        emp.displayEmployeeDetails();
        sc.close();
    }
}
