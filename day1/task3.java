package day1;
import java.util.Scanner;
public class task3 
{
    public boolean leap(int year)
    {
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0))
        {
            return true;
        }
        else 
        {
            return false;
        }
    }
    public static void main(String args[]) 
    {
        Scanner ly = new Scanner(System.in);
        System.out.print("Enter the year: ");
        int year = ly.nextInt();
        task3 check = new task3();
        if (check.leap(year))
        {
            System.out.println(year + " is a leap year");
        } 
        else 
        {
            System.out.println(year + " is not a leap year");
        }
        ly.close();
    }
}