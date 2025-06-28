package day1;
import java.util.Scanner;
public class taskmain4
{
    static int add(int x, int y) 
    {
        return x + y;
    }
    static int sub(int x, int y) 
    {
        return x - y;
    }
    static int mul(int x, int y)
    {
        return x * y;
    }
    static int div(int x, int y) 
    {
        if (y == 0)
        {
            System.out.println("Cannot divide by zero.");
            return 0;
        }
        return x / y;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int choice, a, b;
        while (true) 
        {
            System.out.println("Enter your choice:\n1.Add\n2.Sub\n3.Mul\n4.Div\n5.Exit");
            choice = sc.nextInt();
            if (choice == 5) 
            {
                System.out.println("Stopped");
                break;
            }
            System.out.print("Enter the two numbers: ");
            a = sc.nextInt();
            b = sc.nextInt();
            switch (choice)
            {
                case 1:
                    System.out.println("Result = " + add(a, b));
                    break;
                case 2:
                    System.out.println("Result = " + sub(a, b));
                    break;
                case 3:
                    System.out.println("Result = " + mul(a, b));
                    break;
                case 4:
                    System.out.println("Result = " + div(a, b));
                    break;
                default:
                    System.out.println("Invalid Choice");
                    break;
            }
        }
        sc.close();
    }
}
