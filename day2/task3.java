package day2;
import java.util.Scanner;
public class task3
{
    public static void main(String[] args)
    {
        Scanner san = new Scanner(System.in);
        System.out.print("Enter the Sentence: ");
        String sen = san.nextLine();
        String[] words = sen.trim().split("\\s+");
        System.out.println("The Words in the Sentence are:");
        for (String word : words) 
        {
            System.out.println(word);
        }
        san.close();
    }
}