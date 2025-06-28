package day2;
import java.util.Scanner;
public class task1
{
    public static void main(String[] args) 
    {
        Scanner val = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = val.nextInt();
        int[] numbers = new int[n];
        int[] reversed = new int[n];
        System.out.println("Enter the numbers:");
        System.out.println("Array: ");
        for (int i = 0; i < n; i++) 
        {
            numbers[i] = val.nextInt();
        }

        for (int i = 0; i < n; i++)
        {
            reversed[i] = numbers[n - 1 - i];
        }

        System.out.println("Reversed Array:");
        for (int num : reversed)
        {
            System.out.println(num + " ");
        }
        val.close();
    }
}