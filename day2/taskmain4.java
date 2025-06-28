package day2;
import java.util.Scanner;
public class taskmain4 
{
    public static void main(String[] args) 
    {
        Scanner san = new Scanner(System.in);
        System.out.println("Enter the Sentence : ");
        String con = san.nextLine();
        String[] words = con.trim().split("\\s+");
        int wordcount = words.length;
        int charcount = con.replace(" ", "").length();
        String reversed = new StringBuilder(con).reverse().toString();
        String longword = "";
        for(String word : words)
        {
            if(word.length() > longword.length()) 
            {
                longword = word;
            }
        }
        System.out.println("STRING ANALYSIS");
        System.out.println("WORD COUNT : " + wordcount);
        System.out.println("CHARACTER COUNT : " + charcount);
        System.out.println("REVERSED STRING : " + reversed);
        System.out.println("LONGEST WORD : " + longword);
        san.close(); 
    }
}
