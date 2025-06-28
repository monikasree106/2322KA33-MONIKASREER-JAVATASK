package day3;
import java.util.Scanner;
public class task3 
{
    static int sum(int a, int b)
    {
        return a + b;
    }
    static double sum(double a, double b)
    {
        return a + b;
    }
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first integer: ");
        int int1 = sc.nextInt();
        System.out.print("Enter second integer: ");
        int int2 = sc.nextInt();
        int intResult = sum(int1, int2);
        System.out.print("Enter first double: ");
        double double1 = sc.nextDouble();
        System.out.print("Enter second double: ");
        double double2 = sc.nextDouble();
        double doubleResult = sum(double1, double2);
        System.out.println("Sum of integers: " + intResult);
        System.out.println("Sum of doubles : " + doubleResult);
        sc.close();
    }
}

