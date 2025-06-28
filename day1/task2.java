package day1;
import java.util.Scanner;
public class task2 
{
    public static void main(String args[])
    {
        Scanner obj = new Scanner(System.in);
        System.out.print("Enter the principal amount: ");
        double p = obj.nextDouble();
        System.out.print("Enter the number of years: ");
        double y = obj.nextDouble();
        System.out.print("Enter the rate of interest: ");
        double r = obj.nextDouble();
        if (p > 0 && y > 0 && r > 0)
        {
            double percent = (p * y * r) / 100;
            System.out.println("Simple Interest (SI): " + percent);
        }
        else 
        {
            System.out.println("All input values must be greater than 0.");
        }
        obj.close();
    }
}